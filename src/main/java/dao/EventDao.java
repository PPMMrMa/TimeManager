package dao;

import database.MySQLConnect;
import entities.*;

import java.awt.image.RescaleOp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EventDao {

    //给某个群添加事件
    public static  boolean AddEventForGroup(String groupId,Event event){
        try{
            Connection connection= MySQLConnect.Instance().GetConnection();
            String sql="insert eventid,id into gelink values(?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,groupId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
        return true;
    }
    //给一些群添加同一个事件
    public  static  boolean AddEventForGroups(String []groupIds,Event event){

        return true;
    }
    //给某个用户添加事件
    public  static  boolean AddEventForUser(String userId,Event event){
        try{
            Connection connection= MySQLConnect.Instance().GetConnection();
            String sql="insert eventid,id into uelink values(?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,userId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
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
    //得到某个群组的事件
    public  static  ArrayList getEventInGroup(String groupid){
        ArrayList arrayList=new ArrayList();
        try{
           Connection connection=MySQLConnect.Instance().GetConnection();
           String sql="select eventid from gelink where group=?";
           PreparedStatement pre=connection.prepareStatement(sql);
           pre.setString(1,groupid);
          ResultSet res= pre.executeQuery();
          while (res.next()){
              arrayList.add(getEvent(res.getString(1)));
          }
        pre.close();
          connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
     return  arrayList;
    }
    //根据ID得到事件
    public static Event getEvent(String eid){
        Event event=new Event();
        try{
            Connection connection=MySQLConnect.Instance().GetConnection();
            String sql="select title,remark,type,starttime,endtime from event where id=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,eid);
            ResultSet res=preparedStatement.executeQuery();
            while (res.next()){
                event.setId(eid);
                event.setStartTime(res.getString("starttime"));
                event.setEndTime(res.getString("endtime"));
                event.setRemark(res.getString("remark"));
                event.setEventType(Event.StringToEventType(res.getString("type")));
                event.setTitle(res.getString("title"));
            }
            preparedStatement.close();
            connection.close();
        }catch (Exception e){
                 e.printStackTrace();
        }
        return event;
    }
}
