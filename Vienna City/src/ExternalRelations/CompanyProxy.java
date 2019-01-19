/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExternalRelations;

import java.rmi.RemoteException;



/**
 *
 * @author glori
 */
public class CompanyProxy implements CompanyInt {
    private Company company;
    private String name;
    private int ID;
    private String address;
    private String specialization;
    private Contract contract;
    private String contactEmail;
    private ExternalRelationsManager exmanager;
    
    public CompanyProxy() {
    }

    public CompanyProxy(String name, int ID, String address, String specialization, Contract contract, String contactEmail) {
        this.name = name;
        this.ID = ID;
        this.address = address;
        this.specialization = specialization;
        this.contract = contract;
        this.contactEmail = contactEmail;
    }

    public Company getCompany() {
        return company;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public String getAddress() {
        return address;
    }

    public String getSpecialization() {
        return specialization;
    }

    public Contract getContract() {
        return contract;
    }

    public String getContactEmail() {
        return contactEmail;
    }
  
    @Override
    public Company displayCompanyDetails() throws RemoteException {
        Company proxyCompany= new Company();  
        return proxyCompany.displayCompanyDetails(); 
    }

    
    public void addNewCompany(CompanyInt companyObj) throws RemoteException {
        Company proxyCompany=(Company) companyObj;  
        exmanager.addNewCompany(companyObj.getName(), companyObj.getID(), companyObj.getAddress(), companyObj.getSpecialization(), companyObj.getContract(), companyObj.getContactEmail());
        //proxyCompany.addNewCompany(companyObj);
    }

    @Override
    public void setContract(ContractInt contractObj) throws RemoteException {
       Company proxyCompany= new Company();
       proxyCompany.setContract(contractObj); 
       /*exmanager.addContractToCompany(ID, contractObj);*/
    }


    
    
   
}
