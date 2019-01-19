/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExternalRelationsController;

import ExternalRelations.ExternalRelationsManagerInt;
import GUI.ExternalRelationMainWindow;
import GUI.UpdateCompanyContract;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Cherine Hussein
 */
public class UpdateCompanyContractController{
    ExternalRelationsManagerInt managerInt;
    UpdateCompanyContract gui;
    public UpdateCompanyContractController(ExternalRelationsManagerInt managerInt,UpdateCompanyContract GUI) {
        this.managerInt=managerInt; 
        this.gui=GUI;
        
        gui.getAddContract().addActionListener(new UpdateContractAction());
        gui.getExit().addActionListener(new ExitAction());
    }
    
    
    class UpdateContractAction implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) {
           try 
           {
               managerInt.addContractToCompany(Integer.parseInt(gui.getAddContractCompanyID().getText()),gui.getContractType().getText(),Integer.parseInt(gui.getContractID().getText()), gui.getContractDate().getText(),gui.getExpiryDate().getText(),gui.getContractStatus().getText(), gui.getContractDescription().getText());
               
           } catch (RemoteException ex)
           {
             System.out.println("Exception Occured at Update Company Contract Controller");
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
