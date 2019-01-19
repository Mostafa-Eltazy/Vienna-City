/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExternalRelationsController;

import ExternalRelations.ExternalRelationsManagerInt;
import GUI.AddNewCompany;
import GUI.ExternalRelationMainWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;


/**
 *
 * @author Cherine Hussein
 */
public class AddNewCompanyController {
    ExternalRelationsManagerInt managerInt;
    AddNewCompany gui; 
    public AddNewCompanyController(ExternalRelationsManagerInt managerInt,AddNewCompany GUI) {
        this.managerInt=managerInt; 
        this.gui=GUI;
        
        gui.getAddCompany().addActionListener(new AddCompanyAction());
        gui.getExit().addActionListener(new ExitAction());
       
    }
    
    
    
    class AddCompanyAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
           try 
           {
               managerInt.addNewCompany(gui.getCompanyName().getText(),Integer.parseInt(gui.getCompanyID().getText()), gui.getCompanyAddress().getText(), gui.getCompanySpecilization().getText(), null, gui.getCompanyEmail().getText());
               
           } catch (RemoteException ex)
           {
             System.out.println("Exception Occured at Add New Company Controller");
           }
        }
    
    }
    
      class ExitAction implements ActionListener 
      {
        @Override
        public void actionPerformed(ActionEvent ae) {
            ExternalRelationMainWindow externalrelationMainWindow=new ExternalRelationMainWindow();
            externalrelationMainWindow.setLocationRelativeTo(null);
            externalrelationMainWindow.setVisible(true);
            gui.setVisible(false); 
            ExternalRelationsController externalRelationControllerObj=new ExternalRelationsController(externalrelationMainWindow,managerInt);   
        }
      }
    
    
    
}
      
    
   
    
    
    
 
    

