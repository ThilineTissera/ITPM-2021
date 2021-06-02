/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.


 */

package timetablemanagement.Service;

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
           // con = DriverManager.getConnection("jdbc:mysql://database-itpm.cw1dxpagmsps.ap-southeast-1.rds.amazonaws.com:3306/sachintest", "admin", "VFu7UBO794tPaZIUNl4X");
            
          // con = DriverManager.getConnection("jdbc:mysql://database-itpm.cw1dxpagmsps.ap-southeast-1.rds.amazonaws.com:3306/timetablemanagement", "admin", "VFu7UBO794tPaZIUNl4X");
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
