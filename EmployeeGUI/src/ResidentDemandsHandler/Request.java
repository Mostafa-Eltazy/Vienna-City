/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResidentDemandsHandler;

import AccountHandler.AccountsManager;
import AccountHandler.ResidentServiceHandler.ResidentServiceObserver;
import java.util.ArrayList;
//import DB.RequestTable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author glori
 */
public class Request extends UnicastRemoteObject implements RequestInt, RequestSubject, RequestResidentServiceInt{
    private String residentName,residentPhone,residentAddress;
    private String serviceType,serviceNeededDate;
    private ArrayList<ResidentServiceObserver> residentServices;
    private int ID;
    
    public Request() throws RemoteException {
        //notifyAllResidentServices();
    }

    public Request(String residentName, String residentPhone, String residentAddress, String serviceType, String serviceNeededDate,int id) throws RemoteException {
        this.residentName = residentName;
        this.residentPhone = residentPhone;
        this.residentAddress = residentAddress;
        this.serviceType = serviceType;
        this.serviceNeededDate = serviceNeededDate;
        this.ID=id;
        //notifyAllResidentServices();
        
    }

    
    @Override
    public void notifyAllResidentServices()throws RemoteException {
        for(int i=0;i<residentServices.size();i++)
            residentServices.get(i).getNewComplaintNotification("New Request is added by "+residentName+" at "+residentAddress);
    }
    
    @Override
    public void addNewResidentService(ResidentServiceObserver r)throws RemoteException {
        residentServices.add(r);
    }
    @Override
    public void removeResidentService(String name)throws RemoteException {
        for(int i=0;i<residentServices.size();i++)
            if(residentServices.get(i).getName().equals(name))
                residentServices.remove(i);
        
    }

    @Override
    public String getResidentName() {
        return residentName;
    }

    @Override
    public void setResidentName(String residentName) {
        this.residentName = residentName;
    }

    @Override
    public String getResidentPhone() {
        return residentPhone;
    }

    @Override
    public void setResidentPhone(String residentPhone) {
        this.residentPhone = residentPhone;
    }

    @Override
    public String getResidentAddress() {
        return residentAddress;
    }

    @Override
    public void setResidentAddress(String residentAddress) {
        this.residentAddress = residentAddress;
    }

    @Override
    public String getServiceType() {
        return serviceType;
    }

    @Override
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public String getServiceNeededDate() {
        return serviceNeededDate;
    }

    @Override
    public void setServiceNeededDate(String serviceNeededDate) {
        this.serviceNeededDate = serviceNeededDate;
    }

    public ArrayList<ResidentServiceObserver> getResidentServices() {
        return residentServices;
    }

    public void setResidentServices(ArrayList<ResidentServiceObserver> residentServices) {
        this.residentServices = residentServices;
    }

    @Override
    public String toString() {
        return "Request "+ID+" by " + residentName + "\nHis phone number is " + residentPhone + "\nHis address is " + residentAddress + "\nThe utility type needed is " + serviceType + "\nThe utility is needed on " + serviceNeededDate ;
            
    }


   
    
    
}
