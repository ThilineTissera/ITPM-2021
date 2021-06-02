package timetablemanagement.Model;

import static java.lang.Integer.*;

/**
 *
 * @author Sachin Kumara Liyanage
 */
public class Lecturer implements Days{
    private String id=null;
    private String lecturerName=null;
    private String [][]active=new String[5][2];
    private int start[]=new int[5];
    private int end[]=new int[5];
    private double rank = 0.0;

    public Lecturer(String id, String lecturerName, double rank) {
        this.id = id;
        this.lecturerName = lecturerName;
        this.rank = rank;
    }

    public void setActive(int day,String data) {
        if(day<5){
            if(data == null || "--".equalsIgnoreCase(data)){
                this.setActiveNull(day);
            }else{
                String []times=data.split("-");
                if(times.length!=2){
                    setActiveNull(day);
                }else{
                    this.active[day][0]=this.get24Time(times[0]);
                    this.active[day][1]=this.get24Time(times[1]);
                    if(this.active[day][0]!=null && this.active[day][1]!=null){
                        this.start[day] = parseInt(this.active[day][0].substring(0,2)+this.active[day][0].substring(3));
                        this.end[day] = parseInt(this.active[day][1].substring(0,2)+this.active[day][1].substring(3));
                    }
                }
            }
        }
    }



    private String get24Time(String time){

        for(int i=0;i<2;i++){
            for(String format:timeFormat[i]){
                int pos = time.indexOf(format);
                if(pos!=-1) {
                    time = time.replaceAll(format,"");
                    String []timebreck=time.split("\\.");
                    if(timebreck.length!=2){
                        return null;
                    }else{
                        int []timebreckInt = new int[2];
                        try{
                            timebreckInt[0]= parseInt(timebreck[0]);
                            timebreckInt[1]= parseInt(timebreck[1]);
                        }catch (Exception e){
                            e.printStackTrace();
                            return null;
                        }
                        if(timebreckInt[0]<=12 && timebreckInt[1]<60){
                            timebreckInt[0] = timebreckInt[0]+(12*i);
                            if(timebreckInt[0]<10){
                                return "0"+timebreckInt[0]+"."+timebreckInt[1];
                            }else{
                                return timebreckInt[0]+"."+timebreckInt[1];
                            }

                        }else{
                            return null;
                        }
                    }
                }
            }
        }
        return null;
    }

    private void setActiveNull(int day){
        this.active[day][0]=null;
        this.active[day][1]=null;
    }

    public String getId() {
        return id;
    }

    public String getLecturerName() {
        return lecturerName;
    }

    public String[][] getActiveAll() {
        return active;
    }

    public String[] getActive(String day) {
        for(int i=0;i<days.length;i++){
            if(days[i].equalsIgnoreCase(day)){
                return this.active[i];
            }
        }
        return null;
    }
    public String[] getActive(int day) {
        if(day<5){
            return this.active[day];
        }
        return null;
    }


    public double getRank() {
        return rank;
    }

    public int getStart(int id) {
        return start[id];
    }

    public int getEnd(int id) {
        return end[id];
    }
}
