/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceHandler;

import java.util.ArrayList;
import ServiceHandler.ServiceManger;
/**
 *
 * @author glori
 */
public class BusStopPlace implements BusStopPlaceInt {
    
    private ArrayList<String> allocatedBusses;
    private Schedule bussesSchedule;
    private String region;

    public BusStopPlace(ArrayList<String> allocatedBusses, Schedule bussesSchedule, String region) {
        this.allocatedBusses = allocatedBusses;
        this.bussesSchedule = bussesSchedule;
        this.region = region;
    }

    public ArrayList<String> getAllocatedBusses() {
        return allocatedBusses;
    }

    public void setAllocatedBusses(ArrayList<String> allocatedBusses) {
        this.allocatedBusses = allocatedBusses;
    }

    public Schedule getBussesSchedule() {
        return bussesSchedule;
    }

    public void setBussesSchedule(Schedule bussesSchedule) {
        this.bussesSchedule = bussesSchedule;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    
    @Override
    public String checkBussesSchedule() {
       
       return "the number of busses in the bus stop is "+allocatedBusses.size()+" ,One will be dispatched according to the following slots, "+ getBussesSchedule().toString();
        
    }

    @Override
    public String toString() {
        String result=" ";
        result+= "The region of this stop is "+region;
        for (int i = 0; i < allocatedBusses.size(); i++) {
            result += "\n   Bus No"+i+ allocatedBusses.get(i);
                    
        }
        
        result += "\n   Bus No"+bussesSchedule.toString();
                    
        
        
        return result;
                
    }

    @Override
    public void addNewBus(String plates) {
      
        getAllocatedBusses().add(plates);  
    }


    
}
