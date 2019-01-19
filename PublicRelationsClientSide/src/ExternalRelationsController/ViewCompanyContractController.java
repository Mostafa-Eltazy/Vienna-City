/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExternalRelationsController;

import ExternalRelations.ExternalRelationsManagerInt;
import ExternalRelations.ContractInt; 
import GUI.ExternalRelationMainWindow;
import GUI.ViewCompanyContract;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Cherine Hussein
 */
public class ViewCompanyContractController {
    ExternalRelationsManagerInt managerInt;
    ViewCompanyContract gui;
    public ViewCompanyContractController(ExternalRelationsManagerInt managerInt,ViewCompanyContract GUI){
        this.managerInt=managerInt; 
        this.gui=GUI; 
        
        gui.getViewContract().addActionListener(new ViewContractAction());
        gui.getExit().addActionListener(new ExitAction());
    }
    
    
    class ViewContractAction implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) {
           try{
           int CompanyId=Integer.parseInt(gui.getViewContractCompanyID().getText()); 
           ContractInt contractObj=managerInt.viewContractByID(CompanyId);
           gui.getViewContractType().setText(" "+contractObj.getType());
           gui.getViewContractDate().setText(" "+contractObj.getDate());
           gui.getViewContractExpiryDate().setText(" "+contractObj.getDateOfExpiry());
           gui.getViewContractStatus().setText(" "+contractObj.getStatus());
           gui.getViewContractDescription().setText(" "+contractObj.getDescription());
               
           }catch(RemoteException ex)
           {
               System.out.println("Exception Occured at View Contract Controller");
           }
        }
        
    
    
    }

    class ExitAction implements ActionListener 
    {
      @Override
      public void actionPerformed(ActionEvent ae) 
       {
            ExternalRelationMainWindow externalrelationMainWindow=new ExternalRelationMainWindow();
            externalrelationMainWindow.setLocationRelativeTo(null);
            externalrelationMainWindow.setVisible(true);
            gui.setVisible(false); 
            ExternalRelationsController externalRelationControllerObj=new ExternalRelationsController(externalrelationMainWindow,managerInt);   
       }
    }
    
    
    
}
