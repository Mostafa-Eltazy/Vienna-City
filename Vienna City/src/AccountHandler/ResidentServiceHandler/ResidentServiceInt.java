/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountHandler.ResidentServiceHandler;

import AccountHandler.Person;
import AccountHandler.PublicRelationHandler.PublicRelation;
import java.sql.Time;

/**
 *
 * @author glori
 */
public interface ResidentServiceInt {
    //public void login(String u,String p);
    //public void logout();
    //public void editProfile(Person p);
    public void checkIn(Time t);
    public void checkOut(Time t);
    public float checkSalary();

    public void contactPublicRelation(PublicRelation pr, String m);
    public void getNewComplaintNotification(String m);
    public void getNewRequestNotification(String m);
}
