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

/**
 *
 * @author Moataz
 */
public interface UtilityIntRMI extends Remote{
        public abstract String whatAmI() throws RemoteException;   
}
