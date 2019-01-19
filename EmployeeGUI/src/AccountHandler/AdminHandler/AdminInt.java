/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountHandler.AdminHandler;

import AccountHandler.Person;
import java.rmi.RemoteException;

/**
 *
 * @author glori
 */
public interface AdminInt {
    public void monitorAttandance()throws RemoteException;
    //public Admin getAdminInstance();
    //public void login(String u,String p)throws RemoteException;
    //public void logout()throws RemoteException;
    //public void editProfile(AdminInt a)throws RemoteException;
    
}
