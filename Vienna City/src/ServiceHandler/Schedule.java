/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceHandler;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author glori
 */
public class Schedule extends UnicastRemoteObject implements ScheduleInt{
    private int Staringtime;
    private int ClosingTime;
    private ArrayList<String> availableDays;
    private Boolean[][] Slots;
    

    public Schedule() throws RemoteException{
        this.Slots = null;
    }

    public Schedule(Integer Staringtime, Integer ClosingTime, ArrayList<String> availableDays) throws RemoteException{
       
        this.Staringtime = Staringtime;
        this.ClosingTime = ClosingTime;
        this.availableDays = availableDays;
        this.Slots= new Boolean[availableDays.size()][ClosingTime-Staringtime];
    }

 
    

    @Override
    public int getStaringtime() throws RemoteException {
        return Staringtime;
    }

    @Override
    public void setStaringtime(int Staringtime) throws RemoteException{
        this.Staringtime = Staringtime;
    }

    @Override
    public int getClosingTime() throws RemoteException {
        return ClosingTime;
    }

    @Override
    public void setClosingTime(int ClosingTime)throws RemoteException {
        this.ClosingTime = ClosingTime;
    }

    @Override
    public ArrayList<String> getAvailableDays() throws RemoteException{
        return availableDays;
    }

    @Override
    public void setAvailableDays(ArrayList<String> availableDays)throws RemoteException {
        this.availableDays = availableDays;
    }

    public Boolean[][] getSlots() throws RemoteException{
        return Slots;
    }

    @Override
    public void ReserveASlots(int column,int row) throws RemoteException{
        
        Slots[column][row]=true;
        
    }

    public void aprrovebookingtheseslots() throws RemoteException{
    
    
    }
    public void disapprovebookingtheseslots() throws RemoteException{
    
        int columns =availableDays.size();
        int rows = ClosingTime-Staringtime;
        for(int i=0; i<columns;i++){
        
            for(int j=0;i<rows;j++){
            
                Slots[i][j]=false;
            
            }
        }
    
    }
   
    @Override
    public String toString()  {
        String result="";
        result +="Starting time "+ Staringtime;
        result +="Starting time "+ ClosingTime;
        result += "\n, availableDays=";
        for (int i=0;i<availableDays.size();i++){
            result += availableDays.get(i);
        }
        return result;
       // return "Schedule{" + "timeSlots=" + timeSlots + "\n, availableDays=" + availableDays + '}';
    }
    
}