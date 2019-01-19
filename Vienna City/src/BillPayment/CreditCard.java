/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BillPayment;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JOptionPane;
/**
 *
 * @author glori
 */
public class CreditCard extends UnicastRemoteObject implements Payment{
    private int creditCardNum;

    public CreditCard(int creditCardNum) throws RemoteException{
        this.creditCardNum = creditCardNum;
    }

    public CreditCard() throws RemoteException{
    }

    @Override
    public String pay(double b) throws RemoteException{
        return "Paid Sucessfully";
    }
    
    public int getCreditCardNum() throws RemoteException{
        return creditCardNum;
    }

    public void setCreditCardNum(int creditCardNum) throws RemoteException{
        this.creditCardNum = creditCardNum;
    }

    @Override
    public String toString() {
        return "CreditCard{" + "creditCardNum=" + creditCardNum + '}';
    }
    
}
