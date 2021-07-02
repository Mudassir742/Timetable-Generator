/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable.core;

import java.sql.ResultSet;
import java.util.ArrayList;
import timetable.data.DBHelper;

/**
 *
 * @author DELL
 */
public class Room {
    public String RoomNo;
    public int capacity;
    
    public Room(){}
    
    public Room(String temp, int a) {
        this.RoomNo = temp;
        this.capacity = a;
    }
    
    public void save(){
        String sql = null;
        sql = "insert into rooms values ('" + this.RoomNo + "','" + this.capacity + "');";
        
        boolean flag =  true;
        try {
            DBHelper.execute(sql, new ArrayList(), new ArrayList());
        }
        catch(Exception ex) {
            flag = false;
            ex.printStackTrace();
        }
    }
    
    public static ArrayList<Room> get(){
         ArrayList<Room> tmp = new ArrayList<Room>();
        
        try{

            String query;
            query = "SELECT * FROM rooms";
            ResultSet rs = DBHelper.executeQuery(query);

            while(rs.next()){

                String RoomNo = rs.getString("RoomNo");
                int capacity = rs.getInt("capactity");
                
                Room temp = new Room();
                temp.RoomNo = RoomNo;
                temp.capacity = capacity;
                tmp.add(temp);
            }

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
        return tmp;
    }
}
