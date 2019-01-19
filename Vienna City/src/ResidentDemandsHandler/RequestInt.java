/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResidentDemandsHandler;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author glori
 */
public interface RequestInt extends Remote {
    public String getResidentName()throws RemoteException;
    public void setResidentName(String residentName)throws RemoteException;
    public String getResidentPhone()throws RemoteException;
    public void setResidentPhone(String residentPhone)throws RemoteException;
    public String getResidentAddress()throws RemoteException;
    public void setResidentAddress(String residentAddress)throws RemoteException;
    public String getServiceType()throws RemoteException;
    public void setServiceType(String serviceType)throws RemoteException;
    public String getServiceNeededDate()throws RemoteException;
    public void setServiceNeededDate(String serviceNeededDate)throws RemoteException;
}
