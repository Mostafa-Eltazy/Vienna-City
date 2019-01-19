/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceHandler;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Mostafa
 */
public interface ServiceManagerInt extends Remote{
    
     public String determineBusStop(String region) throws RemoteException ;
     public void addbusstop(BusStopPlaceInt bsp)throws RemoteException;
    ////////////////////////////////////////////////////////////////////////////////
     public void CreateAplaceFactory(String type, String Name, String Adress,int SchStartingTime,int SchClosingTime,ArrayList<String> schavailableDays) throws RemoteException;
    //////////////////////////////////////////////////////////////////////////////
     public PlaceInt viewsocial(int i)throws RemoteException;
     public PlaceInt viewreligious(int i)throws RemoteException;
     public PlaceInt viewcatering(int i)throws RemoteException;
     /////////////////////////////////////////////////////////////////////////////
     public void reserveSlot(int col,int row) throws RemoteException;
}
