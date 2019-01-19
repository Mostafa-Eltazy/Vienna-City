/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import AccountHandler.AccountsManagerInt;
import AccountHandler.ResidentHandler.ResidentInt;
import BillPayment.BillInt;
import BillPayment.BillManagerInt;
import GUI.NewBillAddedAlarm;
import GUI.PaymentGUI;
import GUI.ResidentFunctionalities;
import GUI.ResidentLogin;
import GUI.ViewBill;
import ResidentDemandsHandler.ResidentDemandsManagerInt;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author glori
 */
public class ViewBillController {
    ViewBill gui;
    ResidentInt resident;
    AccountsManagerInt accountsManager;
    ResidentDemandsManagerInt residentDemands;
    BillManagerInt billsManager;
    BillInt b;
    Registry r;
    public ViewBillController(ViewBill gui, ResidentInt resident, AccountsManagerInt accountsManager, ResidentDemandsManagerInt residentDemands,BillManagerInt billsManager,Registry r) {
        this.gui = gui;
        this.resident = resident;
        this.accountsManager = accountsManager;
        this.residentDemands = residentDemands;
        this.r=r;
        gui.getjButton1().addActionListener(new Electricity());
        gui.getjButton2().addActionListener(new Water());
        gui.getjButton3().addActionListener(new Gas());
        gui.getjButton4().addActionListener(new Pay());
        gui.getHome().addActionListener(new ViewBillController.HomeBtnAction());
        gui.getLogout().addActionListener(new ViewBillController.LogoutBtnAction());
        gui.getExit().addActionListener(new ExitBtnAction());
    }
    class Pay implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            PaymentGUI p=new PaymentGUI();
            p.setLocationRelativeTo(null); 
            p.setVisible(true);
            gui.setVisible(false);
            PaymentController pay=new PaymentController(p,resident,accountsManager,residentDemands,billsManager,r,gui.getjLabel6().getText(),b);
        }
    }

    class Electricity implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                b=(BillInt) r.lookup("billw");
                gui.getjLabel4().setText(b.getID()+" ");
                gui.getjLabel8().setText(b.getType()+" ");
                gui.getjLabel6().setText(b.getAmount()+" ");
                gui.getjLabel9().setText(b.getResidentName());
           
            } catch (RemoteException ex) {
                Logger.getLogger(ViewBillController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(ViewBillController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }

    class Gas implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent ae) {
           try {
                b=(BillInt) r.lookup("billg");
                
                
                gui.getjLabel4().setText(b.getID()+" ");
                gui.getjLabel8().setText(b.getType());
                gui.getjLabel6().setText(b.getAmount()+" ");
                gui.getjLabel9().setText(b.getResidentName());
            } catch (RemoteException ex) {
                Logger.getLogger(ViewBillController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(ViewBillController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

        class Water implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                b=(BillInt) r.lookup("bille");
                gui.getjLabel4().setText(b.getID()+" ");
                gui.getjLabel8().setText(b.getType());
                gui.getjLabel6().setText(b.getAmount()+" ");
                gui.getjLabel9().setText(b.getResidentName());
                
            } catch (RemoteException ex) {
                Logger.getLogger(ViewBillController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(ViewBillController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
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
