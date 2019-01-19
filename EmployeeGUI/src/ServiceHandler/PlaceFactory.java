/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceHandler;
import DB.CateringPlaceTable;
import DB.ReligiousPlaceTable;
import DB.SocialPlaceTable;
import ServiceHandler.PlaceInt;
import java.rmi.RemoteException;

/**
 *
 * @author Mostafa
 */
public class PlaceFactory {
 
    
public PlaceInt addaNewPlace(String s,String Name,String Address,Schedule sch) throws RemoteException{

    PlaceInt p;
    
    if("r".equals(s)){
            PlaceInt rp = new ReligiousPlace(Name,Address,sch);
            System.out.println("Religious Place is added");
            ReligiousPlaceTable rpt = new ReligiousPlaceTable();
            rpt.insertplace((ReligiousPlace) rp);
            return rp;
    }
    else if ("s".equals(s))
    {
            PlaceInt sp =  new SocialPlace(Name,Address,sch);
            System.out.println("Social Place is added");
            SocialPlaceTable spt = new SocialPlaceTable();
            spt.insertplace((SocialPlace) sp);
            return sp;

    }
    else 
    {
            PlaceInt cp = new CateringPlace(Name,Address,sch);
            System.out.println("Catering Place is added");
            CateringPlaceTable cpt = new CateringPlaceTable();
            cpt.insertplace((CateringPlace) cp);
            return cp;
    }
}
        


}

