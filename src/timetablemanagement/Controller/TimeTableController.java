package timetablemanagement.Controller;

import timetablemanagement.Model.*;
import timetablemanagement.Service.SqlQueries;

import java.sql.ResultSet;
import java.util.*;

/**
 *
 * @author Sachin Kumara Liyanage
 */
public class TimeTableController implements Days {

    private Day[] day = new Day[5];

    public TimeTableController() {
        LecturerController.getLecturerList().loadLecturers();
        RoomController.loadRoomData();
        SessionController.loadAllSession();
        UniController.setOpenTime();
    }

    private String createtime(int t){
        String time = String.valueOf(t);
        if(time.length()==3){
            time="0"+time;
        }
        return time.substring(0,2)+"."+time.substring(2);
    }

    private List<Integer> iscon(int id){
        ResultSet rs = SqlQueries.getSqlQueries().getCheckSessionJoin("con",id);
        return ischeck(rs);
    }
    private List<Integer> ispara(int id){
        ResultSet rs = SqlQueries.getSqlQueries().getCheckSessionJoin("para",id);
        return ischeck(rs);
    }

    private List<Integer> ischeck(ResultSet rs){
        int ch=0;
        List <Integer> sessions = new ArrayList<>();
        try{
            while(rs.next()){
                sessions.add(rs.getInt("sid"));
                ch++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        if(ch!=0){
            return sessions;
        }
        return null;

    }

    public Day[] createTimeTable(){
        day = new Day[5];
        try {

            for (int i = 0; i < days.length; i++) {
                Day newDay = new Day();
                newDay.setName(days[i]);
                if (UniController.getOpentime(i)[0] == null || UniController.getOpentime(i)[1] == null) {
                    day[i]=newDay;
                    continue;
                }
                for(int sem=0;sem<SessionController.getAllSession().length;sem++){
                    int uniClosetime = Integer.parseInt(UniController.getOpentime(i)[1].toString().replaceAll("\\.", ""));
                    int uniopentime = Integer.parseInt(UniController.getOpentime(i)[0].toString().replaceAll("\\.", ""));
                    int curenttime = uniopentime;
                    int ch=0;
                    int tabalerow=0;
                    //Map.Entry<Integer, Session> session ((LinkedHashMap<Integer, Session>)SessionController.getAllSession()[sem]).entrySet().toArray(Map.Entry<Integer, Session> )
                    LinkedHashMap<Integer, Session> semSession = (LinkedHashMap)SessionController.getAllSession()[sem];
                    Integer[] key = semSession.keySet().toArray(new Integer[semSession.size()]);
                    for(int y=0;y< key.length;y++){
                        System.out.println(sem +":"+y);
                        Session session = ((LinkedHashMap<Integer, Session>)SessionController.getAllSession()[sem]).get(key[y]);
                        Hour hour =null;
                        String hour_key=null;
                        if(uniClosetime-curenttime-(100*timeTableBreakGap)<100){
                            break;
                        }
                        if(sem==0){
                            hour = new Hour();
                            hour.setStart(createtime(curenttime));
                            hour.setEnd(createtime(curenttime+(100*timeTableBreakGap)));
                            hour_key = hour.getStart()+"-"+hour.getEnd();
                        }else{
                            String []keyset=newDay.getHourMap().keySet().toArray(new String[newDay.getHourMap().size()]);
//                            System.out.println(test.toString());
                            if(keyset.length>tabalerow){
                                hour_key = keyset[tabalerow];
                                hour = newDay.getHourMap().get(hour_key);
                            }else{
                                hour = new Hour();
                                hour.setStart(createtime(curenttime));
                                hour.setEnd(createtime(curenttime+(100*timeTableBreakGap)));
                                hour_key = hour.getStart()+"-"+hour.getEnd();
                            }

                        }
                        //re lec
//                        int newdaysize=newDay.getNotfinishSession().size();

                        if(newDay.getNotfinishSession().size()>0){
                            for(int k=0; k<newDay.getNotfinishSession().size();k++){
                                System.out.println("sachin:"+k+" ::::"+newDay.getNotfinishSession().toString());
                                int nsem=SessionController.findsem(newDay.getNotfinishSession().get(k));
                                if(nsem==-1){
                                    newDay.RemoveNotfinishSession(newDay.getNotfinishSession().get(k));
                                    continue;
                                }
                                Session news = ((LinkedHashMap<Integer, Session>)SessionController.getAllSession()[nsem]).get(newDay.getNotfinishSession().get(k));
                                int duration = news.getDuration()+(100*timeTableBreakGap);
                                if(duration+curenttime>uniClosetime){

                                    newDay.RemoveNotfinishSession(k);
                                    continue;
                                }
                                if(news.getRoomid()==null){
                                    String room = hour.getroom(news.getTagname(), news.getNoS());
                                    if(room!=null){
                                        if(!(hour.getBusy().contains(news.getL1Id()) || hour.getBusy().contains(news.getL2Id()))){
                                            Lecturer lec1 = LecturerController.getLecturerList().findLecturers(news.getL1Id());
                                            Lecturer lec2 = LecturerController.getLecturerList().findLecturers(news.getL2Id());
                                            int ch3=0;
                                            if(lec1 !=null){
                                                if(lec1.getStart(i)>curenttime || lec1.getEnd(i)<duration+curenttime) {
                                                    ch3 = 1;
                                                }
                                            }

                                            if(lec2 !=null){
                                                if(lec2.getStart(i)>curenttime || lec2.getEnd(i)<duration+curenttime) {
                                                    ch3 = 1;
                                                }
                                            }
                                            if(ch3==0) {
                                                news.setRoomid(room);
                                            }else{

                                                newDay.RemoveNotfinishSession(k);
                                                continue;
                                            }
                                        }else{

                                            newDay.RemoveNotfinishSession(k);
                                            continue;
                                        }

                                    }else{

                                        newDay.RemoveNotfinishSession(k);
                                        continue;
                                    }
                                }
                                hour.addSession(news);
                                hour.removeRooom(news.getRoomid());
                                if(news.getL1Id()!=null && !"".equalsIgnoreCase(news.getL1Id())){
                                    hour.addBusy(news.getL1Id());
                                }
                                if(news.getL2Id()!=null && !"".equalsIgnoreCase(news.getL2Id())){
                                    hour.addBusy(news.getL2Id());
                                }
                                int due = SessionController.changeDuration(nsem,news.getSessionID());
                                if(due==0){
                                    newDay.RemoveNotfinishSession(news.getSessionID());
                                }
                            }
                            if(newDay.getHourMap().containsKey(hour_key)){

                                newDay.getHourMap().replace(hour_key,hour);
                            }else{

                                newDay.getHourMap().put(hour_key,hour);
                            }
                            y--;
                            tabalerow++;
                            curenttime = curenttime+(100*timeTableBreakGap);
                            continue;
                        }
                        //con
                        int testsize=newDay.getNextsesion().size();
                        if(newDay.getNextsesion().size()>0){
                            int ch1=0;
                            for (int sid: newDay.getNextsesion()) {
                                int fsem = SessionController.findsem(sid);
                                if(fsem==-1){
                                    newDay.removenextSessoin(sid);
//                                    y--;
                                    continue;
                                }
                                Session news = ((LinkedHashMap<Integer, Session>)SessionController.getAllSession()[fsem]).get(sid);
                                List <Integer> pars = this.ispara(sid);
                                if(pars !=null){
                                    for (int data:pars) {
                                        newDay.addNotfinishSession(data);
                                    }
                                    newDay.removenextSessoin(sid);
//                                    y--;
                                    continue;
                                }
                                if(session==null){
                                    break;
                                }
                                int duration = session.getDuration()+(100*timeTableBreakGap);
                                if(duration+curenttime<=uniClosetime){
                                    if(!(hour.getBusy().contains(news.getL1Id()) || hour.getBusy().contains(news.getL2Id()))){


                                            String room = hour.getroom(news.getTagname(), news.getNoS());
                                            if(room!=null){
                                                Lecturer lec1 = LecturerController.getLecturerList().findLecturers(news.getL1Id());
                                                Lecturer lec2 = LecturerController.getLecturerList().findLecturers(news.getL2Id());
                                                int ch3=0;
                                                if(lec1 !=null){
                                                    if(lec1.getStart(i)>curenttime || lec1.getEnd(i)<duration+curenttime) {
                                                        ch3 = 1;
                                                    }
                                                }

                                                if(lec2 !=null){
                                                    if(lec2.getStart(i)>curenttime || lec2.getEnd(i)<duration+curenttime) {
                                                        ch3 = 1;
                                                    }
                                                }
                                                if(ch3==0) {
                                                    if(lec1!=null){
                                                        hour.addBusy(lec1.getId());
                                                    }
                                                    if(lec2!=null){
                                                        hour.addBusy(lec2.getId());
                                                    }
                                                    news.setRoomid(room);
                                                    hour.addSession(news);
                                                    int due = SessionController.changeDuration(fsem,news.getSessionID());
                                                    if(due>0){
                                                        newDay.setNotfinishSession(news.getSessionID());
                                                    }
                                                    newDay.removenextSessoin(news.getSessionID());
                                                    tabalerow++;
                                                    curenttime = curenttime + (100 * timeTableBreakGap);
//                                                    y--;
                                                    ch1++;

                                                    if(newDay.getHourMap().containsKey(hour_key)){
                                                        newDay.getHourMap().replace(hour_key,hour);
                                                    }else{

                                                        newDay.getHourMap().put(hour_key,hour);
                                                    }
//                                                    break;
                                                }else{
                                                    newDay.removenextSessoin(news.getSessionID());
                                                    ch1++;
//                                                    y--;
                                                }

                                            }

                                    }

                                }

                            }
                            if(ch1!=0){
                                y--;
                                continue;
                            }
                        }

                        //new add
                        if(session==null){
                            break;
                        }
                        int duration = session.getDuration()+(100*timeTableBreakGap);
                        if(duration+curenttime>uniClosetime){
                            continue;
                        }else{




                            //check lec busy
                            if(hour.getBusy().contains(session.getL1Id()) || hour.getBusy().contains(session.getL2Id())){
                                continue;
                            }

                            //chec con
                            List <Integer> listse = this.iscon(session.getSessionID());
                            if(listse !=null){
                                for (int data:listse) {
                                    newDay.addnextSessoin(data);
                                }
//                                y--;//debag comment1
//                                List <Integer> test = newDay.getNextsesion();
                                continue;
                            }
                            //ceck para
                            listse = this.ispara(session.getSessionID());
                            if(listse !=null){
                                for (int data:listse) {
                                    newDay.addNotfinishSession(data);
                                }
//                                y--;
                                continue;
                            }

                            String room = hour.getroom(session.getTagname(), session.getNoS());
                            if(room!=null){
                                Lecturer lec1 = LecturerController.getLecturerList().findLecturers(session.getL1Id());
                                Lecturer lec2 = LecturerController.getLecturerList().findLecturers(session.getL2Id());
                                int ch3=0;
                                if(lec1 !=null){
                                    if(lec1.getStart(i)>curenttime || lec1.getEnd(i)<duration+curenttime) {
                                        ch3 = 1;
                                    }
                                }

                                if(lec2 !=null){
                                    if(lec2.getStart(i)>curenttime || lec2.getEnd(i)<duration+curenttime) {
                                        ch3 = 1;
                                    }
                                }
                                if(ch3==0) {
                                    if(lec1!=null){
                                        hour.addBusy(lec1.getId());
                                    }
                                    if(lec2!=null){
                                        hour.addBusy(lec2.getId());
                                    }
                                    session.setRoomid(room);
                                    hour.addSession(session);
                                    int due = SessionController.changeDuration(sem,session.getSessionID());
                                    if(due>0){
                                        newDay.setNotfinishSession(session.getSessionID());
                                    }
                                    tabalerow++;
                                    curenttime = curenttime + (100 * timeTableBreakGap);


                                    if(newDay.getHourMap().containsKey(hour_key)){

                                        newDay.getHourMap().replace(hour_key,hour);
                                    }else{
                                        newDay.getHourMap().put(hour_key,hour);
                                    }
                                }

                            }



                        }


//
//                        if(ch!=0 || uniClosetime-curenttime<100){
//                            break;
//                        }
                    }

                }

                day[i]=newDay;

            }
        }catch (Exception e){
            e.printStackTrace();
        }


        return day;
    }

    public void nunAddReport(){
        System.out.println("NOT Add");
        for(int i=0;i<SessionController.getSem().length;i++){
            LinkedHashMap<Integer, Session> semSession = (LinkedHashMap)SessionController.getAllSession()[i];

            System.out.println("\t"+SessionController.getSem()[i]+":");
            for(Map.Entry sesion: semSession.entrySet()){
                System.out.println("\t\t"+((Session)sesion.getValue()).toString());
            }
        }

    }

    public void printTimetabale(){
        for(Day dayi : day){
            System.out.println(dayi.getName());
            for(Map.Entry hour: dayi.getHourMap().entrySet()){
                if(((Hour)hour.getValue()).getSessionList().size()>0){
                    System.out.println("\t"+hour.getKey());
                    for(Session session: ((Hour)hour.getValue()).getSessionList()){
                        System.out.println("\t\t"+session.toString());
                    }
                }

            }
//            System.out.println(day.getHourMap().size());
        }
    }

    public void addTimetableToDatabase(){
        SqlQueries.getSqlQueries().truncateTimetable();
        for(Day dayi : day){
            for(Map.Entry hour: dayi.getHourMap().entrySet()){
                if(((Hour)hour.getValue()).getSessionList().size()>0){
                    Hour h = ((Hour)hour.getValue());
                    for(Session session: h.getSessionList()){
                        SqlQueries.getSqlQueries().AddTimeTable(dayi.getName(),h.getStart(),h.getEnd(),session.getRoomid(),session.getSessionID());
                    }
                }

            }
        }
        for(int i=0;i<SessionController.getSem().length;i++){
            LinkedHashMap<Integer, Session> semSession = (LinkedHashMap)SessionController.getAllSession()[i];
            for(Map.Entry sesion: semSession.entrySet()){
                SqlQueries.getSqlQueries().addNotInTable(((Session)sesion.getValue()).getSessionID());
            }
        }

    }


}
