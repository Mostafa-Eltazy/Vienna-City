/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UtilityHandler;

import AccountHandler.EmplyeeHandler.Employee;
import java.rmi.RemoteException;

/**
 *
 * @author glori
 */
public class CleaningUtility extends UtilityInt {

    public CleaningUtility() throws RemoteException {
    }
    

    public CleaningUtility(Employee employee, String residentName, String residentPhone, String time, String day) throws RemoteException {
        super(null, null, employee, residentName, residentPhone, time, day);
    }

    @Override
    public String whatAmI() throws RemoteException {
        System.out.println("I'm a Cleaning utility");
        return "I'm a Cleaning utility";
    }

}
