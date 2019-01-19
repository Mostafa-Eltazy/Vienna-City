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
public interface RequestFacadeInt extends Remote{
    //public void addNewRequest(RequestInt r)throws RemoteException ;
    //public RequestInt viewRequest()throws RemoteException ;
    //public void deleteRequest()throws RemoteException ;
    public void setResidentInfo(String name,String phone,String add)throws RemoteException;
    public String getResidentInfo()throws RemoteException ;
}
