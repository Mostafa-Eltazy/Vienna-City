/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountHandler.PublicRelationHandler;

import DB.PublicRelationTable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.lang.String; 
import java.sql.Time;

/**
 *
 * @author Cherine Hussein
 */
public class PublicRelationManager extends UnicastRemoteObject implements PublicRelationManagerInt{
    private static PublicRelationManager prManager=null;
    private ArrayList<PublicRelation> PRs;
    private final PublicRelationTable prTable; 

    public PublicRelationManager() throws RemoteException {
     PRs =new ArrayList<>();
     prTable = new PublicRelationTable();  
    }
    
        public static PublicRelationManager getExternalRelationsManager ()throws RemoteException
    {
        if(prManager==null)
        {
            prManager= new PublicRelationManager();
            return prManager;
        }
        else 
            return prManager;
    }
        
    @Override
    public void PRLogin(String u, String p)throws RemoteException{
        PublicRelation pr=prTable.getPRyUsername(u);
        if(pr.getPassword().equals(p))
        {   
            System.out.println("Logged in");
            
        }
        else
            System.out.println("Wrong username or password");
    }
    public void addNewPR(String name, int SSN, String dateOfBirth, String username, String password) throws RemoteException
    {
        PublicRelation pr=new PublicRelation(name,SSN,dateOfBirth,username,password);
        prTable.insertPR(pr);
    
    }
    
    public String deletePR(String username) throws RemoteException
    {
        String deletion= prTable.deletePR(username); 
        return deletion;  
    }
    
    public PublicRelationInt viewPRByID(String username)throws RemoteException{
        return prTable.getPRyUsername(username); 
    } 
    
    
    public ArrayList<PublicRelationInt> viewAllPRs() throws RemoteException
    {
        PRs=prTable.getAllPRs();
        ArrayList<PublicRelationInt> PRsInt=new ArrayList<>();
        for(int i=0;i<PRs.size();i++)
        {
            PRsInt.add((PublicRelationInt)PRs.get(i));
        }
        return PRsInt;
    }
    
    
    
    
}
