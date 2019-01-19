/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import AccountHandler.AccountsManagerInt;
import ServiceHandler.ServiceManagerInt;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import GUI.ApprovePlaceReservationGUI;
import GUI.ResidentServiceFunctionalities;
import GUI.ResidentServiceLogin;


/**
 *
 * @author Mostafa
 */
public class ApproveReservationController {
    
     ApprovePlaceReservationGUI gui;
     Registry r;
     AccountsManagerInt accountsManager;
    public ApproveReservationController(ApprovePlaceReservationGUI gui,AccountsManagerInt accountsManager, Registry r) {
        this.gui = gui;
        this.r = r;
        this.accountsManager=accountsManager;
        gui.getsocialbutton().addActionListener(new ApproveReservationController.ViewsocialSlots());
        gui.getrelisgiousbutton().addActionListener(new ApproveReservationController.ViewreligiousSlots());
        gui.getsocialbutton().addActionListener(new ApproveReservationController.ViewcateringSlots());
        gui.getHome().addActionListener(new ApproveReservationController.HomeBtnAction());
        gui.getLogout().addActionListener(new ApproveReservationController.LogoutBtnAction());
        gui.getExit().addActionListener(new ExitBtnAction());
      }
    
    class ViewsocialSlots implements ActionListener {

        public ViewsocialSlots() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
             
                
                ServiceManagerInt SMI = (ServiceManagerInt) r.lookup("Factory"); //To change body of generated methods, choose Tools | Templates.
                gui.getjTextField1().setText(SMI.viewsocial(0).getName());
                gui.getjTextField2().setText(SMI.viewsocial(0).getAddress());
                gui.getjTextField3().setText(" "+SMI.viewsocial(0).getPlaceSchedule().getStaringtime());
                gui.getjTextField4().setText(" "+SMI.viewsocial(0).getPlaceSchedule().getClosingTime());
                ArrayList<String> dayz =SMI.viewsocial(0).getPlaceSchedule().getAvailableDays();
                int numberofslots = SMI.viewsocial(0).getPlaceSchedule().getClosingTime()-SMI.viewsocial(0).getPlaceSchedule().getStaringtime();
                ArrayList<JCheckBox> slotchecker = new ArrayList<>(numberofslots);
                
              System.out.println("the number of slots "+ numberofslots);
              System.out.println("awl youmm hwwaaaa"+dayz.get(0));
                for(int i=0;i<dayz.size();i++){
                   
                    System.out.println("we arelooping on "+dayz.get(i));
                    if(null != dayz.get(i))
                    switch (dayz.get(i)) {
                        case "Saturday":
                            System.out.println("sabttttt");
                            gui.getsaturdayday().setText("Saturday");
                            for(int s=1;s<=12;s++){
                                if(s<numberofslots)
                                gui.getslotcheckboxes(s).setVisible(true);
                                else
                                {
                               
                                }
                            }
                            break;
                        case "Sunday":
                            System.out.println("haddddddddddd");
                            gui.getsundayday().setText("Sunday");
                            for(int s=13;s<=24;s++){
                          
                                 if(s<=numberofslots+12)
                                gui.getslotcheckboxes(s).setVisible(true);
                                else
                                {
                               
                                }
                            }
                            break;
                        case "Monday":
                            System.out.println("etnyyyn");
                            gui.getmondayday().setText("Monday");
                            for(int s=25;s<=36;s++){
                          
                             if(s<=numberofslots+24)
                                gui.getslotcheckboxes(s).setVisible(true);
                                else
                                {
                               
                                }
                            }
                            break;
                        case "TuesDay":
                            System.out.println("tlaaaatt");
                            gui.gettuesdayday().setText("TuesDay");
                            for(int s=37;s<=48;s++){
                           if(s<=numberofslots+36)
                                gui.getslotcheckboxes(s).setVisible(true);
                                else
                                {
                               
                                }
                            }
                            break;
                        case "Wendesday":
                            System.out.println("arb333");
                            gui.getwendesdayday().setText("Wendesday");
                            for(int s=49;s<=60;s++){
                          
                                 if(s<=numberofslots+48)
                                gui.getslotcheckboxes(s).setVisible(true);
                                else
                                {
                               
                                }
                                
                            }
                            break;
                        case "Thursday":
                            System.out.println("khamyees");
                            gui.getthursdayday().setText("Thursday");
                            for(int s=61;s<=72;s++){
                          
                                 if(s<=numberofslots+60)
                                gui.getslotcheckboxes(s).setVisible(true);
                                else
                                {
                               
                                }
                            }
                            break;
                        case "Friday":
                            System.out.println("gom3aaa");
                            gui.getfridayday().setText("Friday");
                            for(int s=73;s<=84;s++){
                          
                                 if(s<=numberofslots+72)
                                gui.getslotcheckboxes(s).setVisible(true);
                                else
                                {
                               
                                }
                            }
                            break;
                        default:
                            break;
                    }
                
                    
                    
                }
            
            } catch (RemoteException ex) {
                Logger.getLogger(ApproveReservationController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(ApproveReservationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    class ViewcateringSlots implements ActionListener {

        public ViewcateringSlots() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
             
                
                ServiceManagerInt SMI = (ServiceManagerInt) r.lookup("Factory"); //To change body of generated methods, choose Tools | Templates.
                gui.getjTextField1().setText(SMI.viewcatering(0).getName());
                gui.getjTextField2().setText(SMI.viewcatering(0).getAddress());
                gui.getjTextField3().setText(" "+SMI.viewcatering(0).getPlaceSchedule().getStaringtime());
                gui.getjTextField4().setText(" "+SMI.viewcatering(0).getPlaceSchedule().getClosingTime());
                ArrayList<String> dayz =SMI.viewcatering(0).getPlaceSchedule().getAvailableDays();
                System.out.println("awl youmm hwwaaaa"+dayz.get(0));
                for(int i=0;i<dayz.size();i++){
                   
                    System.out.println("we arelooping on "+dayz.get(i));
                    if(null != dayz.get(i))
                    switch (dayz.get(i)) {
                        case "Saturday":
                            System.out.println("sabttttt");
                            gui.getsaturdayday().setText("Saturday");
                            break;
                        case "Sunday":
                            System.out.println("haddddddddddd");
                            gui.getsundayday().setText("Sunday");
                            break;
                        case "Monday":
                            System.out.println("etnyyyn");
                            gui.getmondayday().setText("Monday");
                            break;
                        case "Thursday":
                            System.out.println("tlaaaatt");
                            gui.getthursdayday().setText("Thursday");
                            break;
                        case "Wendesday":
                            System.out.println("arb333");
                            gui.getwendesdayday().setText("Wendesday");
                            break;
                        case "TuesDay":
                            System.out.println("khamyees");
                            gui.gettuesdayday().setText("Tuesday");
                            break;
                        case "Friday":
                            System.out.println("gom3aaa");
                            gui.getfridayday().setText("Friday");
                            break;
                        default:
                            break;
                    }
                
                }
                
            } catch (RemoteException ex) {
                Logger.getLogger(ApproveReservationController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(ApproveReservationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    class ViewreligiousSlots implements ActionListener {

        public ViewreligiousSlots() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
             
                
                ServiceManagerInt SMI = (ServiceManagerInt) r.lookup("Factory"); //To change body of generated methods, choose Tools | Templates.
                gui.getjTextField1().setText(SMI.viewreligious(0).getName());
                gui.getjTextField2().setText(SMI.viewreligious(0).getAddress());
                gui.getjTextField3().setText(" "+SMI.viewreligious(0).getPlaceSchedule().getStaringtime());
                gui.getjTextField4().setText(" "+SMI.viewreligious(0).getPlaceSchedule().getClosingTime());
                ArrayList<String> dayz =SMI.viewreligious(0).getPlaceSchedule().getAvailableDays();
                System.out.println("awl youmm hwwaaaa"+dayz.get(0));
                for(int i=0;i<dayz.size();i++){
                    System.out.println("we arelooping on "+dayz.get(i));
                    if(null != dayz.get(i))
                    switch (dayz.get(i)) {
                        case "Saturday":
                            System.out.println("sabttttt");
                            gui.getsaturdayday().setText("Saturday");
                            break;
                        case "Sunday":
                            System.out.println("haddddddddddd");
                            gui.getsundayday().setText("Sunday");
                            break;
                        case "Monday":
                            System.out.println("etnyyyn");
                            gui.getmondayday().setText("Monday");
                            break;
                        case "Thursday":
                            System.out.println("tlaaaatt");
                            gui.getthursdayday().setText("Thursday");
                            break;
                        case "Wendesday":
                            System.out.println("arb333");
                            gui.getwendesdayday().setText("Wendesday");
                            break;
                        case "TuesDay":
                            System.out.println("khamyees");
                            gui.gettuesdayday().setText("Tuesday");
                            break;
                        case "Friday":
                            System.out.println("gom3aaa");
                            gui.getfridayday().setText("Friday");
                            break;
                        default:
                            break;
                    }
                
                }
                
            } catch (RemoteException ex) {
                Logger.getLogger(ApproveReservationController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(ApproveReservationController.class.getName()).log(Level.SEVERE, null, ex);
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
