/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceHandler;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author glori
 */
public interface PlaceInt extends Remote{
    public void bookPlacel(String i) throws RemoteException;
    public void approveBooking()throws RemoteException;
    //////////////////////////////////////////////////////
    public String getName() throws RemoteException;
    public String getAddress() throws RemoteException ;
    public ScheduleInt getPlaceSchedule() throws RemoteException ;

    
}
