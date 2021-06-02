package timetablemanagement.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Sachin Kumara Liyanage
 */
public class SqlQueries {
    private static SqlQueries sqlQueries=null;
    private SqlQueries() {
    }

    public static SqlQueries getSqlQueries() {
        if(sqlQueries==null){
            sqlQueries=new SqlQueries();
        }
        return sqlQueries;
    }

    public ResultSet getLecturerActiveTime(){
        try{
            String sql= "SELECT l.EmpID,l.Lecturer_name, l.Ranking, a.Monday, a.Tuesday, a.Wednesday, a.Thursday, a.Friday FROM lecturer AS l INNER JOIN activehours AS a ON l.EmpID = a.EmpID";
            PreparedStatement pr =DataBase.getConnection().prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            return rs;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    public ResultSet getRoomData(){
        try{
            String sql= "SELECT location.RoomName,location.RoomType,location.Capacity FROM location";
            PreparedStatement pr =DataBase.getConnection().prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            return rs;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    public ResultSet getUniOpenTime(){
        try{
            String sql= "SELECT * FROM `dayshours` LIMIT 1";
            PreparedStatement pr =DataBase.getConnection().prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            return rs;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    public ResultSet getAllSession(){
        try{
            String sql= "SELECT\n" +
                    "\tl2.SessionID, \n" +
                    "\tl2.l1name, \n" +
                    "\tl2.l2name, \n" +
                    "\tl2.tagname, \n" +
                    "\tl2.groupname, \n" +
                    "\tl2.subname, \n" +
                    "\tl2.NoS, \n" +
                    "\tl2.Duration, \n" +
                    "\tl2.l1Id, \n" +
                    "\tl3.EmpID AS l2Id, \n" +
                    "\tl2.l1Ranking, \n" +
                    "\tl3.Ranking AS l2Ranking\n" +
                    "FROM\n" +
                    "\t(\n" +
                    "\t\tSELECT\n" +
                    "\t\t\ts.SessionID, \n" +
                    "\t\t\ts.l1name, \n" +
                    "\t\t\ts.l2name, \n" +
                    "\t\t\ts.tagname, \n" +
                    "\t\t\ts.groupname, \n" +
                    "\t\t\ts.subname, \n" +
                    "\t\t\ts.NoS, \n" +
                    "\t\t\ts.Duration, \n" +
                    "\t\t\tl1.Lecturer_name, \n" +
                    "\t\t\tl1.EmpID AS l1Id, \n" +
                    "\t\t\tl1.Ranking AS l1Ranking\n" +
                    "\t\tFROM\n" +
                    "\t\t\t`session` AS s\n" +
                    "\t\t\tINNER JOIN\n" +
                    "\t\t\tlecturer AS l1\n" +
                    "\t\t\tON \n" +
                    "\t\t\t\ts.l1name = l1.Lecturer_name\n" +
                    "\t) AS l2\n" +
                    "\tLEFT JOIN\n" +
                    "\tlecturer AS l3\n" +
                    "\tON \n" +
                    "\t\tl2.l2name = l3.Lecturer_name\n" +
                    "\tORDER BY l3.Ranking DESC,l2.l1Ranking DESC";
            PreparedStatement pr =DataBase.getConnection().prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            return rs;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    public ResultSet getCheckSessionJoin(String type,int id){
        try{
            String sql= "select s_id as sid FROM join_session_type as jo1 where jo1.st_id in\n" +
                    "(SELECT\n" +
                    "\tjo.st_id\n" +
                    "FROM\n" +
                    "\tjoin_session_type AS jo\n" +
                    "\tINNER JOIN\n" +
                    "\tsession_type AS st\n" +
                    "\tON \n" +
                    "\t\tjo.st_id = st.id\n" +
                    "WHERE\n" +
                    "\tst.type = ? AND\n" +
                    "\tjo.s_id = ?)";
            PreparedStatement pr =DataBase.getConnection().prepareStatement(sql);
            pr.setString(1,type);
            pr.setInt(2,id);
            ResultSet rs = pr.executeQuery();
            return rs;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    public void truncateTimetable(){
        try{
            String sql= "TRUNCATE timetable";
            PreparedStatement pr =DataBase.getConnection().prepareStatement(sql);
            pr.executeUpdate();
            sql= "TRUNCATE notInTimetable";
            pr =DataBase.getConnection().prepareStatement(sql);
            pr.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void AddTimeTable(String day,String start,String end,String room,int sid){
        try{
            String sql= "INSERT INTO `timetable`(`day`, `startTime`, `endTime`, `roomName`, `sessionId`) VALUES (?, ?, ?, ?,?)";
            PreparedStatement pr =DataBase.getConnection().prepareStatement(sql);
            pr.setString(1,day);
            pr.setString(2,start);
            pr.setString(3,end);
            pr.setString(4,room);
            pr.setInt(5,sid);
            pr.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addNotInTable(int sid){
        try{
            String sql= "INSERT INTO `notInTimetable`(`sid`) VALUES (?)";
            PreparedStatement pr =DataBase.getConnection().prepareStatement(sql);
            pr.setInt(1,sid);
            pr.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
