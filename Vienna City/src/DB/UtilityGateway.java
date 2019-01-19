package DB;

/**
 *
 * @author Moataz
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import UtilityHandler.UtilityInt;
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
 * @author usfng
 */
public class UtilityGateway {

    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    private Gson gson = new Gson();

    public static UtilityGateway instance;
    public static Integer UtilityID = 0;
    private ArrayList<UtilityInt> utilityRecords;

    private UtilityGateway() {
        // Disables Mongo Logs
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        // Initialize
        client = new MongoClient();
        database = client.getDatabase("BUE"); // Database name
        collection = database.getCollection("srs"); // Collection name
    }

    public static UtilityGateway getInstance() {
        if (instance == null) {
            return instance = new UtilityGateway();
        } else {
            return instance;
        }
    }

    public String insertUtility(UtilityInt utility) {
        collection.insertOne(Document.parse(gson.toJson(utility)));
        System.out.println("Utility inserted.");
        generateUtilitytID();

        return "Utility has been added";

    }

    public void deleteUtility(String utility) {
        boolean result = collection.deleteOne(Filters.eq("email", utility)).wasAcknowledged();
        if (result) {
            System.out.println("Utility Deleted.");
        } else {
            System.out.println("Utility wasn't found.");
        }
    }

    public UtilityInt getUtilityByID(int utilityID) {
        Document doc = collection.find(Filters.eq("utilityID", utilityID)).first();
        UtilityInt result = gson.fromJson(doc.toJson(), UtilityInt.class);
        return result;
    }

    public UtilityInt viewUtilityByType(String utilityType) {
        Document doc = collection.find(Filters.eq("utilityType", utilityType)).first();
        UtilityInt result = gson.fromJson(doc.toJson(), UtilityInt.class);
        return result;
    }

    public static Integer generateUtilitytID() {
        return UtilityID = UtilityID + 1;
    }

    public ArrayList<UtilityInt> getUtilitiesForResident(String residentNameIn) {
        ArrayList<UtilityInt> result = new ArrayList();
        ArrayList<Document> docs = collection.find(Filters.eq("residentName", residentNameIn)).into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), UtilityInt.class));
        }
        return result;
    }

    public void close() {
        client.close();
    }

}
