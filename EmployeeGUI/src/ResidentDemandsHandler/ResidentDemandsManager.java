/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResidentDemandsHandler;

import API.Weather;
import AccountHandler.AccountsManager;
import DB.ComplaintTable;
import DB.RequestTable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import net.aksingh.owmjapis.api.APIException;

/**
 *
 * @author glori
 */
public class ResidentDemandsManager extends UnicastRemoteObject implements ResidentDemandsManagerInt {
    private static ResidentDemandsManager residentDemands=null;
    private ArrayList<Complaint> complaints;
    private ArrayList<Request> requests;
    private ComplaintTable complaintTable;
    private RequestTable requestTable;
    
    private ResidentDemandsManager()throws RemoteException {
        complaintTable=new ComplaintTable();
        requestTable=new RequestTable();
        requests=new ArrayList<>();
        complaints=new ArrayList<>();
    }
    
    public static ResidentDemandsManager getResidentDemandsManager()throws RemoteException{
        if(residentDemands==null)
        {
            residentDemands=new ResidentDemandsManager();
            return residentDemands;
        }
        else
            return residentDemands;
    }
    
    public String viewWeather(String city)throws RemoteException, APIException{
        return Weather.returnWeather(city);
    }
    
    @Override
    public void addNewComplaint(String residentName, String residentPhone, String residentAddress, String complaintAbout, String complaintDescription)throws RemoteException{
        Complaint c = new Complaint(residentName,residentPhone,residentAddress,complaintAbout,complaintDescription,complaints.size()+1);
        complaintTable.insertComplaint(c);
        AccountsManager.getAccountManager().getResidentByName(residentName).addComplaint(c);
        //table.close();
    }
    
    
    @Override
    public ComplaintInt viewComplaintByID(int id)throws RemoteException{
        //Complaint c=table.getComplaintByID(id);
        //table.close();
        return complaintTable.getComplaintByID(id);
    }
    
    
    @Override
    public ArrayList<ComplaintInt> viewAllComplaints() throws RemoteException{
        complaints=complaintTable.getAllComplaints();
        ArrayList<ComplaintInt> complaintInts=new ArrayList<>();
        for(int i=0; i<complaints.size();i++)
            complaintInts.add((ComplaintInt)complaints.get(i));
        return complaintInts;
    }
    
    @Override
    public void deleteComplaintByID(int id)throws RemoteException{
        complaintTable.deleteComplaint(id);
    }
    
    @Override
    public void deleteAllComplaintsBySpecificUser(String n)throws RemoteException{
        complaintTable.deleteAllComplaintsBySpecificUser(n);
    }
    
    @Override
    public void addNewRequest(String residentName, String residentPhone, String residentAddress, String serviceType, String serviceNeededDate)throws RemoteException{
        
        Request r = new Request(residentName,residentPhone,residentAddress,serviceType,serviceNeededDate,requests.size()+1);
        requestTable.insertRequest(r);
        AccountsManager.getAccountManager().getResidentByName(residentName).addRequest(r);
        //table.close();
    }
    
   
    @Override
    public RequestInt viewRequestByID(int id)throws RemoteException{
        return requestTable.getRequestByID(id);
    }
    
    
    @Override
    public ArrayList<RequestInt> viewAllRequests() throws RemoteException{
        requests=requestTable.getAllRequests();
        ArrayList<RequestInt> requestInts=new ArrayList<>();
        for(int i=0; i<requests.size();i++)
            requestInts.add((RequestInt)requests.get(i));
        return requestInts;
    }
    
    @Override
    public void deleteRequestByID(int id)throws RemoteException{
        requestTable.deleteRequest(id);
        
    }
}
