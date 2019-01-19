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
import GUI.ResidentLogin;
import GUI.ViewWeather;
import ResidentDemandsHandler.ResidentDemandsManagerInt;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.aksingh.owmjapis.api.APIException;

/**
 *
 * @author glori
 */
public class ViewWeatherController {
    ViewWeather gui;
    ResidentInt resident;
    AccountsManagerInt accountsManager;
    ResidentDemandsManagerInt residentDemands;
    BillManagerInt billsManager;
    Registry r;
    public ViewWeatherController(ViewWeather gui, ResidentInt resident, AccountsManagerInt accountsManager, ResidentDemandsManagerInt residentDemands,BillManagerInt billsManager,Registry r) {
        this.gui = gui;
        this.resident = resident;
        this.accountsManager = accountsManager;
        this.residentDemands = residentDemands;
        this.billsManager=billsManager;
        this.r=r;
        gui.getjButton1().addActionListener(new CheckWeatherBtnAction());
        gui.getjButton2().addActionListener(new HomeBtnAction());
        gui.getjButton3().addActionListener(new LogoutBtnAction());
        gui.getjButton4().addActionListener(new ExitBtnAction());
    }
    class CheckWeatherBtnAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {

                // We try to obtain a remote reference to the grade remote object
                // that lives on the client. (using the registry object obtained from
                // the constructor above)
                gui.getjTextArea1().setText(residentDemands.viewWeather(gui.getjTextField1().getText()));
                
                
            } catch (RemoteException ex) {
                Logger.getLogger(AddNewComplaintController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (APIException ex) {
                Logger.getLogger(ViewWeatherController.class.getName()).log(Level.SEVERE, null, ex);
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
