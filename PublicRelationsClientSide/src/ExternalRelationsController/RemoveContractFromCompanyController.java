/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExternalRelationsController;

import ExternalRelations.ExternalRelationsManagerInt;
import GUI.ExternalRelationMainWindow;
import GUI.RemoveContractFromCompany;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

/**
 *
 * @author Cherine Hussein
 */
public class RemoveContractFromCompanyController {
    ExternalRelationsManagerInt managerInt;
    RemoveContractFromCompany gui;
    public RemoveContractFromCompanyController(ExternalRelationsManagerInt managerInt,RemoveContractFromCompany GUI){
        this.managerInt=managerInt; 
        this.gui=GUI;
        
        gui.getRemoveContract().addActionListener(new RemoveContractAction());
        gui.getExit().addActionListener(new ExitAction());
        
    }
    
    class RemoveContractAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try
            {
                int companyId=Integer.parseInt(gui.getRemoveContractfromCompanyID().getText());
                String removalGUI=managerInt.removeContract(companyId); 
                gui.getRemoveStatus().setText("  "+removalGUI+" ");
                
            }
            catch(RemoteException re)
            {
             System.out.println("Exception Occured at Remove Contract from Company Controller");
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
