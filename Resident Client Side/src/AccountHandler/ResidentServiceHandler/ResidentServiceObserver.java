/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountHandler.ResidentServiceHandler;

/**
 *
 * @author glori
 */
public interface ResidentServiceObserver {
    
    public String getName();
    public void getNewComplaintNotification(String m);
    public void getNewRequestNotification(String m);
}
