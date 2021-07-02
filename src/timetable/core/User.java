/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable.core;

/**
 *
 * @author DELL
 */
public abstract class User {
    public String name;
    public String Password;
    
    User() {};
    
    User(String Name, String Password){
        this.name = Name;
        this.Password = Password;
    }
    
    public abstract void save();
    
    public abstract boolean autenticate(String Password, String name);
}
