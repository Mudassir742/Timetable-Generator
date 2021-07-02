/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable.data;

/**
 *
 * @author DELL
 */
public class DAOFactory {

    public static IDAO getDao(String type){

            if(type.toLowerCase().equals("user")){
                return new timetable.data.UserDAO();
            }

            if(type.toLowerCase().equals("course")){
                return new timetable.data.CourseDAO();
            }
                
            if(type.toLowerCase().equals("timeslots")){
                return new timetable.data.timeslotsDAO();
            }
            
            return null;

    }
}
