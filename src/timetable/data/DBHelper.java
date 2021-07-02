/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DBHelper {
    
    public static ResultSet executeQuery(String sql) throws SQLException {
        Connection conn = getConnection();
        ResultSet rs = null;

        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException sqlEx) {
            throw sqlEx;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                //conn.close();
            } catch (Exception ex) {

            }
        }
        
        return rs;
    }

    public static ResultSet executeQuery(String sql, ArrayList<Object> params, ArrayList<String> paramTypes) throws SQLException {
        Connection conn = getConnection();
        ResultSet rs = null;

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            setParameters(stmt, params, paramTypes);
            rs = stmt.executeQuery();
        } catch (SQLException sqlEx) {
            throw sqlEx;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
//				conn.close();
            } catch (Exception ex) {

            }
        }

        return rs;
    }

    /*
	 * Method to execute DML statements
     */
    public static int execute(String sql, ArrayList<Object> params, ArrayList<String> paramTypes) throws Exception{
        Connection conn = getConnection();
        int recordsAffected = 0;

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            setParameters(stmt, params, paramTypes);
            recordsAffected = stmt.executeUpdate();
        } catch (SQLException sqlEx) {
            System.out.println(sqlEx.toString());
        } finally {
            try {
                conn.close();
            } catch (Exception ex) {

            }
        }

        return recordsAffected;
    }

    private static void setParameters(PreparedStatement stmt, ArrayList<Object> params, ArrayList<String> paramTypes)
            throws SQLException {
        for (int i = 0; i < params.size(); i++) {
            if (paramTypes.get(i).equals("String")) {
                stmt.setString(i + 1, (String) params.get(i));
            } else if (paramTypes.get(i).equals("Integer")) {
                stmt.setInt(i + 1, (Integer) params.get(i));
            } else if (paramTypes.get(i).equals("Double")) {
                stmt.setDouble(i + 1, (Double) params.get(i));
            } else if (paramTypes.get(i).equals("Boolean")) {
                stmt.setBoolean(i + 1, (Boolean) params.get(i));
            }
        }
    }

    /*
	 * Method to establish connection with the database
     */
    public static Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/timetable", "root", "mba123456");
        } catch (ClassNotFoundException cnfEx) {
            cnfEx.printStackTrace();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }

        return conn;
    }
}
