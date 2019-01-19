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
public interface ScheduleInt extends Remote{
    
  
    public int getStaringtime() throws RemoteException;
    public void setStaringtime(int Staringtime) throws RemoteException;
    public int getClosingTime() throws RemoteException;
    public void setClosingTime(int ClosingTime)throws RemoteException;
    public ArrayList<String> getAvailableDays() throws RemoteException;
    public void setAvailableDays(ArrayList<String> availableDays)throws RemoteException;
    public Boolean[][] getSlots() throws RemoteException;
    public void ReserveASlots(int column,int row) throws RemoteException;
    public void aprrovebookingtheseslots() throws RemoteException;
    public void disapprovebookingtheseslots() throws RemoteException;

     

}
