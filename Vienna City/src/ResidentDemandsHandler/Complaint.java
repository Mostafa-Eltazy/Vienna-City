/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResidentDemandsHandler;

import AccountHandler.AccountsManager;
import java.util.ArrayList;
import AccountHandler.ResidentServiceHandler.ResidentServiceObserver;
//import DB.ComplaintTable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author glori
 */
public class Complaint extends UnicastRemoteObject implements ComplaintInt, ComplaintSubject, ComplaintResidentServiceInt  {
    private String residentName,residentPhone,residentAddress,complaintAbout,complaintDescription;
    private int ID;
    private ArrayList<ResidentServiceObserver> residentServices;

    public Complaint()throws RemoteException {
        //notifyAllResidentServices();
    }
    
    public Complaint(String residentName, String residentPhone, String residentAddress, String complaintAbout, String complaintDescription,int id)throws RemoteException {
        this.residentName = residentName;
        this.residentPhone = residentPhone;
        this.residentAddress = residentAddress;
        this.complaintAbout = complaintAbout;
        this.complaintDescription = complaintDescription;
        this.ID=id;
        //notifyAllResidentServices();
    }

    
    
    @Override
    public void notifyAllResidentServices()throws RemoteException{
        for(int i=0;i<residentServices.size();i++)
            residentServices.get(i).getNewComplaintNotification("New Complaint is added by "+residentName+" at "+residentAddress);
    }
    
    @Override
    public void addNewResidentService(ResidentServiceObserver r)throws RemoteException{
        residentServices.add(r);
    }
    @Override
    public void removeResidentService(String name)throws RemoteException{
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

    public String getComplaintAbout() {
        return complaintAbout;
    }

    public void setComplaintAbout(String complaintAbout) {
        this.complaintAbout = complaintAbout;
    }

    public String getComplaintDescription() {
        return complaintDescription;
    }

    public void setComplaintDescription(String complaintDescription) {
        this.complaintDescription = complaintDescription;
    }

    public ArrayList<ResidentServiceObserver> getResidentServices() {
        return residentServices;
    }

    public void setResidentServices(ArrayList<ResidentServiceObserver> residentServices) {
        this.residentServices = residentServices;
    }

    @Override
    public String toString() {
        return "Complaint "+ID+" by " + residentName + "\nHis phone number is " + residentPhone + "\nHis address is " + residentAddress + "\nThe complaint is about " + complaintAbout + "\nThe complaints description is " + complaintDescription ;
    }
    

    
}
