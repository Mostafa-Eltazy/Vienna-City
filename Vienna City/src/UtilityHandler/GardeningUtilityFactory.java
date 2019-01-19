/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UtilityHandler;

import AccountHandler.EmplyeeHandler.Employee;
import AccountHandler.ResidentHandler.Resident;
import DB.UtilityGateway;
import java.rmi.RemoteException;

/**
 *
 * @author Moataz
 */
public class GardeningUtilityFactory extends UtilityFactoryInt {

    public GardeningUtilityFactory() throws RemoteException 
    {
    }

    @Override
    protected UtilityInt createUtility(Integer utilityID, Employee employee, String residentName, String residentPhone, String time, String day) throws RemoteException {
        String utilityType = "Gardening";
        UtilityInt utility = new GardeningUtility(utilityID,utilityType, employee, residentName, residentPhone, time, day);

        //automatically adding the new reservation to the database
        UtilityGateway utilityTable = UtilityGateway.getInstance();
        utilityTable.insertUtility(utility);

        //console log for testing
        System.out.println("reservation has been made");
        return utility;
    }

    @Override
    protected Employee selectAvailableEmployee() throws RemoteException {
        
        try {
            return new Employee();
        } catch (Exception ex) {
            return null;
        }
    }



}
