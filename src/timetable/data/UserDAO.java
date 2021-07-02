/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable.data;

import java.util.ArrayList;
import java.util.Hashtable;
import timetable.core.*;
import java.sql.ResultSet;

/**
 *
 * @author DELL
 */
public class UserDAO implements IDAO {

    @Override
    public boolean insertuser(String type, User user) {
        
        String sql = null;
        if (type == "Admin") {
            Adminuser temp = (Adminuser) user;
            sql = "insert into Admin values ('" + temp.name + "','" + temp.Password + "');";
        } else if (type == "Student") {
            Student temp = (Student) user;
            sql = "insert into Student values ('" + temp.name + "','" + temp.Password + "','" + temp.RegistrationNumber + "');";
        } else {
            Instructor temp = (Instructor) user;
            sql = "insert into Instructor values ('" + temp.name + "','" + temp.Password + "','" + temp.InstructorId + "');";
        }
        
        
        boolean flag =  true;
        try {
            DBHelper.execute(sql, new ArrayList(), new ArrayList());
        }
        catch(Exception ex) {
            flag = false;
            ex.printStackTrace();
        }
        
        return flag;
    }

    @Override
    public String getUser(String type, String ID) {
        String Password = null;
        try{
            String query;
            query = "SELECT * FROM " + type + " WHERE RegistrationNumber = '" + ID + "'";
            ResultSet rs = DBHelper.executeQuery(query);
            rs.next();
            Password = rs.getString("Password");   
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return Password;
    }

    @Override
    public String getAdminUser(String type, String name) {
        String Password = null;
        try{
            String query;
            query = "SELECT * FROM " + type + " Where name = '" + name + "'";
            ResultSet rs = DBHelper.executeQuery(query);
            rs.next();
            Password = rs.getString("Password");   
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return Password;
    }
    

    @Override
    public boolean insertCourse(course temp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<course> getCourses() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserttimeslotdetail(TimeSlots temp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TimeSlots getTimeslot() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
