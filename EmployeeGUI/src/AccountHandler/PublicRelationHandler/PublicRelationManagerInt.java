/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountHandler.PublicRelationHandler;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Cherine Hussein
 */
public interface PublicRelationManagerInt extends Remote{
    public void PRLogin(String u, String p)throws RemoteException;
}
