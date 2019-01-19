/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExternalRelations;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Cherine Hussein
 */
public interface ExternalRelationsManagerInt extends Remote {
    public void addNewCompany(String name, int ID, String address, String specialization, ContractInt contract, String contactEmail)throws RemoteException;
    public ContractInt createNewContract(String type, int ID, String date, String dateOfExpiry, String status, String description) throws RemoteException; 
    public void addContractToCompany(int companyId,String type, int ID, String date, String dateOfExpiry, String status, String description)throws RemoteException;
    public String removeContract(int companyID)throws RemoteException;
    public CompanyInt viewCompanyByID(int id)throws RemoteException;   
    public String deleteCompanyById(int id) throws RemoteException; 
    public ArrayList<CompanyInt> viewAllCompanies() throws RemoteException;
    public ContractInt viewContractByID(int id)throws RemoteException; 
    public ArrayList<ContractInt> viewAllContracts() throws RemoteException;
      
    
}
