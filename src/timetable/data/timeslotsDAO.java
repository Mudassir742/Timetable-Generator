/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import timetable.core.*;

/**
 *
 * @author DELL
 */
public class timeslotsDAO implements IDAO{

    @Override
    public boolean insertuser(String type, User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public boolean insertCourse(course temp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<course> getCourses() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserttimeslotdetail(TimeSlots temp) {
        String sql = null;
        sql = "insert into timeslots values ('" + temp.no_of_working_days + "','" + temp.no_of_slots + "','" + temp.start_time + "','" + temp.end_time + "');";
        
        boolean flag =  true;
        try {
            DBHelper.execute(sql, new ArrayList(), new ArrayList());
        }
        catch(Exception ex) {
            flag = false;
            ex.printStackTrace();
        }
        
    }

    @Override
    public TimeSlots getTimeslot() {
        TimeSlots tmp = singleton.getSingleinstance();
        
        try{

            String query;
            query = "SELECT * FROM timeslots";
            ResultSet rs = DBHelper.executeQuery(query);
            rs.next();
            tmp.no_of_working_days = rs.getInt("no_0f_days");
            tmp.no_of_slots = rs.getInt("slots");
            tmp.start_time = rs.getString("start_time");                
            tmp.end_time = rs.getString("end_time");
                
            } catch (SQLException ex) {
            Logger.getLogger(timeslotsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
        return tmp;
    }
    
}
