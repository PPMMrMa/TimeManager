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
        String sql="insert eventid,id into gelink values(?,?)";
        String [] values={event.getId(),groupId};
        return MySQLConnect.Instance().UpdateDatabase(sql,values);

    }
    //给某个用户添加事件
    public  static  boolean AddEventForUser(String userId,Event event){
        String sql="insert eventid,id into uelink values(?,?)";
        String []values={event.getId(),userId};
       return MySQLConnect.Instance().UpdateDatabase(sql,values);

    }
    //删除某用户的该事件
    public  static boolean DeleteEventInPeople(String eventId,String userId){
        String sql="delete from uelink where eventid=?&id=?";
        String []values={eventId,userId};
        MySQLConnect.Instance().UpdateDatabase(sql,values);
        return true;
    }
    //删除该群的某个事件
    public  static  boolean DeleteEventInGroup(String eventId,String groupId)
    {
        String sql="delete from gelink where eventid=?&id=?";
        String []values={eventId,groupId};
        MySQLConnect.Instance().UpdateDatabase(sql,values);
        return true;
    }
    //得到某个群组的事件
    public  static  ArrayList getEventInGroup(String groupid){
        ArrayList arrayList=new ArrayList();
        String sql="select eventid from gelink where group=?";
        try{
           Connection connection=MySQLConnect.Instance().GetConnection();
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
            if (res.next()){
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
