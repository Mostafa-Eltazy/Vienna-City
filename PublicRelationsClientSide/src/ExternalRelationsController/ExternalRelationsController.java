/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExternalRelationsController;

import GUI.ExternalRelationMainWindow;
import ExternalRelations.ExternalRelationsManagerInt; 
import GUI.AddNewCompany;
import GUI.UpdateCompanyContract;
import GUI.ViewCompanyContract;
import GUI.RemoveContractFromCompany;
import GUI.ViewAllCompanies;
import GUI.DeleteCompany; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;

/**
 *
 * @author Cherine Hussein
 */
public class ExternalRelationsController {
     ExternalRelationMainWindow gui; 
     ExternalRelationsManagerInt externalrelationsManagerInt; 
     ButtonGroup group;

    public ExternalRelationsController(ExternalRelationMainWindow gui, ExternalRelationsManagerInt externalrelationsManagerInt) {
        this.gui = gui;
        this.externalrelationsManagerInt = externalrelationsManagerInt;
        this.group = new ButtonGroup();
        group.add(gui.getaddNewCompany());
        group.add(gui.getUpdateCompanyContract());
        group.add(gui.getViewCompanyContract());
        group.add(gui.getRemoveContractFromCompany());
        group.add(gui.getViewAllCompanies());
        group.add(gui.getDeleteCompany());
        
        if (gui.getaddNewCompany().isSelected())
        {
            group.clearSelection();
        }
        else if (gui.getUpdateCompanyContract().isSelected())
        {
            group.clearSelection();

            
        }
        else if (gui.getViewCompanyContract().isSelected())
        {
            group.clearSelection();

        }
       
        else if (gui.getViewAllCompanies().isSelected())    
        {
            group.clearSelection();

        }
        else if (gui.getRemoveContractFromCompany().isSelected())
        {
            group.clearSelection(); 

        }
        else if (gui.getDeleteCompany().isSelected())
        {
            group.clearSelection();

        }
        gui.getSelect().addActionListener(new FunctionalitySelection());
        
        
    }
    
    class FunctionalitySelection implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae){
            
             if(gui.getaddNewCompany().isSelected()) 
                {   
                    AddNewCompany addCompany=new AddNewCompany();
                    addCompany.setLocationRelativeTo(null); // This makes the window appears centered
                    addCompany.setVisible(true); 
                    gui.setVisible(false);
                    AddNewCompanyController addCompanyControllerObj=new AddNewCompanyController(externalrelationsManagerInt,addCompany);
                            }
                else if(gui.getUpdateCompanyContract().isSelected())
                {
                    UpdateCompanyContract updateCompanysContract= new UpdateCompanyContract();
                    updateCompanysContract.setLocationRelativeTo(null); // This makes the window appears centered
                    updateCompanysContract.setVisible(true); 
                    gui.setVisible(false);
                    UpdateCompanyContractController updateCompanyContractControllerObj=new UpdateCompanyContractController(externalrelationsManagerInt,updateCompanysContract);
                    
                }
                else if(gui.getViewCompanyContract().isSelected())
                {
                    ViewCompanyContract viewCompanysContract= new ViewCompanyContract();
                    viewCompanysContract.setLocationRelativeTo(null); // This makes the window appears centered
                    viewCompanysContract.setVisible(true); 
                    gui.setVisible(false);
                    ViewCompanyContractController viewCompanyContractControllerObj=new ViewCompanyContractController(externalrelationsManagerInt,viewCompanysContract);
                }
                else if(gui.getRemoveContractFromCompany().isSelected())
                {
                    RemoveContractFromCompany removeContract= new RemoveContractFromCompany();
                    removeContract.setLocationRelativeTo(null); // This makes the window appears centered
                    removeContract.setVisible(true); 
                    gui.setVisible(false);
                    RemoveContractFromCompanyController removeCompanyContollerObj=new RemoveContractFromCompanyController(externalrelationsManagerInt,removeContract);
                   
                }
                else if(gui.getViewAllCompanies().isSelected())
                {
                    ViewAllCompanies viewAllCompanies= new ViewAllCompanies();
                    viewAllCompanies.setLocationRelativeTo(null); // This makes the window appears centered
                    viewAllCompanies.setVisible(true); 
                    gui.setVisible(false);
                    ViewAllCompaniesController viewAllComapniesContollerObj =new ViewAllCompaniesController(externalrelationsManagerInt,viewAllCompanies);

                }
                else if(gui.getDeleteCompany().isSelected())
                {
                    DeleteCompany deleteCompany= new DeleteCompany();
                    deleteCompany.setLocationRelativeTo(null); // This makes the window appears centered
                    deleteCompany.setVisible(true); 
                    gui.setVisible(false);
                    DeleteCompanyController deleteCompanyControllerObj=new DeleteCompanyController(externalrelationsManagerInt,deleteCompany);
                   
                }
           
        }      
    }
    
}
