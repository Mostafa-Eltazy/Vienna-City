/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import AccountHandler.AccountsManagerInt;
import BillPayment.BillManagerInt;
import GUI.AddNewBill;
import GUI.ResidentServiceFunctionalities;
import GUI.ResidentServiceLogin;
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
public class AddNewBillController {
    AddNewBill gui;
    AccountsManagerInt accountsManager;
    Registry r;
    public AddNewBillController(AddNewBill gui, AccountsManagerInt accountsManager, Registry r) {
        this.gui = gui;
        this.accountsManager = accountsManager;
        this.r = r;
        gui.getjButton1().addActionListener(new Add());
        gui.getHome().addActionListener(new HomeBtnAction());
        gui.getLogout().addActionListener(new LogoutBtnAction());
        gui.getExit().addActionListener(new ExitBtnAction());
    }
    class Add implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                BillManagerInt b=(BillManagerInt) r.lookup("addbill");
                int id=Integer.parseInt(gui.getjTextField1().getText());
                String rn=gui.getjTextField2().getText();
                String type=gui.getjTextField3().getText();
                String desc=gui.getjTextField4().getText();
                double Amount=Double.parseDouble(gui.getjTextField5().getText());
                b.addBill(id, rn, type, desc, Amount);
            } catch (RemoteException ex) {
                Logger.getLogger(AddNewBillController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(AddNewBillController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }

        
    }
    class HomeBtnAction implements ActionListener{
        @Override
            public void actionPerformed(ActionEvent ae) {
           
                ResidentServiceFunctionalities residentServiceFunctionalities=new ResidentServiceFunctionalities();
                residentServiceFunctionalities.setLocationRelativeTo(null);
                residentServiceFunctionalities.setVisible(true);
                gui.setVisible(false);
                ResidentServiceFunctionalitiesController ResidentServiceFunctionalitiesControl=new ResidentServiceFunctionalitiesController(residentServiceFunctionalities, accountsManager,r);
            
        }
    }
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
