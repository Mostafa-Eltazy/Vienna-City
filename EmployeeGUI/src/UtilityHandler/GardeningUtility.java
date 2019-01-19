/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UtilityHandler;

import AccountHandler.EmplyeeHandler.Employee;
import AccountHandler.EmplyeeHandler.EmployeeInt;
import DB.UtilityGateway;
import java.rmi.RemoteException;

/**
 *
 * @author glori
 */
public class GardeningUtility extends UtilityInt {

    public GardeningUtility() throws RemoteException {
    }
    

    public GardeningUtility(Integer utilityID, String utilityType, Employee employee, String residentName, String residentPhone, String time, String day) throws RemoteException {
        super(utilityID, utilityType, employee, residentName, residentPhone, time, day);
    }

    @Override
    public String whatAmI() 
    {
        System.out.println("I'm a Gardening utility");
        return "I'm a Gardening utility";

    }


    public Employee getAssignedEmployee() {
        return assignedEmployee;
    }

    public String getResidentName() {
        return residentName;
    }

    public String getResidentAddress() {
        return residentAddress;
    }

    public String getResidentPhone() {
        return residentPhone;
    }

    public String getTime() {
        return time;
    }

    public String getDay() {
        return day;
    }

}
