/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceHandler;

import DB.CateringPlaceTable;
import DB.ReligiousPlaceTable;
import DB.SocialPlaceTable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Mostafa
 */
public class ServiceManger extends UnicastRemoteObject implements ServiceManagerInt{
 
    public  ArrayList <BusStopPlace> busStopPlace;
    public  ArrayList <PlaceInt> place;
    public  ArrayList <SocialPlace> socialplaces;
    public ArrayList<ReligiousPlace> religiousPlaces;
    public ArrayList<CateringPlace> cateringPlaces;
    private static ServiceManger instance=null;
    public SocialPlaceTable spt;
    public ReligiousPlaceTable rpt;
    public CateringPlaceTable cpt;

    private ServiceManger()throws RemoteException {
        socialplaces = new ArrayList <>();
        place = new ArrayList <>();
        busStopPlace = new ArrayList <>();
        spt = new SocialPlaceTable();
        rpt = new ReligiousPlaceTable();
        cpt = new CateringPlaceTable();
    }
    public static ServiceManger getInstance()throws RemoteException {
        if(instance==null)
        {
            instance=new ServiceManger();
            return instance;
        }
        return instance;
    }
     ///////////////////////////////////////////////////
     //// BUS STOPS   /////////////////////////////////
     ///////////////////////////////////////////////
    @Override
    public String determineBusStop(String region)throws RemoteException{
    
        for(int i=0;i<busStopPlace.size();i++){
            if(busStopPlace.get(i).getRegion().equals(region))
                return busStopPlace.get(i).checkBussesSchedule();
                
        }
        return "";
    }
    @Override
    public void addbusstop(BusStopPlaceInt bsp)throws RemoteException{
    // type casting hnaaaaaaaaaaaaaaaaaaaaaaaaaa
        busStopPlace.add((BusStopPlace) bsp);
    }
    public ArrayList<BusStopPlace> getBusStop() throws RemoteException{
        return busStopPlace;
    }
     /////////////////////////////////////////////////////////////////////////////////////
     ////// ADD PLACE FACTORY PATTREN  //////////////////////////////////////////////////
     /////////////////////////////////////////////////////////////////////////////////

    

    @Override
    public void CreateAplaceFactory(String type, String Name, String Adress,int SchStartingTime,int SchClosingTime,ArrayList<String> schavailableDays) throws RemoteException {         
    PlaceFactory pf = new PlaceFactory();
    Schedule s = new Schedule(SchStartingTime,SchClosingTime,schavailableDays);
    PlaceInt p=pf.addaNewPlace(type,Name,Adress, (Schedule) s);
    System.out.println(p);
    }
    /////////////////////////////////////////////////////////////////////////////
     
    @Override
     public PlaceInt viewsocial(int i)throws RemoteException {
       
      //  this.socialplaces=spt.getAllplace();
       
        SocialPlace holder;
        holder = (SocialPlace) spt.getplaceByname("Nady El Zohour");
        
        
       //  socialplaces.equals(pt.getAllplace());
      //   holder.equals(socialplaces.get(i));
    
       System.out.println(holder.getName());
       System.out.println("el arraylist hsyalaa el dataaa");
     //  System.out.println(socialplaces.get(i).getName());
       return holder;
    }
    @Override
    public PlaceInt viewreligious(int i)throws RemoteException {
       
        
        ReligiousPlace holder;
        holder = (ReligiousPlace) rpt.getplaceByname("Rab3a");
        System.out.println(holder.getName());
        System.out.println("el arraylist hsyalaa el dataaa");
        return holder;
    }
    @Override
    public PlaceInt viewcatering(int i)throws RemoteException {
       
        
        CateringPlace holder;
        holder = (CateringPlace) cpt.getplaceByname("La Poire");
        System.out.println(holder.getName());
        System.out.println("el arraylist hsyalaa el dataaa");
        return holder;
    }

    public void reserveSlot(int col,int row) throws RemoteException{
        Schedule sc= new Schedule();
        sc.ReserveASlots(col, row);
    }
    
}