/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import BillPayment.Bill;
import BillPayment.BillInt;
import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

/**
 *
 * @author mohamed
 */
public class BillDB {
    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    private Gson gson = new Gson();

    public BillDB() throws RemoteException {
        // Disables Mongo Logs
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        // Initialize
        client = new MongoClient();
        database = client.getDatabase("ViennaCity"); // Database name
        collection = database.getCollection("dbBill"); // Collection name
    }

    public void insertBill(Bill c) throws RemoteException {
        collection.insertOne(Document.parse(gson.toJson(c)));
        System.out.println("Bill inserted.");
    }

    public void deleteBill(int id) throws RemoteException {
        boolean result = collection.deleteOne(Filters.eq("ID", id)).wasAcknowledged();
        if (result) {
            System.out.println("Bill Deleted.");
        } else {
            System.out.println("Bill wasn't found.");
        }
    }

    public BillInt getBillByID(int id) throws RemoteException {
        Document doc = collection.find(Filters.eq("ID", id)).first();
        BillInt result = gson.fromJson(doc.toJson(), Bill.class);
        return result;
    }
    
    
    public BillInt getBillByType(String type) throws RemoteException {
        Document doc = collection.find(Filters.eq("type", type)).first();
        BillInt result = gson.fromJson(doc.toJson(), Bill.class);
        return result;
    }
    
    public BillInt getBillByAmount(double amount) throws RemoteException {
        Document doc = collection.find(Filters.eq("amount", amount)).first();
        BillInt result = gson.fromJson(doc.toJson(), Bill.class);
        return result;
    }
    
    public BillInt getBillByResidentName(String residentName) throws RemoteException {
        Document doc = collection.find(Filters.eq("residentName", residentName)).first();
        BillInt result = gson.fromJson(doc.toJson(), Bill.class);
        return result;
    }
    
    
    public ArrayList<Bill> getAllBillsbyResidentName(String residentName) throws RemoteException {
        ArrayList<Bill> result = new ArrayList();
        Document docs = collection.find(Filters.eq("residentName", residentName)).first();
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.toJson(), Bill.class));
        }
        return result;
    }
   

    public ArrayList<Bill> getAllBills() throws RemoteException {
        ArrayList<Bill> result = new ArrayList();
        ArrayList<Document> docs = collection.find().into(new ArrayList<>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), Bill.class));
        }
        return result;
    }

    public void updateBill(Bill c) throws RemoteException {
        Document doc = Document.parse(gson.toJson(c));
        boolean result = collection.replaceOne(Filters.eq("Description", c.getDescription()), doc).wasAcknowledged();
        if (result) {
            System.out.println("Bill Updated.");
        } else {
            System.out.println("Bill wasn't found.");
        }
    }

    public void close() {
        client.close();
    }
}
