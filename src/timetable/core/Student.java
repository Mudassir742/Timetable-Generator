/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable.core;
import timetable.data.*;
/**
 *
 * @author DELL
 */
public class Student extends User {
    public String RegistrationNumber;
    
    public Student(){
        super();
    };
    
    Student(String Name, String Password, String temp) {
        super(Name, Password);
        this.RegistrationNumber = temp;
    }

    @Override
    public void save() {
        IDAO userdao = DAOFactory.getDao("User");
        if (userdao != null) {
            userdao.insertuser("Student", this);
        }
    }

    @Override
    public boolean autenticate(String password, String ID) {
        IDAO userdao = DAOFactory.getDao("User");
        if (userdao != null) {
            String temp = userdao.getUser("Student", ID);
            if (password.equals(temp)) {
                return true;
            }
        }
        return false;
    }
}
