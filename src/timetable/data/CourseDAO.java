/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable.data;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Hashtable;
import timetable.core.Adminuser;
import timetable.core.Instructor;
import timetable.core.Student;
import timetable.core.User;
import timetable.core.*;

/**
 *
 * @author DELL
 */
public class CourseDAO implements IDAO{
    @Override
    public boolean insertCourse(course temp) {
        
        String sql = null;
        sql = "insert into Course values ('" + temp.name + "','" + temp.strength + "','" + temp.courseCode + "','" + temp.credithours + "');";
        
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
    public ArrayList<course> getCourses() {
        ArrayList<course> tmp = new ArrayList<course>();
        
        try{

            String query;
            query = "SELECT * FROM Course";
            ResultSet rs = DBHelper.executeQuery(query);

            while(rs.next()){

                String name = rs.getString("name");
                int strength = rs.getInt("strength");
                String courseCode = rs.getString("coursecode");                
                String credithours = rs.getString("credit_hours");
                
                course temp = new course();
                temp.name = name;
                temp.strength = strength;
                temp.courseCode = courseCode;
                temp.credithours = credithours;
                tmp.add(temp);
            }

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
        return tmp;

    }

    @Override
    public String getUser(String type, String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAdminUser(String type, String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertuser(String type, User user) {
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
