/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable.data;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Hashtable;
import timetable.core.*;

/**
 *
 * @author DELL
 */
public interface IDAO {
    public boolean insertuser(String type, User user);
    public String getUser(String type, String name);
    public String getAdminUser(String type, String name);
    public boolean insertCourse(course temp);
    public ArrayList<course> getCourses();
    public void inserttimeslotdetail(TimeSlots temp);
    public TimeSlots getTimeslot();
}
