/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import AccountHandler.AccountsManagerInt;
import AccountHandler.ResidentHandler.ResidentInt;
import BillPayment.BillManagerInt;
import GUI.AddNewComplaint;
import GUI.AddNewRequest;
import GUI.MakePlaceReservationGUI;
import GUI.ResidentEditPassword;
import GUI.ResidentFunctionalities;
import GUI.ResidentLogin;
import GUI.ViewBill;
import GUI.ViewWeather;
import ResidentDemandsHandler.ResidentDemandsManagerInt;
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
public class ResidentFunctionalitiesController {
    ResidentFunctionalities gui;
    ResidentInt resident;
    ResidentDemandsManagerInt residentDemands;
    AccountsManagerInt accountsManager;
    ButtonGroup group;
    BillManagerInt billsManager;
    Registry r;
    public ResidentFunctionalitiesController(ResidentFunctionalities gui,AccountsManagerInt accountsManager, ResidentInt resident, ResidentDemandsManagerInt residentDemands,BillManagerInt billsManager,Registry r) {
        this.gui = gui;
        this.resident = resident;
        this.residentDemands = residentDemands;
        this.accountsManager=accountsManager;
        this.group = new ButtonGroup();
        this.billsManager=billsManager;
        this.r=r;
        group.add(gui.getEditPassword());
        group.add(gui.getViewBills());
        group.add(gui.getBookPlace());
        group.add(gui.getReserveService());
        group.add(gui.getCheckWeather());
        group.add(gui.getSendComplaint());
        if (gui.getEditPassword().isSelected())
        {
            group.clearSelection();
        }
        else if (gui.getViewBills().isSelected())
        {
            group.clearSelection();
        }
        else if (gui.getBookPlace().isSelected())
        {
            group.clearSelection();
        }
       
        else if (gui.getReserveService().isSelected())    
        {
            group.clearSelection();
        }
        else if (gui.getCheckWeather().isSelected())
        {
            group.clearSelection();
        }
        else if (gui.getSendComplaint().isSelected())
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
                
                if(gui.getEditPassword().isSelected())
                {   
                    ResidentEditPassword editPass=new ResidentEditPassword();
                    editPass.setLocationRelativeTo(null); // This makes the window appears centered
                    editPass.setVisible(true); 
                    gui.setVisible(false);
                    ResidentEditPasswordController residentEditPasswordControl=new ResidentEditPasswordController(editPass,accountsManager,resident,residentDemands,billsManager,r);
                }
                else if(gui.getViewBills().isSelected())
                {
                    ViewBill viewBill=new ViewBill();
                    viewBill.setLocationRelativeTo(null);
                    viewBill.setVisible(true);
                    gui.setVisible(false);
                    ViewBillController newBillControl=new ViewBillController(viewBill,resident,accountsManager,residentDemands,billsManager,r);
                }
                else if(gui.getBookPlace().isSelected())
                {
                    MakePlaceReservationGUI reservePlace = new MakePlaceReservationGUI();
                    reservePlace.setLocationRelativeTo(null);
                    reservePlace.setVisible(true);
                    gui.setVisible(false);
                    PlaceReservationController placereservaion_controller = new PlaceReservationController(reservePlace,r,resident,accountsManager,residentDemands,billsManager);
                }
                else if(gui.getReserveService().isSelected())
                {
                    AddNewRequest addRequest=new AddNewRequest();
                    addRequest.setLocationRelativeTo(null); // This makes the window appears centered
                    addRequest.setVisible(true); 
                    gui.setVisible(false);
                    AddNewRequestController addRequestControl=new AddNewRequestController(addRequest,resident,residentDemands,accountsManager,billsManager,r);
                }
                else if(gui.getCheckWeather().isSelected())
                {
                    ViewWeather viewWeather=new ViewWeather();
                    viewWeather.setLocationRelativeTo(null); // This makes the window appears centered
                    viewWeather.setVisible(true); 
                    gui.setVisible(false);
                    ViewWeatherController viewWeatherControl=new ViewWeatherController(viewWeather,resident,accountsManager,residentDemands,billsManager,r);
                }
                else if(gui.getSendComplaint().isSelected())
                {
                    AddNewComplaint addComplaint= new AddNewComplaint();
                    addComplaint.setLocationRelativeTo(null); // This makes the window appears centered
                    addComplaint.setVisible(true); 
                    gui.setVisible(false);
                    AddNewComplaintController addComplaintControl=new AddNewComplaintController(addComplaint,resident,residentDemands,accountsManager,billsManager,r);
                }
                
            
    }}
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
