/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import AccountHandler.AccountsManagerInt;
import AccountHandler.ResidentHandler.ResidentInt;
import BillPayment.BillManagerInt;
import GUI.AddNewRequest;
import GUI.ResidentFunctionalities;
import GUI.ResidentLogin;
import ResidentDemandsHandler.ResidentDemandsManagerInt;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author glori
 */
public class AddNewRequestController {
    AddNewRequest gui;
    ResidentInt resident;
    AccountsManagerInt accountsManager;
    ResidentDemandsManagerInt residentDemands;
    BillManagerInt billsManager;
    Registry r;
    public AddNewRequestController  (AddNewRequest gui,ResidentInt resident,ResidentDemandsManagerInt residentDemands,AccountsManagerInt accountsManager,BillManagerInt billsManager,Registry r){
        this.gui = gui;
        this.resident = resident;
        this.residentDemands=residentDemands;
        this.accountsManager=accountsManager;
        this.billsManager=billsManager;
        this.r=r;
        // This registers the button with our action listener below (the inner class)
        gui.getjButton1().addActionListener(new AddRequestBtnAction());
        gui.getHome().addActionListener(new HomeBtnAction());
        gui.getLogout().addActionListener(new LogoutBtnAction());
        gui.getExit().addActionListener(new ExitBtnAction());
    }
    class AddRequestBtnAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {

                // We try to obtain a remote reference to the grade remote object
                // that lives on the client. (using the registry object obtained from
                // the constructor above)
                residentDemands.addNewRequest(resident.getName(), resident.getPhone(), resident.getAddress(),gui.getjComboBox1().getSelectedItem().toString() ,gui.getjTextField1().getText());
                
                
            } catch (RemoteException ex) {
                Logger.getLogger(AddNewRequestController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }}
    class HomeBtnAction implements ActionListener{
        @Override
            public void actionPerformed(ActionEvent ae) {
            
                ResidentFunctionalities residentFunctionalities=new ResidentFunctionalities();
                residentFunctionalities.setLocationRelativeTo(null);
                residentFunctionalities.setVisible(true);
                gui.setVisible(false);
                ResidentFunctionalitiesController ResidentFunctionalitiesControl=new ResidentFunctionalitiesController(residentFunctionalities, accountsManager,resident, residentDemands,billsManager,r);
            
        }
    }
    class LogoutBtnAction implements ActionListener{
        @Override
            public void actionPerformed(ActionEvent ae) {
           
                ResidentLogin login=new ResidentLogin();
                login.setLocationRelativeTo(null);
                login.setVisible(true);
                gui.setVisible(false);
                ResidentLoginController loginControl=new ResidentLoginController(login, accountsManager, residentDemands,billsManager,r);
            
        }
    }
}
