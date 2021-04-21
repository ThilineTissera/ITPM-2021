/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablemanagement;

import javax.swing.JOptionPane;

/**
 *
 * @author Thiline Tissera
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        String name = "";
        try
       {
          // name = DataBase.getData("SELECT  FROM student WHERE sid = 26");
       }
       catch (Exception e)
               {
                   JOptionPane.showMessageDialog(null, "Failed" + e);
               }
    }                 
    
}
