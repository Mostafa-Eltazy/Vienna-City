/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountHandler;

import AccountHandler.AdminHandler.Admin;
import AccountHandler.EmplyeeHandler.Employee;
import AccountHandler.PublicRelationHandler.PublicRelation;
import AccountHandler.ResidentHandler.Resident;
import AccountHandler.ResidentHandler.ResidentInt;
import AccountHandler.ResidentServiceHandler.ResidentService;
import DB.ResidentServiceTable;
import DB.ResidentTable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author glori
 */
public class AccountsManager extends UnicastRemoteObject implements AccountsManagerInt{
    private static AccountsManager accountManager=null;
    private ArrayList<Resident> residents;
    private ArrayList<PublicRelation> PRs;
    private ArrayList<Employee> employees;
    private ArrayList<ResidentService> residentServices;
    private ResidentTable residentTable;
    private ResidentServiceTable residentServiceTable;
    private AccountsManager()throws RemoteException{
        residentTable=new ResidentTable();
        residentServiceTable=new ResidentServiceTable();
        residents=residentTable.getAllResidents();
        PRs=new ArrayList<>();
        employees=new ArrayList<>();
        residentServices=residentServiceTable.getAllResidentServices();
        
    }
    
    public static AccountsManager getAccountManager()throws RemoteException{
        if(accountManager==null)
        {
            accountManager=new AccountsManager();
            return accountManager;
        }
        else
            return accountManager;
    }
    
    public void addNewResident(Resident r){
        this.residentTable.insertResident(r);
    }
    
    @Override
    public ResidentInt residentLogin(String u,String p)throws RemoteException{
        
        Resident resident=residentTable.getResidentByUsername(u);
        if(resident.getPassword().equals(p))
        {
            System.out.println("Logged in");
            return (ResidentInt) UnicastRemoteObject.exportObject(resident,1102);
        }
        else
            return null;
    }
    public void addNewResidentService(ResidentService r){
        this.residentServiceTable.insertResidentService(r);
    }
    @Override
    public void residentServiceLogin(String u,String p)throws RemoteException{
        
        ResidentService residentService=residentServiceTable.getResidentServiceByUsername(u);
        if(residentService.getPassword().equals(p))
        
            System.out.println("Logged in");
         
    }
    @Override
    public void updateNewBillIsAdded(String n)throws RemoteException
    {
        residentTable.updateNewBillIsAdded(residentTable.getResidentByName(n));
    }
    
    public void deleteAllResidentsBySpecificName(String n){
        residentTable.deleteAllResidentsBySpecificName(n);
    }
    public Resident getResidentByName(String name){
        
        return residentTable.getResidentByName(name);
    }

    public ArrayList<ResidentService> getResidentServices() {
        return residentServices;
    }
    
    @Override
    public void residentEditPassword(ResidentInt r,String p,String newP)throws RemoteException{
        Resident resident=residentTable.getResidentByUsername(r.getUsername());
        if(resident.getPassword().equals(p))
        {
            System.out.println(newP);
            resident.setPassword(newP);
            System.out.println(resident.getPassword());
            //return (ResidentInt) UnicastRemoteObject.exportObject(residentTable.updateResident(resident),1102);
        }
        else
        {   
            System.out.println("Cannot update password");
            //return null;
        }
    }

    public ResidentTable getResidentTable() {
        return residentTable;
    }
    
    
}
