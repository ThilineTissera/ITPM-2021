/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.


 */

package timetablemanagement;

import java.sql.*;

/**
 *
 * @author Thiline Tissera
 */ 
public class DataBase 
{
    public static Connection con; 
    
    public static Connection getConnection() throws Exception
    {
         if(con == null){
        Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/timetablemanagement", "root", "");
        }
        return con;
    }
    
    //save update dele
    
    public static void setData(String sql)throws Exception{  
       DataBase.getConnection().createStatement().executeUpdate(sql);
    }
    
    // search
    
    public static ResultSet getData(String sql)throws Exception{
        ResultSet executeQuery = DataBase.getConnection().createStatement().executeQuery(sql);
        return executeQuery;
    }
    
}
/*

import java.sql.*;
import javax.swing.JOptionPane;

public class DataBase {
    
    Connection conn;
    
    public static Connection ConnectDB(){
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/timetablemanagement","root","");
                return conn;
        
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
        return null;
    }
    
}
*/