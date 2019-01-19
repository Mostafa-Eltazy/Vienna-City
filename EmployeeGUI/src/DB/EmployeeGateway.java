/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import AccountHandler.EmplyeeHandler.Employee;
import UtilityHandler.UtilityInt;
import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.rmi.RemoteException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

/**
 * /**
 *
 * @author Moataz
 */
public class EmployeeGateway {

    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    private Gson gson = new Gson();

    public static EmployeeGateway instance;
    private ArrayList<EmployeeGateway> employeeRecords;

    private EmployeeGateway() {
        // Disables Mongo Logs
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        // Initialize
        client = new MongoClient();
        database = client.getDatabase("ViennaCity"); // Database name
        collection = database.getCollection("Employee"); // Collection name
    }

    public static EmployeeGateway getInstance() {
        if (instance == null) {
            return instance = new EmployeeGateway();
        } else {
            return instance;
        }
    }

    public void insertEmployee(Employee employee) {
        collection.insertOne(Document.parse(gson.toJson(employee)));
        System.out.println("Student inserted.");
    }

    public Employee getEmployeeByID(int employeeID) {
        Document doc = collection.find(Filters.eq("SSN", employeeID)).first();
        Employee result = gson.fromJson(doc.toJson(), Employee.class);
        return result;
    }

    public ArrayList<Employee> getEmployeesByJobTitle(String jobTitleIn) {
        ArrayList<Employee> result = new ArrayList();
        ArrayList<Document> docs = collection.find(Filters.eq("jobTitle", jobTitleIn)).into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), Employee.class));
        }
        return result;
    }

    public Employee getAvailableEmployee(String jobTitleIn, String dayIn) {
        ArrayList<Employee> filteresEmployees = getEmployeesByJobTitle(jobTitleIn);
        for (Employee employee : filteresEmployees) {
            String day = employee.isWorking(dayIn);
            if (day.equals(dayIn))
                return employee;
        }
        System.out.println("not found");
        return null;
    }

    public ArrayList<Employee> getAvailableEmployees(String dayIn) {
        ArrayList<Employee> result = new ArrayList();
        ArrayList<Document> docs = collection.find(Filters.eq("jobTitle", dayIn)).into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            result.add(gson.fromJson(docs.get(i).toJson(), Employee.class));
        }
        return result;
    }

    public void updateCheckInTime(int ssn) {
        Employee employee = getEmployeeByID(ssn);
        Time currentTime = getCurrentTime();
        employee.setCheckInTime(currentTime);
        employee.setAvailability(true);
        updateEmployee(employee);
        System.out.println("time has been checked:" + currentTime);
    }

    public void updateCheckOutTime(int ssn) {
        Employee employee = getEmployeeByID(ssn);
        Time currentTime = getCurrentTime();
        employee.setCheckOutTime(currentTime);
        employee.setAvailability(false);
        updateEmployee(employee);
        System.out.println("time has been checked:" + currentTime);
    }

    private void updateEmployee(Employee employee) {
        Document doc = Document.parse(gson.toJson(employee));
        boolean result = collection.replaceOne(Filters.eq("checkInTime", employee.getCheckInTime()), doc).wasAcknowledged();
        if (result) {
            System.out.println("Employee Updated.");
        } else {
            System.out.println("employee wasn't found found.");
        }
    }

    private Time getCurrentTime() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String currentTime = (sdf.format(cal.getTime()));
        System.out.println(sdf.format(cal.getTime()));
        return Time.valueOf(currentTime);
    }

    public void close() {
        client.close();
    }

}
