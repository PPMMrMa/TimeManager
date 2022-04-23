package User;

public class Event {

    String id;
    String title;
    String remark;
    EventType eventType;

    boolean isFinished;
    public  Event(String id,String title,String remark,int type){
        this.id=id;
        this.title=title;
        this.remark=remark;
        if(type==0){
            eventType=EventType.PERSON;
        }else{
            eventType=EventType.GROUP;
        }
        isFinished=false;
    }
    public  Event(String id,String title,String remark,EventType eventType){
        this.id=id;
        this.title=title;
        this.remark=remark;
        this.eventType=eventType;
        isFinished=false;
    }
    public  String EventTypeToString(){
        if(eventType==EventType.GROUP){
            return "群组事件";
        }else{
            return "个人事件";
        }
    }
    public Event(){

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
    public enum EventType{
        PERSON,
        GROUP
    }
}
