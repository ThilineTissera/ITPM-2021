package timetablemanagement.Model;

/**
 *
 * @author Sachin Kumara Liyanage
 */
public class Session {
    private int sessionID,noS,duration;
    private String l1name,l1Id,l1Ranking,l2name,l2Id,l2Ranking,tagname,groupname,subname;
    private String roomid=null;

    public Session(int sessionID, int noS, int duration, String l1name, String l1Id, String l1Ranking, String l2name, String l2Id, String l2Ranking, String tagname, String groupname, String subname) {
        this.sessionID = sessionID;
        this.noS = noS;
        this.duration = duration;
        this.l1name = l1name;
        this.l1Id = l1Id;
        this.l1Ranking = l1Ranking;
        this.l2name = l2name;
        this.l2Id = l2Id;
        this.l2Ranking = l2Ranking;
        this.tagname = tagname;
        this.groupname = groupname;
        this.subname = subname;
    }

    public int getSessionID() {
        return sessionID;
    }

    public int getNoS() {
        return noS;
    }

    public int getDuration() {
        return duration;
    }

    public String getL1name() {
        return l1name;
    }

    public String getL1Id() {
        return l1Id;
    }

    public String getL1Ranking() {
        return l1Ranking;
    }

    public String getL2name() {
        return l2name;
    }

    public String getL2Id() {
        return l2Id;
    }

    public String getL2Ranking() {
        return l2Ranking;
    }

    public String getTagname() {
        return tagname;
    }

    public String getGroupname() {
        return groupname;
    }

    public String getSubname() {
        return subname;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    @Override
    public String toString() {
        return "Session{" +
                "sessionID=" + sessionID +
                ", groupname='" + groupname + '\'' +
                ", noS=" + noS +
                ", duration=" + duration +
                ", l1name='" + l1name + '\'' +
                ", l1Id='" + l1Id + '\'' +
                ", l1Ranking='" + l1Ranking + '\'' +
                ", l2name='" + l2name + '\'' +
                ", l2Id='" + l2Id + '\'' +
                ", l2Ranking='" + l2Ranking + '\'' +
                ", tagname='" + tagname + '\'' +

                ", subname='" + subname + '\'' +
                ", roomid='" + roomid + '\'' +
                '}';
    }
}
