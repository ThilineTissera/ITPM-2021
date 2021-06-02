package timetablemanagement.Controller;


import timetablemanagement.Model.Days;
import timetablemanagement.Model.Lecturer;
import timetablemanagement.Service.SqlQueries;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Sachin Kumara Liyanage
 */

public class LecturerController implements Days {
    private static Map<String, Lecturer> lecturers = new HashMap<>();
    private static LecturerController lecturerController = null;

    private LecturerController() {

    }

    public static LecturerController getLecturerList() {
        if(lecturerController ==null){
            lecturerController =new LecturerController();
        }
        return lecturerController;
    }

    public void loadLecturers(){
        lecturers = new HashMap<>();
        ResultSet rs = SqlQueries.getSqlQueries().getLecturerActiveTime();
        try{
            while (rs.next()){
                Lecturer temp = new Lecturer(rs.getString("EmpID"),rs.getString("Lecturer_name"),rs.getDouble("Ranking"));
                for(int i=0;i< days.length;i++){
                    temp.setActive(i,rs.getString(days[i]));
                }
                LecturerController.lecturers.put(temp.getId(),temp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public Map<String,Lecturer> getLecturers() {
        return lecturers;
    }

    public int getIndexOfLecturers(String name){
        int k=0;
        for(Map.Entry leEntry: lecturers.entrySet()){
            if(leEntry.getKey().toString().equalsIgnoreCase(name)){
                return k;
            }
            k++;
        }
        return 0;
    }

    public Lecturer findLecturers(String name){
        if(lecturers.containsKey(name)){
            return lecturers.get(name);
        }
        return null;
    }
}
