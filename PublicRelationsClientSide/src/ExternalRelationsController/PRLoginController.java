/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExternalRelationsController;

import AccountHandler.PublicRelationHandler.PublicRelationManagerInt;
import ExternalRelations.ExternalRelationsManagerInt;
import GUI.ExternalRelationMainWindow;
import GUI.PRLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

/**
 *
 * @author glori
 */
public class PRLoginController {
     ExternalRelationsManagerInt managerInt;
     PublicRelationManagerInt PRmanager;
     PRLogin gui;

    public PRLoginController(ExternalRelationsManagerInt managerInt, PRLogin gui,PublicRelationManagerInt PRmanager) {
        this.managerInt = managerInt;
        this.gui = gui;
        this.PRmanager=PRmanager;
        gui.getLogin().addActionListener(new LoginBtnAct());
        gui.getExit().addActionListener(new ExitBtnAction());
    }
     class LoginBtnAct implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
           try 
           {
                PRmanager.PRLogin(gui.getjTextField1().getText(), gui.getjPasswordField1().getText());
                ExternalRelationMainWindow maingui=new ExternalRelationMainWindow(); 
                maingui.setLocationRelativeTo(null);
                maingui.setVisible(true);
                gui.setVisible(false);
                ExternalRelationsController mainController= new ExternalRelationsController(maingui,managerInt);
            
               
           } catch (RemoteException ex)
           {
             System.out.println("Exception Occured at External Relations Controller");
           }
        }
    
    }
     public class ExitBtnAction implements ActionListener{
    @Override
        public void actionPerformed(ActionEvent ae) {
               System.exit(0);  
        }
}
}
