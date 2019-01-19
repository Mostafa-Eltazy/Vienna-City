/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountHandler;

import AccountHandler.ResidentHandler.ResidentInt;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author glori
 */
public interface AccountsManagerInt extends Remote{
    public ResidentInt residentLogin(String u,String p)throws RemoteException;
    public void residentEditPassword(ResidentInt r,String p,String newP)throws RemoteException;
    public void updateNewBillIsAdded(String n)throws RemoteException;
    public void residentServiceLogin(String u,String p)throws RemoteException;
}
