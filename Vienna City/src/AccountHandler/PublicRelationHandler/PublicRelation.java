/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountHandler.PublicRelationHandler;

import AccountHandler.Staff;
import java.rmi.RemoteException;
import java.sql.Time;

/**
 *
 * @author glori
 */
public class PublicRelation extends Staff implements PublicRelationInt{
    private String email;

    public PublicRelation()throws RemoteException {
    }

    public PublicRelation(String name, int SSN, String dateOfBirth, String username, String password) throws RemoteException {
        super(name, SSN, dateOfBirth, username, password);
    }

    public PublicRelation(String email, String name, int SSN, String dateOfBirth, String username, String password) throws RemoteException {
        super(name, SSN, dateOfBirth, username, password);
        this.email = email;
    }

    public PublicRelation(String email, Time checkInTime, Time checkOutTime, float salary, String name, int SSN, String dateOfBirth, String username, String password) throws RemoteException {
        super(checkInTime, checkOutTime, salary, name, SSN, dateOfBirth, username, password);
        this.email = email;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void checkIn(Time t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void checkOut(Time t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
