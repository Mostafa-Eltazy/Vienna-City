/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountHandler;

import DB.EmployeeGateway;
import java.rmi.RemoteException;
import java.sql.Time;

/**
 *
 * @author glori
 */
abstract public class Staff extends Person {

    protected Time checkInTime;
    protected Time checkOutTime;
    protected float salary;

    //constractors
    public Staff() throws RemoteException {
    }

    public Staff(String name, int SSN, String dateOfBirth, String username, String password) throws RemoteException {
        super(name, SSN, dateOfBirth, username, password);
    }

    public Staff(Time checkInTime, Time checkOutTime, float salary, String name, int SSN, String dateOfBirth, String username, String password) throws RemoteException {
        super(name, SSN, dateOfBirth, username, password);
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.salary = salary;
    }

    //functions
 

    public float checkSalary() {
        return getSalary();
    }

    //setters and getters
    public Time getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Time checkInTime) {
        this.checkInTime = checkInTime;
    }

    public void updateCheckInTime() {
        EmployeeGateway employeeGateway = EmployeeGateway.getInstance();
        employeeGateway.updateCheckInTime(this.SSN);

    }

    public Time getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(Time checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public void updateCheckOutTime() {
        EmployeeGateway employeeGateway = EmployeeGateway.getInstance();
        employeeGateway.updateCheckOutTime(this.SSN);

    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Staff{" + "checkInTime=" + checkInTime + ", checkOutTime=" + checkOutTime + ", salary=" + salary + '}';
    }

}
