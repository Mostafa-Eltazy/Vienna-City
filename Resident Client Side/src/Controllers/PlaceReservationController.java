/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import AccountHandler.AccountsManagerInt;
import AccountHandler.ResidentHandler.ResidentInt;
import BillPayment.BillManagerInt;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import ServiceHandler.PlaceInt;
import ServiceHandler.ScheduleInt;
import ServiceHandler.ServiceManagerInt;
import java.util.ArrayList;
import java.rmi.registry.Registry;
import javax.swing.JCheckBox;
import GUI.MakePlaceReservationGUI;
import GUI.ResidentFunctionalities;
import GUI.ResidentLogin;
import ResidentDemandsHandler.ResidentDemandsManagerInt;

/**
 *
 * @author Mostafa
 */
public class PlaceReservationController {
    
    MakePlaceReservationGUI gui;
    Registry r;
    ResidentInt resident;
    AccountsManagerInt accountsManager;
    ResidentDemandsManagerInt residentDemands;
    BillManagerInt billsManager;
    public PlaceReservationController(MakePlaceReservationGUI gui, Registry r,ResidentInt resident, AccountsManagerInt accountsManager, ResidentDemandsManagerInt residentDemands,BillManagerInt billsManager) {
        this.gui = gui;
        this.r = r;
        this.resident=resident;
        this.accountsManager=accountsManager;
        this.residentDemands=residentDemands;
        this.billsManager=billsManager;
        gui.getsocialbutton().addActionListener(new ViewsocialSlots());
        gui.getcateringbutton().addActionListener(new ViewcateringSlots());
        gui.getrelisgiousbutton().addActionListener(new ViewreligiousSlots());
        gui.reserveSelectedSlots().addActionListener(new reserveSelectedSlots());
        gui.getHome().addActionListener(new PlaceReservationController.HomeBtnAction());
        gui.getLogout().addActionListener(new PlaceReservationController.LogoutBtnAction());
        gui.getExit().addActionListener(new ExitBtnAction());
      }

    class reserveSelectedSlots implements ActionListener{

        public reserveSelectedSlots() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
           
            try {
             
                
                ServiceManagerInt SMI = (ServiceManagerInt) r.lookup("Factory"); //To change body of generated methods, choose Tools | Templates.
                int weeknumber;
                int slot;
                 for(int l=0;l<=84;l++){
        
                    gui.getslotcheckboxes(l);
                    if(gui.getslotcheckboxes(l).isSelected())
                            if(l<=12)
                            {weeknumber=0;
                                slot=l;
                                SMI.reserveSlot(weeknumber, slot);
                                System.out.println("reserved at "+weeknumber+" and slot "+slot);
                            }
                            else if (l>=13&&l<=24)
                            {
                                weeknumber=1;
                                slot=l-12;
                                System.out.println("reserved at "+weeknumber+" and slot "+slot);
                            }
                            else if (l>=25&&l<=36)
                            {
                                weeknumber=2;
                                slot=l-24;
                                System.out.println("reserved at "+weeknumber+" and slot "+slot);
                            }
                            else if (l>=37&&l<=48)
                            {   weeknumber=3;
                                slot=l-36;
                                System.out.println("reserved at "+weeknumber+" and slot "+slot);
                            }
                            else if (l>=49&&l<=60)
                            {
                                weeknumber=4;
                                slot=l-48;
                                System.out.println("reserved at "+weeknumber+" and slot "+slot);
                            }
                            else if (l>=61&&l<=72)
                            {
                                weeknumber=5;
                                slot=l-60;
                                System.out.println("reserved at "+weeknumber+" and slot "+slot);
                            }
                            else if (l>=73&&l<=86)
                            {
                                weeknumber=6;
                                slot=l-72;
                                System.out.println("reserved at "+weeknumber+" and slot "+slot);
                            }
                            
                            else{
                                weeknumber=-1;
                                slot=-1;
                            
                            }
                    }   
                
                    
                    
                
            
            } catch (RemoteException ex) {
                Logger.getLogger(PlaceReservationController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(PlaceReservationController.class.getName()).log(Level.SEVERE, null, ex);
            }

            }
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
                Logger.getLogger(PlaceReservationController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(PlaceReservationController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(PlaceReservationController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(PlaceReservationController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(PlaceReservationController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex) {
                Logger.getLogger(PlaceReservationController.class.getName()).log(Level.SEVERE, null, ex);
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
