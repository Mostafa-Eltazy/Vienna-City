/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceHandler;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


/**
 *
 * @author Mostafa
 */
public class CateringPlace extends UnicastRemoteObject implements PlaceInt{
    String Name;
    String Address;
    Schedule PlaceSchedule;

    public CateringPlace() throws RemoteException {
    }

    public CateringPlace(String Name, String Address) throws RemoteException {
        this.Name = Name;
        this.Address = Address;
    }
    

    public CateringPlace(String Name, String Address, Schedule PlaceSchedule) throws RemoteException{
        this.Name = Name;
        this.Address = Address;
        this.PlaceSchedule = PlaceSchedule;
    }

    public String getName() throws RemoteException {
        return Name;
    }

    public void setName(String Name) throws RemoteException {
        this.Name = Name;
    }

    public String getAddress() throws RemoteException {
        return Address;
    }

    public void setAddress(String Address) throws RemoteException {
        this.Address = Address;
    }

    @Override
    public Schedule getPlaceSchedule() throws RemoteException{
        return PlaceSchedule;
    }

    public void setPlaceSchedule(Schedule PlaceSchedule) throws RemoteException{
        this.PlaceSchedule = PlaceSchedule;
    }

    @Override
    public String toString() {
        return "CateringPlace{" + "Name=" + Name + ", Address=" + Address + ", PlaceSchedule=" + PlaceSchedule + '}';
    }
    

    @Override
    public void bookPlacel(String i) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void approveBooking() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
