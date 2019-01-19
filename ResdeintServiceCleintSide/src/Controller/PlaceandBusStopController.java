/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import AccountHandler.AccountsManagerInt;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import ServiceHandler.PlaceInt;
import ServiceHandler.ServiceManagerInt;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import GUI.AddPlaceGUI;
import GUI.ResidentServiceFunctionalities;
import GUI.ResidentServiceLogin;
import resdeintservicecleintside.ResdeintServiceCleintSide;

/**
 *
 * @author Mostafa
 */
public class PlaceandBusStopController {
    
    AddPlaceGUI gui;
    Registry r;
    ButtonGroup group;
    AccountsManagerInt accountsManager;
      public PlaceandBusStopController(AddPlaceGUI gui,AccountsManagerInt accountsManager,Registry r)
    {
       this.gui=gui;
       this.r = r;
       this.accountsManager=accountsManager;
       this.group=new ButtonGroup();
       group.add(gui.getCateringRadiobutton());
       group.add(gui.getReligiousRadiobutton());
       group.add(gui.getSocialRadiobutton());
       if(gui.getCateringRadiobutton().isSelected())
           group.clearSelection();
       else if(gui.getReligiousRadiobutton().isSelected())
           group.clearSelection();
       else if(gui.getSocialRadiobutton().isSelected())
           group.clearSelection();
       gui.getjButton1().addActionListener(new CreateplaceBtnAction());
       gui.getHome().addActionListener(new PlaceandBusStopController.HomeBtnAction());
        gui.getLogout().addActionListener(new PlaceandBusStopController.LogoutBtnAction());
        gui.getExit().addActionListener(new ExitBtnAction());
    }



class CreateplaceBtnAction implements ActionListener {

        public CreateplaceBtnAction() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
        
            try {
                ///////////////////////////////////
                //Creating The arraylist of dayssss
                ArrayList<String> scheduledays = new ArrayList<String>();
                if(gui.getSaturday().isSelected())
                    scheduledays.add("Saturday");
                if(!gui.getSaturday().isSelected())
                    scheduledays.remove("Saturday");
                if(gui.getSunday().isSelected())
                    scheduledays.add("Sunday");
                if(!gui.getSunday().isSelected())
                    scheduledays.remove("Sunday");
                if(gui.getMonDay().isSelected())
                    scheduledays.add("Monday");
                if(!gui.getMonDay().isSelected())
                    scheduledays.remove("Monday");
                if(gui.getThursDay().isSelected())
                    scheduledays.add("Thursday");
                if(!gui.getThursDay().isSelected())
                    scheduledays.add("Thursday");
                if(gui.getWendesDay().isSelected())
                    scheduledays.add("Wendesday");
                if(!gui.getWendesDay().isSelected())
                    scheduledays.remove("Wendesday");
                if(gui.getTuesDay().isSelected())
                    scheduledays.add("TuesDay");
                if(!gui.getTuesDay().isSelected())
                    scheduledays.remove("TuesDay");
                if(gui.getFriDay().isSelected())
                    scheduledays.add("Friday");
                if(!gui.getFriDay().isSelected())
                    scheduledays.remove("Friday");
                //////////////////////////////////////
                //Selecting The Type of place From GUI
                String placetype = null;
                if(gui.getSocialRadiobutton().isSelected())

                { placetype="s";
                  System.out.println("social is selecteddd");
                }
                else if(gui.getReligiousRadiobutton().isSelected())
                {   placetype="r";}
                else if(gui.getCateringRadiobutton().isSelected())
                { placetype="c";}
                ///////////////////////////////////////////////
                ServiceManagerInt SMI = (ServiceManagerInt) r.lookup("Factory");
                String placename = gui.getjTextField1().getText();
                String placeadress = gui.getjTextField2().getText();
                int Starttime = Integer.parseInt(gui.getStartingTime().getText());
                int Closingtime = Integer.parseInt(gui.getClosingTime().getText());
                SMI.CreateAplaceFactory(placetype,placename,placeadress,Starttime,Closingtime,scheduledays);
                //////////////////////////////////////////////////////
                //Display the Creation message
                System.out.println("enta m7tagggg tht labellll ");
              /*  if (placetype=="c") {
                    gui.getjLabel5().setText("Catering place has been created");
                }else if(placetype=="s"){
                gui.getjLabel5().setText("Social place has been created");
                }else if(placetype=="r"){
                gui.getjLabel5().setText("Religious place has been created");
                }*/
                /////////////////////////////////////////////////////
               
            } catch (RemoteException ex) {
                Logger.getLogger(PlaceandBusStopController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(PlaceandBusStopController.class.getName()).log(Level.SEVERE, null, ex);
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
     


