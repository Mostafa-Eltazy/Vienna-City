/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExternalRelations;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author glori
 */
public interface CompanyInt extends Remote{
    public CompanyInt displayCompanyDetails() throws RemoteException;    
    //public void addNewCompany(CompanyInt companyObj) throws RemoteException;
    public void setContract(ContractInt contractObj) throws RemoteException;
    public String getName() throws RemoteException;
    public int getID()throws RemoteException;
    public String getAddress () throws RemoteException ;
    public String getSpecialization() throws RemoteException; 
    public ContractInt getContract() throws RemoteException;
    public String getContactEmail() throws RemoteException;

}
