/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import AccountHandler.AccountsManagerInt;
import GUI.AddNewBill;
import GUI.AddPlaceGUI;
import GUI.ApprovePlaceReservationGUI;
import GUI.ResidentServiceFunctionalities;
import GUI.ResidentServiceLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;

/**
 *
 * @author glori
 */
public class ResidentServiceFunctionalitiesController {
    ResidentServiceFunctionalities gui;
    AccountsManagerInt accountsManager;
    ButtonGroup group;
    Registry r;
    public ResidentServiceFunctionalitiesController(ResidentServiceFunctionalities gui,AccountsManagerInt accountsManager,Registry r) {
        this.gui = gui;
        this.accountsManager=accountsManager;
        this.group = new ButtonGroup();
        this.r=r;
        group.add(gui.getAddPlace());
        group.add(gui.getAddBill());
        group.add(gui.getApproveBooking());
        if (gui.getAddPlace().isSelected())
        {
            group.clearSelection();
        }
        else if (gui.getAddBill().isSelected())
        {
            group.clearSelection();
        }
        else if (gui.getApproveBooking().isSelected())
        {
            group.clearSelection();
        }
       
        
        gui.getNext().addActionListener(new SelectFunctionalityBtnAction());
        gui.getLogout().addActionListener(new LogoutBtnAction());
        gui.getExit().addActionListener(new ExitBtnAction());
    }
    class SelectFunctionalityBtnAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
           

                // We try to obtain a remote reference to the grade remote object
                // that lives on the client. (using the registry object obtained from
                // the constructor above)
                
                if(gui.getAddPlace().isSelected())
                {   
                    AddPlaceGUI addPlace=new AddPlaceGUI();
                    addPlace.setLocationRelativeTo(null); // This makes the window appears centered
                    addPlace.setVisible(true); 
                    gui.setVisible(false);
                    PlaceandBusStopController residentEditPasswordControl=new PlaceandBusStopController(addPlace,accountsManager,r);
                }
                else if(gui.getAddBill().isSelected())
                {
                    AddNewBill addBill=new AddNewBill();
                    addBill.setLocationRelativeTo(null);
                    addBill.setVisible(true);
                    gui.setVisible(false);
                    AddNewBillController newBillControl=new AddNewBillController(addBill,accountsManager,r);
                }
                else if(gui.getApproveBooking().isSelected())
                {
                    ApprovePlaceReservationGUI approveReservation = new ApprovePlaceReservationGUI();
                    approveReservation.setLocationRelativeTo(null);
                    approveReservation.setVisible(true);
                    gui.setVisible(false);
                    ApproveReservationController placereservaion_controller = new ApproveReservationController(approveReservation,accountsManager,r);
                }
            
    }}
    class LogoutBtnAction implements ActionListener{
        @Override
            public void actionPerformed(ActionEvent ae) {
            
                ResidentServiceLogin login=new ResidentServiceLogin();
                login.setLocationRelativeTo(null);
                login.setVisible(true);
                gui.setVisible(false);
                ResidentServiceLoginController loginControl=new ResidentServiceLoginController(login, accountsManager, r);
            
        }
    }
    
}
