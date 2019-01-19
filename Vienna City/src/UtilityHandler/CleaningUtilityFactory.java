/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UtilityHandler;

import AccountHandler.EmplyeeHandler.Employee;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import DB.EmployeeGateway;

/**
 *
 * @author Moataz
 */
public class CleaningUtilityFactory extends UtilityFactoryInt {

    public CleaningUtilityFactory() throws RemoteException {
    }


    @Override
    protected UtilityInt createUtility(Integer utilityID, Employee employee, String residentName, String residentPhone, String time, String day) throws RemoteException {
        return new CleaningUtility(employee, residentName, residentPhone, time, day);
    }

    @Override
    protected Employee selectAvailableEmployee() {
        String[] workingDaysSet1 = {"Saturday","Sunday","Monday","Tuesday"};
            Employee employee01;
        try {
            employee01 = new Employee("Motaz Bellah",01,"01-01-1995", "motaz","motaz", true, workingDaysSet1, "Cleaning" );
        } catch (RemoteException ex) {
            Logger.getLogger(CleaningUtilityFactory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
       // EmployeeGateway employeeGateway = EmployeeGateway.getInstance();
     //   employeeGateway.getAvailableEmployees();
     return employee01;
    }

}
