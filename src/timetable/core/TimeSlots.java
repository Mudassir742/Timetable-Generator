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
public class TimeSlots {
    public int no_of_working_days;
    public int no_of_slots;
    public String start_time;
    public String end_time;
            
    TimeSlots() {}
    
    TimeSlots(int a, int b, String c, String d) {
        no_of_working_days = a;
        no_of_slots = b;
        start_time = c;
        end_time = d;
    } 
    
    public void set(int a, int b, String c, String d) {
        no_of_working_days = a;
        no_of_slots = b;
        start_time = c;
        end_time = d;
    }
    
    public void save() {
        IDAO dao = DAOFactory.getDao("timeslots");
        if (dao != null) {
            dao.inserttimeslotdetail(this);
        }
    }
    
    public TimeSlots get() {
        IDAO dao = DAOFactory.getDao("timeslots");
        if (dao != null) {
            return dao.getTimeslot();
        }
        return null;
    }
}
