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
public class Section {
    public int sections;
    public course temp;
    
    public Section(){}
    
    public Section(course a){
        this.temp = a;
        if (a.strength > 40){
            int b = a.strength / 40;
            if ((a.strength % 40) == 0){
                sections = b;
            }
            else{
                sections = b + 1;
            }
        }
        else {
            sections =1;
        }
    }
    
    
    
    public void save(){
        String sql = null;
        sql = "insert into sections values ('" + this.sections + "','" + this.temp.name + "');";
        
        boolean flag =  true;
        try {
            DBHelper.execute(sql, new ArrayList(), new ArrayList());
        }
        catch(Exception ex) {
            flag = false;
            ex.printStackTrace();
        }
    }
    
    public ArrayList<Section> get(){
         ArrayList<Section> tmp = new ArrayList<Section>();
        
        try{

            String query;
            query = "SELECT * FROM sections";
            ResultSet rs = DBHelper.executeQuery(query);

            while(rs.next()){

                String RoomNo = rs.getString("course_name");
                int capacity = rs.getInt("no_of_sections");
                
                course a = new course();
                Section temp1 = new Section();
                temp1.sections = capacity;
                temp1.temp = a;
                tmp.add(temp1);
            }

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
        return tmp;
    }
}
