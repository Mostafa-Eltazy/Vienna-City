/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import ResidentDemandsHandler.Request;
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
public class RequestTable {
    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    private Gson gson = new Gson();

    public RequestTable() {
        // Disables Mongo Logs
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        // Initialize
        client = new MongoClient();
        database = client.getDatabase("ViennaCity"); // Database name
        collection = database.getCollection("Request"); // Collection name
    }

    public void insertRequest(Request r) {
        collection.insertOne(Document.parse(gson.toJson(r)));
        System.out.println("Request inserted.");
    }

    public void deleteRequest(int id) {
        boolean result = collection.deleteOne(Filters.eq("ID", id)).wasAcknowledged();
        if (result) {
            System.out.println("Request Deleted.");
        } else {
            System.out.println("Request wasn't found.");
        }
    }
    
    public void deleteAllRequestsBySpecificUser(String n) {
        boolean result = collection.deleteMany(Filters.all("residentName", n)).wasAcknowledged();
        if (result) {
            System.out.println("Requests are Deleted.");
        } else {
            System.out.println("Requests aren't found.");
        }
    }
    public Request getRequestByID(int id) {
        Document doc = collection.find(Filters.eq("ID", id)).first();
        Request result = gson.fromJson(doc.toJson(), Request.class);
        return result;
    }

    public ArrayList<Request> getRequestsByYear(String residentName) {
        ArrayList<Request> result = new ArrayList();
        ArrayList<Document> docs = collection.find(Filters.eq("residentName", residentName)).into(new ArrayList<>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), Request.class));
        }
        return result;
    }

    public ArrayList<Request> getAllRequests() {
        ArrayList<Request> result = new ArrayList();
        ArrayList<Document> docs = collection.find().into(new ArrayList<>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), Request.class));
        }
        return result;
    }

    public void updateRequest(Request r) {
        Document doc = Document.parse(gson.toJson(r));
        boolean result = collection.replaceOne(Filters.eq("serviceNeededDate", r.getServiceNeededDate()), doc).wasAcknowledged();
        if (result) {
            System.out.println("Request Updated.");
        } else {
            System.out.println("Request wasn't found.");
        }
    }

    public void close() {
        client.close();
    }
}
