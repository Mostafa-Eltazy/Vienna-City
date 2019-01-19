/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountHandler.ResidentHandler;

import AccountHandler.Person;
import BillPayment.Bill;
import BillPayment.BillInt;
import ResidentDemandsHandler.Complaint;
import ResidentDemandsHandler.ComplaintInt;
import ResidentDemandsHandler.Request;
import ResidentDemandsHandler.RequestInt;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author glori
 */
public class Resident extends Person implements ResidentInt{
    private ArrayList<Bill> bills;
    private ArrayList<Request> requests;
    private ArrayList<Complaint> complaints;
    private String address,region;
    private String phone;
    private boolean newBillIsAdded; 

    public Resident(){
        this.requests=new ArrayList<>();
        this.complaints=new ArrayList<>();
        this.bills=new ArrayList<>();
        this.newBillIsAdded=false;
    }

    public Resident(String name, int SSN, String dateOfBirth, String username, String password){
        super(name, SSN, dateOfBirth, username, password);
        this.requests=new ArrayList<>();
        this.complaints=new ArrayList<>();
        this.bills=new ArrayList<>();
        this.newBillIsAdded=false;
    }

    public Resident(String name, String phone, String address,String region, int SSN, String dateOfBirth, String username, String password) {
        super(name, SSN, dateOfBirth, username, password);
        this.address = address;
        this.region=region;
        this.phone = phone;
        this.requests=new ArrayList<>();
        this.complaints=new ArrayList<>();
        this.bills=new ArrayList<>();
        this.newBillIsAdded=false;
    }
    
    public Resident(ArrayList<Bill> bills, ArrayList<Request> requests, ArrayList<Complaint> complaints, String address, String phone, String name, int SSN, String dateOfBirth, String username, String password) {
        super(name, SSN, dateOfBirth, username, password);
        this.bills = bills;
        this.requests = requests;
        this.complaints = complaints;
        this.address = address;
        this.phone = phone;
        this.newBillIsAdded=false;
    }
    
    public void addComplaint(ComplaintInt c) throws RemoteException{
        this.complaints.add((Complaint) c);
    }
    
    public void addRequest(RequestInt r) throws RemoteException{
        this.requests.add((Request) r);
    }
    
    public void addBill(BillInt b) throws RemoteException{
        this.bills.add((Bill) b);
        this.setNewBillIsAdded(true);
    }

    @Override
    public boolean isNewBillIsAdded() {
        return newBillIsAdded;
    }

    @Override
    public void setNewBillIsAdded(boolean newBillIsAdded) {
        this.newBillIsAdded = newBillIsAdded;
    }
    
    /*@Override
    public void viewMap(){
        
    }
    @Override
    public void addNewResident(ResidentInt r){
        
    }
    @Override
    public void removeResident(String n){
        
    }*/
    public ArrayList<Bill> getBills() {
        return bills;
    }

    public void setBills(ArrayList<Bill> bills) {
        this.bills = bills;
    }

    public ArrayList<Request> getRequests() {
        return requests;
    }

    public void setRequests(ArrayList<Request> requests) {
        this.requests = requests;
    }

    public ArrayList<Complaint> getComplaints() {
        return complaints;
    }

    public void setComplaints(ArrayList<Complaint> complaints) {
        this.complaints = complaints;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Resident{" + "name=" + this.getName() + ", SSN=" + this.getSSN() + ", dateOfBirth=" + this.getDateOfBirth() + ", username=" + this.getUsername() + ", password=" + this.getPassword() + ", bills=" + bills + ", requests=" + requests + ", complaints=" + complaints + ", address=" + address + ", phone=" + phone + '}';
    }

    
    
}
