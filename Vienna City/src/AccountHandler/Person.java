/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountHandler;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author glori
 */
abstract public class Person{
    protected String name;
    protected int SSN;
    protected String dateOfBirth;
    protected String username;
    protected String password;
    
    
    public Person() {
    }

    public Person(String name, int SSN, String dateOfBirth, String username, String password) {
        this.name = name;
        this.SSN = SSN;
        this.dateOfBirth = dateOfBirth;
        this.username = username;
        this.password = password;
    }

    //functions

    public void login(String u,String p){
        
    }
    
    public void logout(){
        
    }
    
    public void editProfile(Person p){
        
    }
    
    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", SSN=" + SSN + ", dateOfBirth=" + dateOfBirth + ", username=" + username + ", password=" + password + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSSN() {
        return SSN;
    }

    public void setSSN(int SSN) {
        this.SSN = SSN;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}