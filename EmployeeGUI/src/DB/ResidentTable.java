/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import AccountHandler.ResidentHandler.Resident;
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
public class ResidentTable {
    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    private Gson gson = new Gson();

    public ResidentTable() {
        // Disables Mongo Logs
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        // Initialize
        client = new MongoClient();
        database = client.getDatabase("ViennaCity"); // Database name
        collection = database.getCollection("Resident"); // Collection name
    }

    public void insertResident(Resident r) {
        collection.insertOne(Document.parse(gson.toJson(r)));
        System.out.println("Resident inserted.");
    }

    public void deleteResident(String username) {
        boolean result = collection.deleteOne(Filters.eq("username", username)).wasAcknowledged();
        if (result) {
            System.out.println("Resident Deleted.");
        } else {
            System.out.println("Resident wasn't found.");
        }
    }
    
    public void deleteAllResidentsBySpecificName(String n) {
        boolean result = collection.deleteMany(Filters.all("name", n)).wasAcknowledged();
        if (result) {
            System.out.println("Residents are Deleted.");
        } else {
            System.out.println("Residents aren't found.");
        }
    }
    
    
    public Resident getResidentByUsername(String username) {
        Document doc = collection.find(Filters.eq("username", username)).first();
        Resident result = gson.fromJson(doc.toJson(), Resident.class);
        return result;
    }

    public Resident getResidentByName(String name) {
        Document doc = collection.find(Filters.eq("name", name)).first();
        Resident result = gson.fromJson(doc.toJson(), Resident.class);
        return result;
    }

    public ArrayList<Resident> getResidentsByDateOfBirth(String dateOfBirth) {
        ArrayList<Resident> result = new ArrayList();
        ArrayList<Document> docs = collection.find(Filters.eq("dateOfBirth", dateOfBirth)).into(new ArrayList<>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), Resident.class));
        }
        return result;
    }

    public ArrayList<Resident> getAllResidents() {
        ArrayList<Resident> result = new ArrayList();
        ArrayList<Document> docs = collection.find().into(new ArrayList<>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), Resident.class));
        }
        return result;
    }

    public void updateResident(Resident r) {
        
        Document doc = Document.parse(gson.toJson(r));
        System.out.println(r.getPassword());
        boolean result = collection.replaceOne(Filters.eq("password", r.getPassword()), doc).wasAcknowledged();
        //Document doc1 = collection.find(Filters.eq("username", r.getUsername())).first();
        //Resident result2 = gson.fromJson(doc1.toJson(), Resident.class);
        if (result) {
            System.out.println("Password Updated.");
            //return result2;
        } else {
            System.out.println("Password wasn't found.");
            //return result2;
        }
    }
    
    public void updateNewBillIsAdded(Resident r) {
        Document doc = Document.parse(gson.toJson(r));
        boolean result = collection.replaceOne(Filters.eq("newBillIsAdded", r.isNewBillIsAdded()), doc).wasAcknowledged();
        if (result) {
            System.out.println("Resident Updated.");
        } else {
            System.out.println("Resident wasn't found.");
        }
    }
    
    public void close() {
        client.close();
    }
}
