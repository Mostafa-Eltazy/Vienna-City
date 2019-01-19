/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import AccountHandler.AccountsManagerInt;
import GUI.ApprovePlaceReservationGUI;
import GUI.ResidentServiceFunctionalities;
import GUI.ResidentServiceLogin;
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
public class ResidentServiceLoginController {
    ResidentServiceLogin gui;
    AccountsManagerInt accountsManager;
    Registry r;
    public ResidentServiceLoginController(ResidentServiceLogin gui, AccountsManagerInt accountsManager,  Registry r) {
        this.gui = gui;
        this.accountsManager = accountsManager;
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
                
                accountsManager.residentServiceLogin(gui.getjTextField1().getText(), gui.getjPasswordField1().getText());
                ResidentServiceFunctionalities residentFunctionalities=new ResidentServiceFunctionalities();
                residentFunctionalities.setLocationRelativeTo(null);
                residentFunctionalities.setVisible(true);
                gui.setVisible(false);
                ResidentServiceFunctionalitiesController residentFunctionalitiesControl=new ResidentServiceFunctionalitiesController(residentFunctionalities,accountsManager, r);
               
                
            } catch (RemoteException ex) {
                Logger.getLogger(ResidentServiceLoginController.class.getName()).log(Level.SEVERE, null, ex);
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
