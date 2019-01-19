/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BillPayment;

import DB.BillDB;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author glori
 */
public class Bill extends UnicastRemoteObject implements BillInt{
    private final int ID;
    private final String residentName;
    private final String type;
    private final String description;
    private final double amount;
    private Cash payment1;
    private CreditCard payment2;
    private ArrayList<Bill> bills;
    

    
    
    public Bill(int ID, String residentName, String type, String description, double amount,Cash payment1) throws RemoteException{
        this.ID = ID;
        this.residentName = residentName;
        this.type = type;
        this.description = description;
        this.amount = amount;
        this.payment1 = payment1;
        
    }
    
     public Bill(int ID, String residentName, String type, String description, double amount,CreditCard payment2) throws RemoteException{
        this.ID = ID;
        this.residentName = residentName;
        this.type = type;
        this.description = description;
        this.amount = amount;
        this.payment2 = payment2;
    }

   
    
    public Payment selectPaymentMethod(String m) throws RemoteException{
        if("c".equals(m))
            return new Cash();
        else if("cc".equals(m))
            return new CreditCard();
        else
            return null;
    }

     
     
   
    
    public int getID() throws RemoteException{
        return ID;
    }

    public String getResidentName() throws RemoteException{
        return residentName;
    }

    public String getType() throws RemoteException{
        return type;
    }

    public String getDescription() throws RemoteException{
        return description;
    }

    public double getAmount() throws RemoteException{
        return amount;
    }

    public void setPayment1(Cash payment1) {
        this.payment1 = payment1;
    }

    public void setPayment2(CreditCard payment2) {
        this.payment2 = payment2;
    }

    
    
    
    @Override
    public String toString() {
        return "Bill{" + "ID=" + ID + ", residentName=" + residentName + ", type=" + type + ", description=" + description + ", amount=" + amount + ", payment=" + '}';
    }

    @Override
    public BillInt getBillByIndex(int i) throws RemoteException {
        BillDB b = new BillDB();
        
        return (BillInt) b.getBillByID(i);  
    }
    
    
    
}