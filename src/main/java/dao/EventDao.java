package dao;

import entities.*;

public class EventDao {
    //给某个群添加事件
    public static  boolean AddEventForGroup(String groupId,Event event){
        return true;
    }
    //给一些群添加同一个事件
    public  static  boolean AddEventForGroups(String []groupIds,Event event){
        return true;
    }
    //给某个用户添加事件
    public  static  boolean AddEventForUser(String userId,Event event){
        return true;
    }
    //给一些用户添加同一个事件
    public  static  boolean AddEventForUsers(String []userIds,Event event){
        return true;
    }
    //删除所有用户或者群的该事件
    public static  boolean DeleteEventInAll(String eventId){
        return true;
    }
    //删除某用户的该事件
    public  static boolean DeleteEventInPeople(String eventId,String userId){
        return true;
    }
    //删除该群的某个事件
    public  static  boolean DeleteEventInGroup(String eventIds,String groupId)
    {
        return true;
    }

}
