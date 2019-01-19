/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

import AccountHandler.ResidentHandler.ResidentInt;
import BillPayment.Bill;
import BillPayment.BillManager;
import BillPayment.Cash;
import DB.BillDB;
import DB.CompanyTable;
import ExternalRelations.Company;
import ExternalRelations.ExternalRelationsManager;
import ResidentDemandsHandler.Complaint;
import ResidentDemandsHandler.Request;
import ServiceHandler.PlaceFactory;
import ServiceHandler.Schedule;
import ServiceHandler.ServiceManger;
import ServiceHandler.SocialPlace;
import java.rmi.RemoteException;
import java.util.ArrayList;
import net.aksingh.owmjapis.api.APIException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

/**
 *
 * @author glori
 */
public class TestClass {
    
    @Test
    public void testresidentLogin() throws RemoteException{
        System.out.println("Login");
        String name="Gloria";
        String result=AccountHandler.AccountsManager.getAccountManager().residentLogin("Gloriat", "lola1996").getName();
        assertEquals(name, result);
    }
     @Test
    public void testviewWeather()throws RemoteException, APIException{
        System.out.println("View Weather");
        String weather="City: \nCairo\nTemperature: \n17.0/17.0\'C";
        String result=ResidentDemandsHandler.ResidentDemandsManager.getResidentDemandsManager().viewWeather("Cairo");
        assertEquals(weather, result);
    }
    
    @Test
    public void testaddNewComplaint()throws RemoteException{
        System.out.println("Add New Complaint");
        Complaint complaint=new Complaint( "Gloria",  "01270979169",  "556 portsaid","Environment","It is really noisy",1);
        ResidentDemandsHandler.ResidentDemandsManager.getResidentDemandsManager().addNewComplaint("Gloria",  "01270979169",  "556 portsaid",  "Environment","It is really noisy");
        assertEquals(complaint.getResidentName(),ResidentDemandsHandler.ResidentDemandsManager.getResidentDemandsManager().viewComplaintByID(1).getResidentName());
    }
    
    @Test
    public void testaddNewRequest()throws RemoteException{
        System.out.println("Add New Request");
        Request request=new Request("Gloria",  "01270979169",  "556 portsaid","Item 1", "2 August",1);
        ResidentDemandsHandler.ResidentDemandsManager.getResidentDemandsManager().addNewRequest("Gloria", "01270979169",  "556 portsaid","Item 1", "2 August");
        assertEquals(request.getServiceType(),ResidentDemandsHandler.ResidentDemandsManager.getResidentDemandsManager().viewRequestByID(1).getServiceType());
    }
    
    @Test
    public void TestRemoveCompanyContract() throws RemoteException
    {
        System.out.println("Remove Company");
        CompanyTable companyDB=new CompanyTable();
        ExternalRelationsManager externalRelationManager=new ExternalRelationsManager();
        externalRelationManager.removeContract(19019); 
        assertNull(companyDB.getCompanyByID(19019).getContract());
    }
    
    @Test
    public void TestAddCompany() throws RemoteException
    {
        System.out.println("Add Company");
        CompanyTable companyDB=new CompanyTable();
        ExternalRelationsManager externalRelationManager=new ExternalRelationsManager();
        externalRelationManager.addNewCompany("Beanos",19956,"Madinty","Coffee",null,"beanosinfocom");
        Company companyObj= new Company("Beanos",19956,"Madinty","Coffee",null,"beanosinfocom");
        assertEquals(companyObj.getName(),companyDB.getCompanyByID(19956).getName()); 
    }
    
    @Test
    public void testCreateAplaceFactory()throws RemoteException
    {
        System.out.println("Add New Place");
        ArrayList<String> schavailableDays=new ArrayList<>();
        schavailableDays.add("Sunday");
        schavailableDays.add("Monday");
        schavailableDays.add("Wednesday");
        Schedule s = new Schedule(2,22,schavailableDays);
        SocialPlace sp=new SocialPlace("Starbucks","Makram",s);
        ServiceManger.getInstance().CreateAplaceFactory("s", "Starbucks","Makram", 2, 2, schavailableDays);
        assertEquals(sp.getName(),ServiceManger.getInstance().viewsocial(1));
        
    }
    
    @Test
    public void TestAddBill()throws RemoteException
    {
        BillDB billDB=new BillDB();
        BillManager.getInstance().addBill(5678,"Gloria", "Electricity","Electricity Bill for one month",350);
        Bill bill=new Bill(5678,"Gloria", "Electricity","Electricity Bill for one month",350,new Cash()); 
        assertEquals(bill.getDescription(),billDB.getBillByID(5678).getDescription()); 

    }
    
    @Test
    public void TestViewBill()throws RemoteException
    {
        BillDB billDB=new BillDB();
        BillManager.getInstance().addBill(5678,"Cherine", "Gas","Gas Bill for one month",100);
        Bill bill=(Bill)billDB.getBillByType("Gas"); 
        assertEquals("Cherine",bill.getResidentName());
       
    }
}
