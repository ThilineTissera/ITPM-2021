package timetablemanagement.Controller;

import timetablemanagement.Model.Days;
import timetablemanagement.Model.Session;
import timetablemanagement.Service.SqlQueries;

import java.sql.ResultSet;
import java.util.*;

/**
 *
 * @author Sachin Kumara Liyanage
 */
public class SessionController implements Days {
    private static Map allSession[] = new Map[8];
    private static String []sem ={"y1s1","y1s2","y2s1","y2s2","y3s1","y3s2","y4s1","y4s2"};



    public static void loadAllSession(){
        allSession= new Map[8];
        allSession[0]=new LinkedHashMap();
        allSession[1]=new LinkedHashMap();
        allSession[2]=new LinkedHashMap();
        allSession[3]=new LinkedHashMap();
        allSession[4]=new LinkedHashMap();
        allSession[5]=new LinkedHashMap();
        allSession[6]=new LinkedHashMap();
        allSession[7]=new LinkedHashMap();
        int count =0;
        int count2=0;
        ResultSet rs = SqlQueries.getSqlQueries().getAllSession();
        try{
            while (rs.next()){
                count++;
                Session temp = new Session(rs.getInt("SessionID"),
                        rs.getInt("NoS"),
                        rs.getInt("Duration"),
                        rs.getString("l1name"),
                        rs.getString("l1Id"),
                        rs.getString("l1Ranking"),
                        rs.getString("l2name"),
                        rs.getString("l2Id"),
                        rs.getString("l2Ranking"),
                        rs.getString("tagname"),
                        rs.getString("groupname"),
                        rs.getString("subname"));
                for(int i=0;i< sem.length;i++){
                    String test =rs.getString("groupname").toLowerCase();
                    int index = rs.getString("groupname").toLowerCase().indexOf(sem[i]);
                    boolean bol =rs.getString("groupname").toLowerCase().contains(sem[i]);
                    if(rs.getString("groupname")!=null && !"".equalsIgnoreCase(rs.getString("groupname")) && rs.getString("groupname").toLowerCase().contains(sem[i])){
                        count2++;
                        allSession[i].put(temp.getSessionID(),temp);
                    }
                }
            }
            System.out.println("count:"+count);
            System.out.println("count2:"+count2);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Map[] getAllSession() {
        return allSession;
    }



    private static void removeSession(int id){
        for (Map map : allSession) {
            if (map.containsKey(id)) {
                map.remove(id);
                break;
            }
        }

    }

    public static int changeDuration(int sem,int id){
        int newd = ((Session) allSession[sem].get(id)).getDuration()-timeTableBreakGap;
        if(newd<=0){
            removeSession(id);
        }else{
            ((Session)allSession[sem].get(id)).setDuration(newd);
        }
        return newd;
    }

    public static int findsem(int id){
        for(int i=0;i<8;i++){
            if(allSession[i].containsKey(id)){
                return i;
            }
        }
        return -1;
    }

    public static String[] getSem() {
        return sem;
    }
}
