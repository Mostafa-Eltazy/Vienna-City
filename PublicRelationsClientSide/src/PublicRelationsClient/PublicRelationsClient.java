/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicRelationsClient;


import AccountHandler.PublicRelationHandler.PublicRelationManagerInt;
import ExternalRelations.ExternalRelationsManagerInt;
import ExternalRelationsController.ExternalRelationsController;
import ExternalRelationsController.PRLoginController;
import GUI.ExternalRelationMainWindow;
import GUI.PRLogin;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Cherine Hussein
 */
public class PublicRelationsClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try
        {
            Registry r=LocateRegistry.getRegistry(1103); 
            System.out.println("Locating Registry for Client Side!");
            ExternalRelationsManagerInt externalrelations=(ExternalRelationsManagerInt)r.lookup("ExternalRelations");
            PublicRelationManagerInt PRmanager=(PublicRelationManagerInt)r.lookup("PRmanager");
            System.out.println("Locating Stub!");
            
            PRLogin gui=new PRLogin();
            gui.setLocationRelativeTo(null); // This makes the window appears centered
            gui.setVisible(true); 
            PRLoginController login = new PRLoginController(externalrelations,gui,PRmanager);
            
           
            
        }
        catch(Exception ex)
        {
            System.out.println("Exception on client side occured!");
        }
    }
    
}
