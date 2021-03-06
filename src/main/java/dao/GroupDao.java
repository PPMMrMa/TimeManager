package dao;

import database.MySQLConnect;
import entities.Group;
import entities.User;
import tool.ID;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Period;
import java.util.ArrayList;

public class GroupDao {
    //创建一个群，传入名字和群主id即可
    public static  Group CreateGroup(String name,String ownerId){
        String groupId= ID.Instance().GenerateGroupID();
        String sql="insert id,name,ownerId into timegroup values(?,?,?)";
        String []values={groupId,name,ownerId};
        MySQLConnect.Instance().UpdateDatabase(sql,values);
        Group group=new Group();
        group.setId(groupId);
        group.setName(name);
        group.setOwnerId(ownerId);
        return group;
    }

    //在群里添加一个用户，也可以用作用户加群，
    public  static  boolean JoinGroup(String userId,String groupId){
        String sql="insert groupid,userid into gulink values(?,?)";
        String []values={groupId,userId};
       return MySQLConnect.Instance().UpdateDatabase(sql,values);

    }
    //将某人移出某群，也可用于退群
    public  static boolean RemoveFromGroup(String userId,String groupId){
        String sql="delte from gulink where groupid=?&userid=?";
        String []values={groupId,userId};
        return  MySQLConnect.Instance().UpdateDatabase(sql,values);

    }
    //解散群
    public static  boolean DissovleGroup(String groupId){
        String sql="delete from gulink where groupid=?";
        String sql1="delete from gelink where id=?";
        String sql2="delete from timegroup where id=?";
        String []values={groupId};
       MySQLConnect.Instance().UpdateDatabase(sql,values);
       MySQLConnect.Instance().UpdateDatabase(sql1,values);
       MySQLConnect.Instance().UpdateDatabase(sql2,values);
       return true;
    }
    //得到群成员ID
    public  static ArrayList getMembersID(String groupId){
       ArrayList uidListt=new ArrayList();
       try{
           Connection connection=MySQLConnect.Instance().GetConnection();
           String sql="select userid from gulink where groupid=?";
           PreparedStatement preparedStatement=connection.prepareStatement(sql);
           preparedStatement.setString(1,groupId);
         ResultSet res= preparedStatement.executeQuery();
         while (res.next()){
             uidListt.add(res.getString(1));
         }
        }catch(Exception e){
              e.printStackTrace();
        }
        return  uidListt;
    }
    //得到群成员信息
    public  static ArrayList  getMembersInfo(String groupId){
           ArrayList uidList=new ArrayList();
           ArrayList userInfoList=new ArrayList();
           for(int i=0;i<uidList.size();i++){
               String uid=uidList.get(i).toString();
               User user=null;
               try{
                   user=UserDao.getUserInfo(uid);
               }catch (Exception e){
                   e.printStackTrace();
               }
               if(user!=null){
                   userInfoList.add(user);
               }
           }
        return  userInfoList;
    }
    //得到群主ID
    public static  String getGroupOwnerId(String groupId){
        String oid="";
        try{
            Connection connection=MySQLConnect.Instance().GetConnection();
            String sql="select ownerId from timegroup where id=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,groupId);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                oid=resultSet.getString(1);
            }
        }catch (Exception e){
          e.printStackTrace();
        }
        return oid;
    }
    //得到群主信息
    public  static User getGroupOwner(String groupId){
        User owner=new User();
        try{
            String oid=getGroupOwnerId(groupId);
            owner=UserDao.getUserInfo(oid);
        }catch (Exception e){
             e.printStackTrace();
        }
        return owner;
    }

}
