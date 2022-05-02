package entities;

public class Event {

    String id;
    String title;
    String remark;
    EventType eventType;
    String startTime;
    String endTime;
    boolean isFinished;
    public  Event(String id,String title,String remark,int type,String startTime,String endTime){
        this.id=id;
        this.title=title;
        this.remark=remark;
        if(type==0){
            eventType=EventType.PERSON;
        }else{
            eventType=EventType.GROUP;
        }
        isFinished=false;
        this.startTime=startTime;
        this.endTime=endTime;
    }
    public Event(){

    }
    public  Event(String id,String title,String remark,EventType eventType){
        this.id=id;
        this.title=title;
        this.remark=remark;
        this.eventType=eventType;
        isFinished=false;
    }
    public  static  String EventTypeToString(EventType e){
        if(e==EventType.GROUP){
            return "群组事件";
        }else{
            return "个人事件";
        }
    }
    public static EventType StringToEventType(String type){
        if(type.equals("个人事件")){
            return EventType.PERSON;
        }else{
            return EventType.GROUP;
        }
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }
    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    public enum EventType{
        PERSON,
        GROUP
    }
}
