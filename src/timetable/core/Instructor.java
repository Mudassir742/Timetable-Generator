/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable.core;

import timetable.data.DAOFactory;
import timetable.data.IDAO;

/**
 *
 * @author DELL
 */
public class Instructor extends User{

    public String InstructorId;
    
    public Instructor() {super();}
            
    Instructor(String Name, String Password, String temp){
        super(Name, Password);
        this.InstructorId = temp;
    }
    
    @Override
    public void save() {
        IDAO userdao = DAOFactory.getDao("User");
        if (userdao != null) {
            userdao.insertuser("Instructor", this);
        }
    }

    @Override
    public boolean autenticate(String password, String ID) {
        IDAO userdao = DAOFactory.getDao("User");
        if (userdao != null) {
            String temp = userdao.getAdminUser("Instructor", ID);
            if (password.equals(temp)) {
                return true;
            }
        }
        return false;
    }
    
}
