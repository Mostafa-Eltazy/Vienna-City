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
public class Contract extends UnicastRemoteObject implements ContractInt,ContractPublicRelationInt{
    private String type;
    private int ID;
    private String date;
    private String dateOfExpiry;
    private String status;
    private String description;

    public Contract()throws RemoteException {
    }

    public Contract(String type, int ID, String date, String dateOfExpiry, String status, String description)throws RemoteException {
        this.type = type;
        this.ID = ID;
        this.date = date;
        this.dateOfExpiry = dateOfExpiry;
        this.status = status;
        this.description = description;
    }

    /*public void addContract(ContractInt contractObj,CompanyInt companyObj)throws RemoteException{
        companyObj.setContract(contractObj);
    }
    
    public void removeContract(CompanyInt companyObj)throws RemoteException{
        companyObj.setContract(null);
        
    }
    public void approveContract()throws RemoteException{
        this.setStatus("Approved");
    }
    public Contract editContract(int id)throws RemoteException{
        return this;
    }*/
    
    public String getType()throws RemoteException {
        return type;
    }

    public void setType(String type)throws RemoteException {
        this.type = type;
    }

    public int getID()throws RemoteException {
        return ID;
    }

    public void setID(int ID) throws RemoteException{
        this.ID = ID;
    }

    public String getDate()throws RemoteException {
        return date;
    }

    public void setDate(String date)throws RemoteException {
        this.date = date;
    }

    public String getDateOfExpiry()throws RemoteException {
        return dateOfExpiry;
    }

    public void setDateOfExpiry(String dateOfExpiry)throws RemoteException {
        this.dateOfExpiry = dateOfExpiry;
    }

    public String getStatus()throws RemoteException {
        return status;
    }

    public void setStatus(String statust)throws RemoteException {
        this.status = status;
    }

    public String getDescription()throws RemoteException {
        return description;
    }

    public void setDescription(String description) throws RemoteException{
        this.description = description;
    }

    @Override
    public String toString() {
        return "Contract{" + "type=" + type + ", ID=" + ID + ", date=" + date + ", dateOfExpiry=" + dateOfExpiry + ", status=" + status + ", description=" + description + '}';
    }


   



   


 
    
}
