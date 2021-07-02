/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable.core;

import java.sql.ResultSet;
import timetable.data.DAOFactory;
import timetable.data.DBHelper;
import timetable.data.IDAO;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class course {
    
    public String name;
    public int strength;
    public String courseCode;
    public String credithours; 
    
    public course() {
    }
       
    public course(String name, int strength, String courseCode, String credit_hours) {
        this.name = name;
        this.strength = strength;
        this.courseCode = courseCode;
        this.credithours = credit_hours;
    }

    
    public void save() {
        IDAO coursedao = DAOFactory.getDao("course");
        if (coursedao != null) {
            coursedao.insertCourse(this);
        }
    }
    
    public ArrayList<course> get() {
        IDAO userdao = DAOFactory.getDao("Course");
        return userdao.getCourses();
    }
    
    public course getc(String name) throws SQLException {
        course temp = new course();
        try{

            String query;
            Connection conn = DBHelper.getConnection();
            PreparedStatement statement = conn.prepareStatement("select * from Course where name = ?");    
            statement.setString(1, name);    
            ResultSet rs = statement.executeQuery();
            rs.next();
            String name1 = rs.getString("name");
                int strength = rs.getInt("strength");
                String courseCode = rs.getString("coursecode");                
                String credithours = rs.getString("credit_hours");
               
                temp.name = name;
                temp.strength = strength;
                temp.courseCode = courseCode;
                temp.credithours = credithours;

        } catch(Exception ex){
            ex.printStackTrace();
        }
        
        return temp;

    }
}
