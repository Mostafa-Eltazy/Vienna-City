/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExternalRelationsController;

import ExternalRelations.ExternalRelationsManagerInt;
import GUI.DeleteCompany;
import GUI.ExternalRelationMainWindow; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;


/**
 *
 * @author Cherine Hussein
 */
public class DeleteCompanyController {
    ExternalRelationsManagerInt managerInt;
    DeleteCompany gui;
    public DeleteCompanyController(ExternalRelationsManagerInt managerInt,DeleteCompany GUI){
        this.managerInt=managerInt; 
        this.gui=GUI;
        
        gui.getDeleteCompany().addActionListener(new DeleteCompanyAction());
        gui.getExit().addActionListener(new ExitAction());
    }

    class DeleteCompanyAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try
            {
                int companyId=Integer.parseInt(gui.getCompanyID().getText());
                String deletionGUI=managerInt.deleteCompanyById(companyId); 
                gui.getStatus().setText("  "+deletionGUI+" ");
                
            }
            catch(RemoteException re)
            {
             System.out.println("Exception Occured at Delete Company Controller");
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
