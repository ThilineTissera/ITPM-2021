package timetablemanagement.Controller;

import timetablemanagement.Model.Days;
import timetablemanagement.Service.SqlQueries;

import java.sql.ResultSet;
/**
 *
 * @author Sachin Kumara Liyanage
 */
public class UniController implements Days {
    private static String opentime[][]= new String[5][2];



    public static void setOpenTime(){
        opentime= new String[5][2];
        ResultSet rs = SqlQueries.getSqlQueries().getUniOpenTime();
        try{
            if(rs.next()){
                for(int i=0;i<days.length;i++){
                    String time= rs.getString(days[i]);
                    String[] times =time.split("-");
                    if(times.length==2){

                        for(int y=0;y<2;y++){
                            String[] oneTime =times[y].split(":");
                            if(oneTime.length==2){
                                int[] timesInt = new int[2];
                                try{
                                    timesInt[0]=Integer.parseInt(oneTime[0]);
                                    timesInt[1]=Integer.parseInt(oneTime[1]);
                                    opentime[i][y]=timesInt[0]+"."+timesInt[1];
                                }catch (Exception e){
                                    e.printStackTrace();
                                    opentime[i][0]=null;
                                    opentime[i][1]=null;
                                }
                            }else{
                                opentime[i][0]=null;
                                opentime[i][1]=null;
                            }

                        }
                    }else{
                        opentime[i][0]=null;
                        opentime[i][1]=null;
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String[][] getOpentimeAll() {
        return opentime;
    }

    public static String[] getOpentime(String day) {
        for(int i=0;i<days.length;i++){
            if(days[i].equalsIgnoreCase(day)){
                return opentime[i];
            }
        }
        return null;
    }

    public static String[] getOpentime(int day) {
        if(day<5){
            return opentime[day];
        }
        return null;
    }
}
