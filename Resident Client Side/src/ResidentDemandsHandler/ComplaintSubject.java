/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResidentDemandsHandler;

import AccountHandler.ResidentServiceHandler.ResidentServiceObserver;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author glori
 */
public interface ComplaintSubject extends Remote{
    public void notifyAllResidentServices()throws RemoteException;
    public void addNewResidentService(ResidentServiceObserver r)throws RemoteException;
    public void removeResidentService(String name)throws RemoteException;
}
