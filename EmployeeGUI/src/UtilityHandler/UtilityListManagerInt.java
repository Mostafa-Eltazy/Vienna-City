/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UtilityHandler;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author glori
 */
interface UtilityListManagerInt extends Remote {
    public UtilityIntRMI addNewUtility(String utilityType,String residentName, String residentPhone, String time, String day) throws RemoteException;
    public UtilityIntRMI viewComplaintByID(int id)throws RemoteException;
    public UtilityIntRMI viewUtilityByType(String utilityType) throws RemoteException;
//    public ArrayList<RequestInt> viewAllRequests() throws RemoteException;

}
