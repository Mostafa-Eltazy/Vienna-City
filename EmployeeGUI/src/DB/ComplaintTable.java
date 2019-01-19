/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import ResidentDemandsHandler.Complaint;
import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
/**
 *
 * @author glori
 */
public class ComplaintTable {
    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    private Gson gson = new Gson();

    public ComplaintTable() {
        // Disables Mongo Logs
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        // Initialize
        client = new MongoClient();
        database = client.getDatabase("ViennaCity"); // Database name
        collection = database.getCollection("Complaint"); // Collection name
    }

    public void insertComplaint(Complaint c) {
        collection.insertOne(Document.parse(gson.toJson(c)));
        System.out.println("Complaint inserted.");
    }

    public void deleteComplaint(int id) {
        boolean result = collection.deleteOne(Filters.eq("ID", id)).wasAcknowledged();
        if (result) {
            System.out.println("Complaint Deleted.");
        } else {
            System.out.println("Complaint wasn't found.");
        }
    }
    
    public void deleteAllComplaintsBySpecificUser(String n) {
        boolean result = collection.deleteMany(Filters.all("residentName", n)).wasAcknowledged();
        if (result) {
            System.out.println("Complaints are Deleted.");
        } else {
            System.out.println("Complaints aren't found.");
        }
    }
    
    public Complaint getComplaintByID(int id) {
        Document doc = collection.find(Filters.eq("ID", id)).first();
        Complaint result = gson.fromJson(doc.toJson(), Complaint.class);
        return result;
    }

    public ArrayList<Complaint> getComplaintsByYear(String residentName) {
        ArrayList<Complaint> result = new ArrayList();
        ArrayList<Document> docs = collection.find(Filters.eq("residentName", residentName)).into(new ArrayList<>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), Complaint.class));
        }
        return result;
    }

    public ArrayList<Complaint> getAllComplaints() {
        ArrayList<Complaint> result = new ArrayList();
        ArrayList<Document> docs = collection.find().into(new ArrayList<>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), Complaint.class));
        }
        return result;
    }

    public void updateComplaint(Complaint c) {
        Document doc = Document.parse(gson.toJson(c));
        boolean result = collection.replaceOne(Filters.eq("complaintDescription", c.getComplaintDescription()), doc).wasAcknowledged();
        if (result) {
            System.out.println("Complaint Updated.");
        } else {
            System.out.println("Complaint wasn't found.");
        }
    }

    public void close() {
        client.close();
    }
}
