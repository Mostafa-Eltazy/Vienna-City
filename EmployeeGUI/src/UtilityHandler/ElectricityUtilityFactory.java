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
 * @author Moataz
 */
public class ElectricityUtilityFactory extends UtilityFactoryInt {

    public ElectricityUtilityFactory() throws RemoteException {
    }
    
    

    @Override
    protected UtilityInt createUtility(Integer utilityID, Employee employee, String residentName, String residentPhone, String time, String day) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Employee selectAvailableEmployee() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
