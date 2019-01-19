/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UtilityHandler;

//import AccountHandler.AccountsManager;
import DB.UtilityGateway;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author glori
 */
public class UtilityListManager extends UnicastRemoteObject implements UtilityListManagerInt {

    private static UtilityListManager utilityListManager = null;
    private ArrayList<UtilityInt> utilityList;
    private UtilityGateway utilitytGateway;

    private UtilityListManager() throws RemoteException {
        utilitytGateway = UtilityGateway.instance;
        utilityList = new ArrayList<>();
    }

    public static UtilityListManager getUtilityListManager() throws RemoteException {
        if (utilityListManager == null) {
            utilityListManager = new UtilityListManager();
            return utilityListManager;
        } else {
            return utilityListManager;
        }
    }

//    @Override
//    public void addNewComplaint(String residentName, String residentPhone, String residentAddress, String complaintAbout, String complaintDescription) throws RemoteException {
//        Complaint c = new Complaint(residentName, residentPhone, residentAddress, complaintAbout, complaintDescription, complaints.size() + 1);
//        complaintTable.insertComplaint(c);
//        AccountsManager.getAccountManager().getResidentByName(residentName).addComplaint(c);
//        //table.close();
//    }
    @Override
    public UtilityIntRMI viewComplaintByID(int id) throws RemoteException {
        //Complaint c=table.getComplaintByID(id);
        //table.close();
        return utilitytGateway.getUtilityByID(id);
    }

//    @Override
//    public ArrayList<UtilityInt> viewAllRequests() throws RemoteException {
//        requests = requestTable.getAllRequests();
//        ArrayList<RequestInt> requestInts = new ArrayList<>();
//        for (int i = 0; i < requests.size(); i++) {
//            requestInts.add((RequestInt) requests.get(i));
//        }
//        return requestInts;
//    }
    @Override
    public UtilityIntRMI addNewUtility(String utilityType, String residentName, String residentPhone, String time, String day) throws RemoteException {
        if (utilityType == "Gardening") {
            UtilityFactoryInt utilityFactory = new GardeningUtilityFactory();
            return utilityFactory.addNewUtility(residentName, residentPhone, time, day);
        }
        if (utilityType == "Cleaning") {
            UtilityFactoryInt utilityFactory = new CleaningUtilityFactory();
            return utilityFactory.addNewUtility(residentName, residentPhone, time, day);
        }
        if (utilityType == "Electricity") {
            UtilityFactoryInt utilityFactory = new ElectricityUtilityFactory();
            return utilityFactory.addNewUtility(residentName, residentPhone, time, day);
        }
        else return null;
    }

    @Override
    public UtilityIntRMI viewUtilityByType(String utilityType) throws RemoteException {
        return utilitytGateway.viewUtilityByType(utilityType);

    }

}
