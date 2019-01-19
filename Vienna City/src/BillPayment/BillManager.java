/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BillPayment;

import DB.BillDB;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author mohamed
 */
public class BillManager extends UnicastRemoteObject implements BillManagerInt{
    
    
    private static BillManager Manager=null;
    private BillDB bd;
    private BillManager() throws RemoteException{
        bd=new BillDB();
    }
    public static BillManager getInstance() throws RemoteException{
        if(Manager==null)
        {
            Manager=new BillManager();
            return Manager;
        }
        else 
            return Manager;
    }

    public BillDB getBd() {
        return bd;
    }
    
    @Override
    public void addBill(int ID, String residentName, String type, String description, double amount) throws RemoteException{
        Bill b=new Bill(ID,residentName,type,description,amount,new Cash());
        bd.insertBill(b);
    }
}
