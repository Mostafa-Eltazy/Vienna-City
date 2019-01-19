/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountHandler.EmplyeeHandler;

import AccountHandler.Staff;
import DB.EmployeeGateway;
import java.rmi.RemoteException;
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author glori
 */
public class Employee extends Staff implements EmployeeInt {

    private Boolean availability;
    private String[] workingDays;
    private String jobTitle;

    public Employee() throws RemoteException {
    }

    public Employee(String name, int SSN, String dateOfBirth, String username, String password, Boolean availability, String[] workingDays, String jobTitle) throws RemoteException {
        super(name, SSN, dateOfBirth, username, password);
        this.availability = availability;
        this.workingDays = workingDays;
        this.jobTitle = jobTitle;
    }

    @Override
    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    @Override
    public String[] getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(String[] workingDays) {
        this.workingDays = workingDays;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String getjobTitle() {
        return jobTitle;
    }

    public Employee test() {
        EmployeeGateway employeeGateway = EmployeeGateway.getInstance();
        Employee tempEmployee = employeeGateway.getEmployeeByID(this.SSN);
        System.out.println("test done");
        return tempEmployee;
    }
    
    public String isWorking(String dayIn)
    {
        for (int i = 0; i <= workingDays.length; i++)
        {
            if (workingDays[i].equals(dayIn))
                return dayIn;
        }   
        return "not working at that day";
    }



}
