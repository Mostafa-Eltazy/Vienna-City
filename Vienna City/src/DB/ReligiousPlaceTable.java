/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import ResidentDemandsHandler.Complaint;
import ServiceHandler.CateringPlace;
import ServiceHandler.ReligiousPlace;
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
 * @author Mostafa
 */
public class ReligiousPlaceTable {
    
    
    
    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    private Gson gson = new Gson();

    public ReligiousPlaceTable() {
        // Disables Mongo Logs
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        // Initialize
        client = new MongoClient();
        database = client.getDatabase("ViennaCity"); // Database name
        collection = database.getCollection("ReligiousPlace"); // Collection name
    }

    public void insertplace(ReligiousPlace c) {
        collection.insertOne(Document.parse(gson.toJson(c)));
        System.out.println(gson.toJson(c));
        System.out.println("ReligiousPlace inserted.");
    }
    

    public void deleteplace(int id) {
        boolean result = collection.deleteOne(Filters.eq("ID", id)).wasAcknowledged();
        if (result) {
            System.out.println("ReligiousPlace Deleted.");
        } else {
            System.out.println("ReligiousPlace wasn't found.");
        }
    }

    public ReligiousPlace getplaceByID(int id) {
        Document doc = collection.find(Filters.eq("ID", id)).first();
        ReligiousPlace result = gson.fromJson(doc.toJson(), ReligiousPlace.class);
        return result;
    }
    public ReligiousPlace getplaceByname(String n) {
        Document doc = collection.find(Filters.eq("Name", n)).first();
        ReligiousPlace result = gson.fromJson(doc.toJson(), ReligiousPlace.class);
        return result;
    }
    

    public ArrayList<ReligiousPlace> getComplaintsByYear(String residentName) {
        ArrayList<ReligiousPlace> result = new ArrayList();
        ArrayList<Document> docs = collection.find(Filters.eq("residentName", residentName)).into(new ArrayList<>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), ReligiousPlace.class));
        }
        return result;
    }

    public ArrayList<ReligiousPlace> getAllplace() {
        ArrayList<ReligiousPlace> result = new ArrayList();
        ArrayList<Document> docs = collection.find().into(new ArrayList<>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), ReligiousPlace.class));
        }
        System.out.println("All SocialPlaces have been retrived from data base");
        return result;
    }

    public void updateComplaint(Complaint c) {
        Document doc = Document.parse(gson.toJson(c));
        boolean result = collection.replaceOne(Filters.eq("complaintDescription", c.getComplaintDescription()), doc).wasAcknowledged();
        if (result) {
            System.out.println("ReligiousPlace Updated.");
        } else {
            System.out.println("ReligiousPlace wasn't found.");
        }
    }

    public void close() {
        client.close();
    }
    
    
    
}
