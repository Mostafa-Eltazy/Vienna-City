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
public interface ContractPublicRelationInt extends Remote {
    /*public void addContract(ContractInt contractObj,CompanyInt companyObj)throws RemoteException;
    public void removeContract(CompanyInt company)throws RemoteException;
    public Contract editContract(int id)throws RemoteException;*/
    public String getType()throws RemoteException;
    public int getID()throws RemoteException;
    public String getDate()throws RemoteException;
    public String getDateOfExpiry()throws RemoteException;
    public String getStatus()throws RemoteException;
    public String getDescription()throws RemoteException;
}
