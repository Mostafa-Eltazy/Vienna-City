/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import ResidentDemandsHandler.Complaint;
import ServiceHandler.CateringPlace;
import ServiceHandler.PlaceInt;
import ServiceHandler.SocialPlace;
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
public class CateringPlaceTable {
    
    
    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    private Gson gson = new Gson();

    public CateringPlaceTable() {
        // Disables Mongo Logs
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        // Initialize
        client = new MongoClient();
        database = client.getDatabase("ViennaCity"); // Database name
        collection = database.getCollection("CateringPlace"); // Collection name
    }

    public void insertplace(CateringPlace c) {
        collection.insertOne(Document.parse(gson.toJson(c)));
        System.out.println(gson.toJson(c));
        System.out.println("Catering Place inserted.");
    }
    

    public void deleteplace(int id) {
        boolean result = collection.deleteOne(Filters.eq("ID", id)).wasAcknowledged();
        if (result) {
            System.out.println("CateringPlace Deleted.");
        } else {
            System.out.println("CateringPlace wasn't found.");
        }
    }

    public CateringPlace getplaceByID(int id) {
        Document doc = collection.find(Filters.eq("ID", id)).first();
        CateringPlace result = gson.fromJson(doc.toJson(), CateringPlace.class);
        return result;
    }
    public CateringPlace getplaceByname(String n) {
        Document doc = collection.find(Filters.eq("Name", n)).first();
        CateringPlace result = gson.fromJson(doc.toJson(), CateringPlace.class);
        return result;
    }
    

    public ArrayList<CateringPlace> getComplaintsByYear(String residentName) {
        ArrayList<CateringPlace> result = new ArrayList();
        ArrayList<Document> docs = collection.find(Filters.eq("residentName", residentName)).into(new ArrayList<>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), CateringPlace.class));
        }
        return result;
    }

    public ArrayList<CateringPlace> getAllplace() {
        ArrayList<CateringPlace> result = new ArrayList();
        ArrayList<Document> docs = collection.find().into(new ArrayList<>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), CateringPlace.class));
        }
        System.out.println("All CateringPlace have been retrived from data base");
        return result;
    }

    public void updateComplaint(Complaint c) {
        Document doc = Document.parse(gson.toJson(c));
        boolean result = collection.replaceOne(Filters.eq("complaintDescription", c.getComplaintDescription()), doc).wasAcknowledged();
        if (result) {
            System.out.println("CateringPlace Updated.");
        } else {
            System.out.println("CateringPlace wasn't found.");
        }
    }

    public void close() {
        client.close();
    }
    
}
