package timetablemanagement.Model;

import timetablemanagement.Controller.RoomController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Sachin Kumara Liyanage
 */
public class Hour {
    private List <Session> sessionList = new ArrayList<>();
    private String start = null;
    private String end = null;
    private Map<String,Integer> lecroom =null;
    private Map<String,Integer> lab =null;
    private List<String> busy = null;

    public Hour() {
        lecroom = new HashMap<>(RoomController.getLecroom());
        lab = new HashMap<>(RoomController.getLab());
        busy = new ArrayList<>();
    }

    public List<Session> getSessionList() {
        return sessionList;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Map<String, Integer> getLecroom() {
        return lecroom;
    }

    public Map<String, Integer> getLab() {
        return lab;
    }

    public List<String> getBusy() {
        return busy;
    }

    public void addSession(Session session){
        this.sessionList.add(session);
    }

    public void addBusy(String id){
        this.busy.add(id);
    }

    public void removeRooom(String key){
        if(this.lecroom.containsKey(key)){
            this.lecroom.remove(key);
        }
        if(this.lab.containsKey(key)){
            this.lab.remove(key);
        }
    }

    public String getroom(String type,int nos){
        if("Lecture".equalsIgnoreCase(type)||"Tute".equalsIgnoreCase(type)){
            for(Map.Entry e : this.lecroom.entrySet()){
                if((int)e.getValue()>=nos){
                    return (String)e.getKey();
                }
            }
        }else{
            for(Map.Entry e : this.lab.entrySet()){
                if((int)e.getValue()>=nos){
                    return (String)e.getKey();
                }
            }
        }
        return null;
    }
}
