/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import AccountHandler.AccountsManagerInt;
import AccountHandler.ResidentHandler.ResidentInt;
import BillPayment.BillManagerInt;
import GUI.NewBillAddedAlarm;
import GUI.ResidentLogin;
import GUI.ResidentFunctionalities;
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
public class ResidentLoginController {
    ResidentLogin gui;
    ResidentInt resident;
    AccountsManagerInt accountsManager;
    ResidentDemandsManagerInt residentDemands;
    BillManagerInt billsManager;
    Registry r;
    public ResidentLoginController(ResidentLogin gui, AccountsManagerInt accountsManager, ResidentDemandsManagerInt residentDemands,BillManagerInt billsManager,Registry r) {
        this.gui = gui;
        this.accountsManager = accountsManager;
        this.residentDemands = residentDemands;
        this.billsManager=billsManager;
        this.r=r;
        gui.getLogin().addActionListener(new LoginBtnAction());
        gui.getReset().addActionListener(new ResetBtnAction());
        gui.getExit().addActionListener(new ExitBtnAction());
    }
    class LoginBtnAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {

                // We try to obtain a remote reference to the grade remote object
                // that lives on the client. (using the registry object obtained from
                // the constructor above)
                
                resident=accountsManager.residentLogin(gui.getjTextField1().getText(), gui.getjPasswordField1().getText());
                System.out.println(resident.getName());
                System.out.println(resident.isNewBillIsAdded());
                if(resident.isNewBillIsAdded()==true)
                {
                    NewBillAddedAlarm newBill=new NewBillAddedAlarm();
                    newBill.setLocationRelativeTo(null);
                    newBill.setVisible(true);
                    gui.setVisible(false);
                    NewBillAddedAlarmController newBillControl=new NewBillAddedAlarmController(newBill,resident,accountsManager,residentDemands,billsManager,r); 
                }
                else{
                    ResidentFunctionalities residentFunctionalities=new ResidentFunctionalities();
                    residentFunctionalities.setLocationRelativeTo(null);
                    residentFunctionalities.setVisible(true);
                    gui.setVisible(false);
                    ResidentFunctionalitiesController residentFunctionalitiesControl=new ResidentFunctionalitiesController(residentFunctionalities,accountsManager, resident, residentDemands,billsManager,r);
                }
                
            } catch (RemoteException ex) {
                Logger.getLogger(AddNewComplaintController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }}
    /*public class ExitBtnAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
               System.exit(0);  
    }}*/
    
    
    class ResetBtnAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
                gui.setjTextField1ToNull();
                gui.setjPasswordField1ToNull();
    }}
}
