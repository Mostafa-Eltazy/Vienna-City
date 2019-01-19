/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UtilityHandler;

import AccountHandler.EmplyeeHandler.Employee;
import AccountHandler.EmplyeeHandler.EmployeeInt;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author glori
 */
abstract public class UtilityInt extends UnicastRemoteObject implements Remote,UtilityIntRMI {

    protected Integer utilityID;
    protected String utilityType;
    protected Employee assignedEmployee;
    protected String residentName;
    protected String residentAddress;
    protected String residentPhone;
    protected String time;
    protected String day;

    public UtilityInt() throws RemoteException  {
    }

    
    public UtilityInt(Integer utilityID, String utilityType, Employee employee, String residentName, String residentPhone, String time, String day) throws RemoteException {
        this.utilityID = utilityID;
        this.utilityType = utilityType;
        this.assignedEmployee = employee;
        this.residentName = residentName;
        this.residentPhone = residentPhone;
        this.time = time;
        this.day = day;

    }

    @Override
    public abstract String whatAmI() throws RemoteException;
    
    
    //setter and getters section
    public Integer getUtilityID() {
        return utilityID;
    }

    public void setUtilityID(Integer utilityID) {
        this.utilityID = utilityID;
    }
    
    public String getTime() {
        return time;
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

    public String getDay() {
        return day;
    }
    
    
    

    @Override
    public String toString() {
        return "Utility{" + "employee=" + assignedEmployee.getName() + ", residentName=" + residentName + ", residentAddress=" + residentAddress + ", residentPhone=" + residentPhone + ", time=" + time + ", day=" + day + '}';
    }

}
