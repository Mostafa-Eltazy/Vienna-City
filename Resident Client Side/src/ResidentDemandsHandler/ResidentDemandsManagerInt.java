/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResidentDemandsHandler;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import net.aksingh.owmjapis.api.APIException;

/**
 *
 * @author glori
 */
public interface ResidentDemandsManagerInt extends Remote {
    public void addNewComplaint(String residentName, String residentPhone, String residentAddress, String complaintAbout, String complaintDescription)throws RemoteException;
    public ComplaintInt viewComplaintByID(int id)throws RemoteException;
    public ArrayList<ComplaintInt> viewAllComplaints() throws RemoteException;
    public void deleteComplaintByID(int id)throws RemoteException;
    public void addNewRequest(String residentName, String residentPhone, String residentAddress, String serviceType, String serviceNeededDate)throws RemoteException;
    public RequestInt viewRequestByID(int id)throws RemoteException;
    public ArrayList<RequestInt> viewAllRequests() throws RemoteException;
    public void deleteRequestByID(int id)throws RemoteException;
    public void deleteAllComplaintsBySpecificUser(String n)throws RemoteException;
    public String viewWeather(String city)throws RemoteException, APIException;
}
