/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExternalRelations;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;



/**
 *
 * @author glori
 */
public class Company extends UnicastRemoteObject implements CompanyInt{
    private String name;
    private int ID;
    private String address;
    private String specialization;
    private Contract contract;
    private String contactEmail;
    

    public Company() throws RemoteException {
    }

    public Company(String name, int ID, String address, String specialization, Contract contract, String contactEmail) throws RemoteException {
        this.name = name;
        this.ID = ID;
        this.address = address;
        this.specialization = specialization;
        this.contract = contract;
        this.contactEmail = contactEmail;
    }

    /*public void addNewCompany(CompanyInt newCompany)throws RemoteException{
       table.insertCompany((Company)newCompany);
    }
    
    public void removeCompany(int id)throws RemoteException{
        table.deleteCompany(id);
    }*/
    
    @Override
    public Company displayCompanyDetails() throws RemoteException{
        return this; 
    }
    
    public String getName() throws RemoteException{
        return name;
    }

    public void setName(String name)throws RemoteException {
        this.name = name;
    }

    public int getID() throws RemoteException{
        return ID;
    }

    public void setID(int ID) throws RemoteException{
        this.ID = ID;
    }

    public String getAddress() throws RemoteException{
        return address;
    }

    public void setAddress(String address)throws RemoteException {
        this.address = address;
    }

    public String getSpecialization()throws RemoteException {
        return specialization;
    }

    public void setSpecialization(String specialization)throws RemoteException {
        this.specialization = specialization;
    }

    public ContractInt getContract() throws RemoteException{
        return contract; 
    }

    public void setContract(ContractInt contract)throws RemoteException {
        this.contract = (Contract)contract;
    }

    public String getContactEmail()throws RemoteException {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) throws RemoteException{
        this.contactEmail = contactEmail;
    }

    @Override
    public String toString() {
        return "Company{" + "name=" + name + ", ID=" + ID + ", address=" + address + ", specialization=" + specialization + ", contract=" + contract + ", contactEmail=" + contactEmail + '}';
    }

    

 
    
}
