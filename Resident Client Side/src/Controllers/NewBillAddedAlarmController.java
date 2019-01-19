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
import GUI.ResidentFunctionalities;
import GUI.ViewBill;
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
public class NewBillAddedAlarmController {
    NewBillAddedAlarm gui;
    ResidentInt resident;
    AccountsManagerInt accountsManager;
    ResidentDemandsManagerInt residentDemands;
    BillManagerInt billsManager;
    Registry r;
    public NewBillAddedAlarmController(NewBillAddedAlarm gui, ResidentInt resident, AccountsManagerInt accountsManager, ResidentDemandsManagerInt residentDemands,BillManagerInt billsManager,Registry r) {
        this.gui = gui;
        this.resident = resident;
        this.accountsManager = accountsManager;
        this.residentDemands = residentDemands;
        this.billsManager=billsManager;
        this.r=r;
        gui.getjLabel1().setText("A new bill is added");
        gui.getViewBills().addActionListener(new ViewBillBtnAction());
        gui.getSkip().addActionListener(new SkipBtnAction());
    }
    class ViewBillBtnAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                // We try to obtain a remote reference to the grade remote object
                // that lives on the client. (using the registry object obtained from
                // the constructor above)
                resident.setNewBillIsAdded(false);
                accountsManager.updateNewBillIsAdded(resident.getName());
                ViewBill viewBill=new ViewBill();
                viewBill.setLocationRelativeTo(null);
                viewBill.setVisible(true);
                gui.setVisible(false);
                ViewBillController newBillControl=new ViewBillController(viewBill,resident,accountsManager,residentDemands,billsManager,r);
            } catch (RemoteException ex) {
                Logger.getLogger(NewBillAddedAlarmController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }}
    class SkipBtnAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                // We try to obtain a remote reference to the grade remote object
                // that lives on the client. (using the registry object obtained from
                // the constructor above)
                resident.setNewBillIsAdded(false);
                accountsManager.updateNewBillIsAdded(resident.getName());
                ResidentFunctionalities residentFunctionalities=new ResidentFunctionalities();
                residentFunctionalities.setLocationRelativeTo(null);
                residentFunctionalities.setVisible(true);
                gui.setVisible(false);
                ResidentFunctionalitiesController residentFunctionalitiesControl=new ResidentFunctionalitiesController(residentFunctionalities,accountsManager, resident, residentDemands,billsManager,r);
            } catch (RemoteException ex) {
                Logger.getLogger(NewBillAddedAlarmController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }}
}
