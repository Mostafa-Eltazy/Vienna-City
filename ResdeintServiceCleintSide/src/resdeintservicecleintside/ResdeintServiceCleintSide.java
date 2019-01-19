/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resdeintservicecleintside;

import AccountHandler.AccountsManagerInt;
import GUI.ApprovePlaceReservationGUI;
import GUI.AddPlaceGUI;
import Controller.ApproveReservationController;
import Controller.PlaceandBusStopController;
import Controller.ResidentServiceLoginController;
import GUI.ResidentServiceLogin;
import ServiceHandler.ServiceManagerInt;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Locale;

/**
 *
 * @author Mostafa
 */
public class ResdeintServiceCleintSide {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, NotBoundException {
        // TODO code application logic here
       /* AddPlaceGUI apgui = new AddPlaceGUI();
        ApprovePlaceReservationGUI agui = new ApprovePlaceReservationGUI();
        
        
        apgui.setLocationRelativeTo(null); // This makes the window appears centered
        apgui.setVisible(true);
        
        agui.setLocationRelativeTo(null); // This makes the window appears centered
        agui.setVisible(true);
        */
        // We connect to the RMI Registry
        Registry r = LocateRegistry.getRegistry(1104);
        System.out.println("The client is ready");
        AccountsManagerInt accountsManager=(AccountsManagerInt)r.lookup("accountsManager");
        ResidentServiceLogin login=new ResidentServiceLogin();
            login.setLocationRelativeTo(null);
            login.setVisible(true);
        ResidentServiceLoginController loginControl=new ResidentServiceLoginController(login, accountsManager, r);
            
        
        // we create a new object from the controller and we pass it the
        // gui object along with the registry object
        /*PlaceandBusStopController gui_controller = new PlaceandBusStopController(apgui,r);
        ApproveReservationController approve_reservation_controller = new ApproveReservationController(agui, r);
        */
}
    
}
