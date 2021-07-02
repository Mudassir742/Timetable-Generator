/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable;
import java.sql.SQLException;
import timetable.ui.*;
import timetable.core.*;

/**
 *
 * @author DELL
 */
public class Timetable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        //course a = new course();
        MainScreen a = new MainScreen();
        a.setVisible(true);
        //generate a = new generate();
        //a.setVisible(true);
        //roomsui a = new roomsui();
        //a.setVisible(true);
        //Instructorui a = new Instructorui();
        //a.setVisible(true);
    }
    
}
