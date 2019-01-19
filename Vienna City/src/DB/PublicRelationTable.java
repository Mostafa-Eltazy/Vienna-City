/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import AccountHandler.PublicRelationHandler.PublicRelation;
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
 * @author Cherine Hussein
 */

public class PublicRelationTable {

    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    private Gson gson = new Gson();

    public PublicRelationTable() {
        // Disables Mongo Logs
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        // Initialize
        client = new MongoClient();
        database = client.getDatabase("ViennaCity"); // Database name
        collection = database.getCollection("PublicRelation"); // Collection name
    }

    public void insertPR(PublicRelation pr) {
        collection.insertOne(Document.parse(gson.toJson(pr)));
        System.out.println("PR inserted!");
    }

    public String deletePR(String username) {
        boolean result = collection.deleteOne(Filters.eq("username",username)).wasAcknowledged();
        String deletion=" ";
        if (result) {
            deletion="PR Deleted!";
        } else {
           deletion="PR wasn't found!";
        }
        return deletion; 
    }

    public PublicRelation getPRyUsername(String username) {
        Document doc = collection.find(Filters.eq("username", username)).first();
        PublicRelation result = gson.fromJson(doc.toJson(), PublicRelation.class);
        return result;
    }


    public ArrayList<PublicRelation> getAllPRs() {
        ArrayList<PublicRelation> result = new ArrayList();
        ArrayList<Document> docs = collection.find().into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), PublicRelation.class));
        }
        return result;
    }

    public void updatePR(PublicRelation pr) {
        Document doc = Document.parse(gson.toJson(pr));
        boolean result = collection.replaceOne(Filters.eq("username", pr.getUsername()), doc).wasAcknowledged();
        if (result) {
            System.out.println("PR Updated.");
        } else {
            System.out.println("PR wasn't found.");
        }
    }

    public void close() {
        client.close();
    }

}


