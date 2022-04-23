package tool;

import User.*;

public class EventManager {
    private EventManager _instance;
    public EventManager Instance(){
       if(_instance==null){
           _instance=new EventManager();
       }
        return _instance;
    }
    private EventManager(){

    }
    //给某个群添加事件
    public boolean AddEventForGroup(String groupId,Event event){
        return true;
    }
    //给一些群添加同一个事件
    public  boolean AddEventForGroups(String []groupIds,Event event){
        return true;
    }
    //给某个用户添加事件
    public  boolean AddEventForUser(String userId,Event event){
        return true;
    }
    //给一些用户添加同一个事件
    public  boolean AddEventForUsers(String []userIds,Event event){
        return true;
    }

    //删除所有用户或者群的该事件
    public boolean DeleteEventInAll(String eventId){
        return true;
    }
    //删除某用户的该事件
    public boolean DeleteEventInPeople(String eventId,String userId){
        return true;
    }
    //删除该群的某个事件
    public  boolean DeleteEventInGroup(String eventIds,String groupId)
    {
        return true;
    }

}
