/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resident.client.side;
import AccountHandler.AccountsManagerInt;
import AccountHandler.ResidentHandler.ResidentInt;
import BillPayment.BillManagerInt;
import Controllers.AddNewComplaintController;
import Controllers.AddNewRequestController;
import Controllers.ResidentLoginController;
import GUI.AddNewComplaint;
import GUI.AddNewRequest;
import GUI.ResidentLogin;
import ResidentDemandsHandler.ComplaintFacadeInt;
import ResidentDemandsHandler.ComplaintInt;
import ResidentDemandsHandler.RequestInt;
import ResidentDemandsHandler.RequestFacadeInt;
import ResidentDemandsHandler.ResidentDemandsManagerInt;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author glori
 */
public class ResidentClientSide {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws RemoteException, NotBoundException {
        
            // TODO code application logic here
            Registry r = LocateRegistry.getRegistry(1102);
            System.out.println("The client is ready");
            
            ResidentDemandsManagerInt residentDemands=(ResidentDemandsManagerInt)r.lookup("residentDemands");
            AccountsManagerInt accountsManager=(AccountsManagerInt)r.lookup("accountsManager");
            BillManagerInt billsManager=(BillManagerInt) r.lookup("addbill");
            ResidentLogin login=new ResidentLogin();
            login.setLocationRelativeTo(null);
            login.setVisible(true);
            
            ResidentLoginController loginControl=new ResidentLoginController(login, accountsManager, residentDemands,billsManager,r);
            
            //RequestFacadeInt request1=(RequestFacadeInt) r.lookup("Request1");
            //ResidentInt resident1=(ResidentInt) r.lookup("Resident1");
            //System.out.println(resident1.getName());
            //System.out.println(request1.getResidentInfo());
            
            
            /*AddNewComplaint addComplaint= new AddNewComplaint();
            addComplaint.setLocationRelativeTo(null); // This makes the window appears centered
            addComplaint.setVisible(true); 
            AddNewComplaintController addComplaintControl=new AddNewComplaintController(addComplaint,resident1,residentDemands);
            */
            
            
            /*AddNewRequest addRequest=new AddNewRequest();
            addRequest.setLocationRelativeTo(null); // This makes the window appears centered
            addRequest.setVisible(true); 
            AddNewRequestController addRequestControl=new AddNewRequestController(addRequest,resident1,residentDemands);
            */
            
    }
}
