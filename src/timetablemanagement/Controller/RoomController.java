package timetablemanagement.Controller;

import timetablemanagement.Service.SqlQueries;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Sachin Kumara Liyanage
 */
public class RoomController {
    private static Map<String,Integer> lecroom = new HashMap<>();
    private static Map<String,Integer> lab = new HashMap<>();

    public static void loadRoomData(){
        lecroom = new HashMap<>();
        lab = new HashMap<>();
        ResultSet rs = SqlQueries.getSqlQueries().getRoomData();
        try {
            while (rs.next()){
                if("Lecture".equalsIgnoreCase(rs.getString("RoomType"))){
                    lecroom.put(rs.getString("RoomName"),rs.getInt("Capacity"));
                }
                else if("Lab".equalsIgnoreCase(rs.getString("RoomType"))){
                    lab.put(rs.getString("RoomName"),rs.getInt("Capacity"));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Map<String, Integer> getLecroom() {
        return lecroom;
    }

    public static Map<String, Integer> getLab() {
        return lab;
    }
}
