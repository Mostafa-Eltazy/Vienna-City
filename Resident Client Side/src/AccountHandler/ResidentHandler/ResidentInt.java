/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountHandler.ResidentHandler;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author glori
 */
public interface ResidentInt extends Remote{
    //public void login(String u,String p)throws RemoteException;
    //public void logout()throws RemoteException;
    //public void editProfile(ResidentInt p)throws RemoteException;
    //public void viewMap()throws RemoteException;
    //public void addNewResident(ResidentInt r)throws RemoteException;
    //public void removeResident(String n)throws RemoteException;
    public String getName()throws RemoteException;
    public String getPhone()throws RemoteException;
    public String getAddress()throws RemoteException;
    public boolean isNewBillIsAdded()throws RemoteException;
    public void setNewBillIsAdded(boolean newBillIsAdded)throws RemoteException;
    
}
