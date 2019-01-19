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
import BillPayment.Payment;
import GUI.PaymentGUI;
import GUI.ResidentFunctionalities;
import GUI.ResidentLogin;
import ResidentDemandsHandler.ResidentDemandsManagerInt;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author glori
 */
public class PaymentController {
    PaymentGUI  gui;
    ResidentInt resident;
    AccountsManagerInt accountsManager;
    ResidentDemandsManagerInt residentDemands;
    BillManagerInt billsManager;
    Registry r;
    Payment pay;
    String amount;
    BillInt b;
    public PaymentController(PaymentGUI gui, ResidentInt resident, AccountsManagerInt accountsManager, ResidentDemandsManagerInt residentDemands, BillManagerInt billsManager, Registry r,String amount,BillInt b) {
        this.gui = gui;
        this.resident = resident;
        this.accountsManager = accountsManager;
        this.residentDemands = residentDemands;
        this.billsManager = billsManager;
        this.r = r;
        this.amount=amount;
        this.b=b;
        gui.getjButton1().addActionListener(new cash());
        gui.getjButton2().addActionListener(new cc());
        gui.getHome().addActionListener(new PaymentController.HomeBtnAction());
        gui.getLogout().addActionListener(new PaymentController.LogoutBtnAction());
        gui.getExit().addActionListener(new ExitBtnAction());
    }
    
    
    class cc implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent ae) {
            
            try {
                pay=b.selectPaymentMethod("cc");
                JOptionPane.showInputDialog("enter cc number");
                double d=Double.parseDouble(amount);
                JOptionPane.showMessageDialog(null,"amount "+d+" "+pay.pay(d));
                
                
            } catch (RemoteException ex) {
                Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           // gui.setVisible(false);
        }
    }

    class cash implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent ae) {
            
            try {
                
                pay=b.selectPaymentMethod("c");
                double d=Double.parseDouble(amount);
                JOptionPane.showMessageDialog(null,"amount "+d+" "+pay.pay(d));
                
              
            } catch (RemoteException ex) {
                Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //gui.setVisible(false);
            
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
