package timetablemanagement.Model;

import java.util.*;

/**
 *
 * @author Sachin Kumara Liyanage
 */
public class Day {
    private Map <String,Hour> hourMap = new LinkedHashMap<>();
    private List <Integer> notfinishSession=new ArrayList<>();
    private List <Integer> nextsesion=new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private List <Integer> removenext=new ArrayList<>();
    private List <Integer> removefinish=new ArrayList<>();
    private String name=null;

    public Day() {
        hourMap = new LinkedHashMap<>();
        notfinishSession=new ArrayList<>();
        removenext=new ArrayList<>();
        removefinish=new ArrayList<>();
    }

    public Map<String, Hour> getHourMap() {
        return hourMap;
    }

    public void setHourMap(String key, Hour value) {
        this.hourMap.put(key,value);
    }

    public List<Integer> getNotfinishSession() {
        for(Integer i:removefinish){
            if(notfinishSession.indexOf(i)!=-1){
                notfinishSession.remove(i);
            }
        }
        removefinish=new ArrayList<>();
        return notfinishSession;
    }

    public void setNotfinishSession(int no) {
        this.notfinishSession.add(no);
    }

    public List<Integer> getNextsesion() {
        for(Integer i:removenext){
            if(nextsesion.indexOf(i)!=-1){
                nextsesion.remove(i);
            }
        }
        removenext=new ArrayList<>();
        return nextsesion;
    }


    public void addNotfinishSession(int no){
        this.notfinishSession.add(no);
    }

    public void addnextSessoin(int no){
        this.nextsesion.add(no);
    }
    public void removenextSessoin(int no){
        removenext.add(no);
    }


    public void RemoveNotfinishSession(int no) {
        removefinish.add(no);
    }

}
