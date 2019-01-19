/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import ExternalRelations.Company;
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
 * @author usfng
 */
public class CompanyTable {

    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    private Gson gson = new Gson();

    public CompanyTable() {
        // Disables Mongo Logs
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        // Initialize
        client = new MongoClient();
        database = client.getDatabase("ViennaCity"); // Database name
        collection = database.getCollection("Company"); // Collection name
    }

    public void insertCompany(Company c) {
        collection.insertOne(Document.parse(gson.toJson(c)));
        System.out.println("Company inserted!");
    }

    public String deleteCompany(int ID) {
        boolean result = collection.deleteOne(Filters.eq("ID",ID)).wasAcknowledged();
        String Status="";
        if (result) {
            Status="Company Deleted!";
        } else {
          Status="Company wasn't found!"; 
        }
        return Status;
    }

    public Company getCompanyByID(int ID) {
        Document doc = collection.find(Filters.eq("ID", ID)).first();
        Company result = gson.fromJson(doc.toJson(), Company.class);
        return result;
    }


    public ArrayList<Company> getAllCompanies() {
        ArrayList<Company> result = new ArrayList();
        ArrayList<Document> docs = collection.find().into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), Company.class));
        }
        return result;
    }

    public void updateCompany(Company c) throws RemoteException {
        Document doc = Document.parse(gson.toJson(c));
        boolean result = collection.replaceOne(Filters.eq("ID", c.getID()), doc).wasAcknowledged();
        if (result) {
            System.out.println("Company Updated.");
        } else {
            System.out.println("Company wasn't found.");
        }
    }

    public void close() {
        client.close();
    }

}
