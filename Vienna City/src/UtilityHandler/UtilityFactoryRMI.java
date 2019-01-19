/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UtilityHandler;

import AccountHandler.ResidentHandler.Resident;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Moataz
 */
public interface UtilityFactoryRMI extends Remote {
    public UtilityIntRMI addNewUtility(String residentName,String residentPhone,  String time, String day) throws RemoteException;
//    public UtilityIntRMI addNewUtility(Resident residentIn, String time, String day) throws RemoteException;
//    public UtilityFactoryRMI returnSubClass(String utilityType) throws RemoteException;
}
