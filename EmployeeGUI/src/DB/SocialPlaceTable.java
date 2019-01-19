/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;
import ResidentDemandsHandler.Complaint;
import ServiceHandler.BusStopPlace;
import ServiceHandler.PlaceInt;
import ServiceHandler.SocialPlace;
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
 * @author Mostafa
 */
public class SocialPlaceTable {
    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    private Gson gson = new Gson();

    public SocialPlaceTable() {
        // Disables Mongo Logs
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        // Initialize
        client = new MongoClient();
        database = client.getDatabase("ViennaCity"); // Database name
        collection = database.getCollection("SocialPlace"); // Collection name
    }

    public void insertplace(SocialPlace c) {
        collection.insertOne(Document.parse(gson.toJson(c)));
        System.out.println(gson.toJson(c));
        System.out.println("Social Place inserted.");
    }
    

    public void deleteplace(int id) {
        boolean result = collection.deleteOne(Filters.eq("ID", id)).wasAcknowledged();
        if (result) {
            System.out.println("SocialPlace Deleted.");
        } else {
            System.out.println("SocialPlace wasn't found.");
        }
    }

    public Complaint getplaceByID(int id) {
        Document doc = collection.find(Filters.eq("ID", id)).first();
        Complaint result = gson.fromJson(doc.toJson(), Complaint.class);
        return result;
    }
    public PlaceInt getplaceByname(String n) {
        Document doc = collection.find(Filters.eq("Name", n)).first();
        SocialPlace result = gson.fromJson(doc.toJson(), SocialPlace.class);
        return result;
    }
    

    public ArrayList<SocialPlace> getComplaintsByYear(String residentName) {
        ArrayList<SocialPlace> result = new ArrayList();
        ArrayList<Document> docs = collection.find(Filters.eq("residentName", residentName)).into(new ArrayList<>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), SocialPlace.class));
        }
        return result;
    }

    public ArrayList<SocialPlace> getAllplace() {
        ArrayList<SocialPlace> result = new ArrayList();
        ArrayList<Document> docs = collection.find().into(new ArrayList<>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), SocialPlace.class));
            System.out.println("kam mara ");
        }
        System.out.println("All SocialPlaces have been retrived from data base");
        return result;
    }
    public SocialPlace getAplacebyindex(int s) throws RemoteException {
        SocialPlace result = new SocialPlace();
        ArrayList<Document> docs = collection.find().into(new ArrayList<>());
        
        result=(gson.fromJson(docs.get(s).toJson(), SocialPlace.class));
        System.out.println("kam mara ");

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
