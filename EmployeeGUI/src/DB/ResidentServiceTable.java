/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;
import AccountHandler.ResidentServiceHandler.ResidentService;
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
public class ResidentServiceTable {
    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    private Gson gson = new Gson();

    public ResidentServiceTable() {
        // Disables Mongo Logs
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        // Initialize
        client = new MongoClient();
        database = client.getDatabase("ViennaCity"); // Database name
        collection = database.getCollection("ResidentService"); // Collection name
    }

    public void insertResidentService(ResidentService r) {
        collection.insertOne(Document.parse(gson.toJson(r)));
        System.out.println("Resident Service inserted.");
    }

    public void deleteResidentService(String username) {
        boolean result = collection.deleteOne(Filters.eq("username", username)).wasAcknowledged();
        if (result) {
            System.out.println("Resident Service Deleted.");
        } else {
            System.out.println("Resident Service wasn't found.");
        }
    }
    
    public void deleteAllResidentServicesBySpecificName(String n) {
        boolean result = collection.deleteMany(Filters.all("name", n)).wasAcknowledged();
        if (result) {
            System.out.println("Resident Services are Deleted.");
        } else {
            System.out.println("Resident Services aren't found.");
        }
    }
    
    
    public ResidentService getResidentServiceByUsername(String username) {
        Document doc = collection.find(Filters.eq("username", username)).first();
        ResidentService result = gson.fromJson(doc.toJson(), ResidentService.class);
        return result;
    }

    public ResidentService getResidentServiceByName(String name) {
        Document doc = collection.find(Filters.eq("name", name)).first();
        ResidentService result = gson.fromJson(doc.toJson(), ResidentService.class);
        return result;
    }

    public ArrayList<ResidentService> getResidentServicesByDateOfBirth(String dateOfBirth) {
        ArrayList<ResidentService> result = new ArrayList();
        ArrayList<Document> docs = collection.find(Filters.eq("dateOfBirth", dateOfBirth)).into(new ArrayList<>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), ResidentService.class));
        }
        return result;
    }

    public ArrayList<ResidentService> getAllResidentServices() {
        ArrayList<ResidentService> result = new ArrayList();
        ArrayList<Document> docs = collection.find().into(new ArrayList<>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), ResidentService.class));
        }
        return result;
    }

    public void updateResidentService(ResidentService r) {
        
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
    
    public void close() {
        client.close();
    }
}
