/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExternalRelationsController;

import ExternalRelations.ExternalRelationsManagerInt;
import GUI.ExternalRelationMainWindow;
import GUI.ViewAllCompanies;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Cherine Hussein
 */
public class ViewAllCompaniesController {
    ExternalRelationsManagerInt managerInt;
    ViewAllCompanies gui;

    public ViewAllCompaniesController(ExternalRelationsManagerInt managerInt,ViewAllCompanies GUI) {
        this.managerInt = managerInt;
        this.gui=GUI;
        
        gui.getExit().addActionListener(new ExitAction());
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
