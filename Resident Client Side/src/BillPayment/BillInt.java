/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BillPayment;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author glori
 */
public interface BillInt extends Remote{
    public String getResidentName() throws RemoteException;
    public int getID() throws RemoteException;
    public String getType() throws RemoteException;
    public String getDescription() throws RemoteException;
    public double getAmount() throws RemoteException;
    public BillInt getBillByIndex(int i) throws RemoteException;
    public Payment selectPaymentMethod(String m) throws RemoteException;
}
