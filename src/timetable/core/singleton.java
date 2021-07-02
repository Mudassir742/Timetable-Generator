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
public class singleton {
    
    static TimeSlots obj;
    
    singleton(){
    }
    
    public static TimeSlots getSingleinstance() {
        if (obj == null) {
            obj = new TimeSlots();
            return obj;
        }
        return obj;
    }
    
}
