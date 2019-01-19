/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExternalRelations;

import DB.CompanyTable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Cherine Hussein
 */
public class ExternalRelationsManager extends UnicastRemoteObject implements ExternalRelationsManagerInt{
    private static ExternalRelationsManager externalRelations=null;
    private ArrayList<Company> companies;
    private final CompanyTable companyTable;

    public ExternalRelationsManager() throws RemoteException {
        companies =new ArrayList<>();
        companyTable = new CompanyTable();
    }
    
    public static ExternalRelationsManager getExternalRelationsManager ()throws RemoteException
    {
        if(externalRelations==null)
        {
            externalRelations= new ExternalRelationsManager();
            return externalRelations;
        }
        else 
            return externalRelations;
    }
    
    
    
   
    public void addNewCompany(String name, int ID, String address, String specialization, ContractInt contract, String contactEmail)throws RemoteException
    {
        Company newCompany= new Company(name,ID, address, specialization, (Contract)contract, contactEmail); 
        companyTable.insertCompany(newCompany);
    }
    
    public ContractInt createNewContract(String type, int ID, String date, String dateOfExpiry, String status, String description) throws RemoteException 
    {
        Contract newContract=new Contract(type, ID,date,dateOfExpiry,status,description);
        return newContract;
   
    }
    
    public void addContractToCompany(int companyId,String type, int ID, String date, String dateOfExpiry, String status, String description)throws RemoteException
    {
        ContractInt contractObj=createNewContract(type,ID,date,dateOfExpiry,status,description);
        CompanyInt companyObj=viewCompanyByID(companyId);
        companyObj.setContract(contractObj);
        companyTable.updateCompany((Company)companyObj);
    }  
    
    public String removeContract(int companyID)throws RemoteException{
        CompanyInt companyObj=viewCompanyByID(companyID);
        String removal;
        if(companyObj==null)
            removal="Unable to remove company as company was not found!";
        else
        {
            companyObj.setContract(null);
            companyTable.updateCompany((Company)companyObj);
            removal="Contract removed from company successfully!";
        }
        return removal; 
    }
    
    public CompanyInt viewCompanyByID(int id)throws RemoteException{
        return companyTable.getCompanyByID(id); 
    } 
    
    public String deleteCompanyById(int id) throws RemoteException
    {  
       String deletion= companyTable.deleteCompany(id);
       return deletion; 
    }
     
    
    public ArrayList<CompanyInt> viewAllCompanies() throws RemoteException
    {
        companies=companyTable.getAllCompanies();
        ArrayList<CompanyInt> companiesInt=new ArrayList<>();
        for(int i=0;i<companies.size();i++)
        {
            companiesInt.add((CompanyInt)companies.get(i));
        }
        return companiesInt;
    }
    
      public ContractInt viewContractByID(int id)throws RemoteException{
       ArrayList<CompanyInt> allCompanies= viewAllCompanies(); 
       Contract viewContract=new Contract();
       Company currentCompany=new Company();
        for(int i=0;i<allCompanies.size();i++)
        {
            currentCompany=(Company)allCompanies.get(i); 
            if(currentCompany.getContract().getID()==id)
                viewContract=(Contract)currentCompany.getContract();
        }
        return viewContract;
    } 
      
      
    public ArrayList<ContractInt> viewAllContracts() throws RemoteException
    {
        ArrayList<CompanyInt> allCompanies= viewAllCompanies(); 
        ArrayList<ContractInt> contractsInt=new ArrayList<>();
        for(int i=0;i<allCompanies.size();i++)
        {
            contractsInt.add(allCompanies.get(i).getContract());
        }
        return contractsInt;
    }
       
    /*public void approveContract()throws RemoteException{
        this.setStatus("Approved");
    }*/
  
    
}
