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
public class Cash extends UnicastRemoteObject implements Payment{

    public Cash() throws RemoteException{
    }
    
    
    
    @Override
    public String pay(double b) throws RemoteException{
        
        return "Paid Sucessfully";
    }
}