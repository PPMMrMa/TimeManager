package dao;

import database.MySQLConnect;
import entities.Group;
import entities.User;
import tool.ID;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.Period;
import java.util.ArrayList;

public class GroupDao {
    //创建一个群，传入名字和群主id即可
    public static  Group CreateGroup(String name,String ownerId){
        String groupId= ID.Instance().GenerateGroupID();
       try{
           Connection connection= MySQLConnect.Instance().GetConnection();
           String sql="insert id,name,ownerId into timegroup values(?,?,?)";
           PreparedStatement preparedStatement=connection.prepareStatement(sql);
           preparedStatement.setString(1,groupId);
           preparedStatement.setString(2,name);
           preparedStatement.setString(3,ownerId);
           preparedStatement.executeUpdate();
           preparedStatement.close();
           connection.close();
       }catch (Exception e){
           e.printStackTrace();
       }
        Group group=new Group();
       group.setId(groupId);
       group.setName(name);
       group.setOwnerId(ownerId);
        return group;
    }

    //在群里添加一个用户，也可以用作用户加群，
    public  static  boolean JoinGroup(String userId,String groupId){
        try{
            Connection connection= MySQLConnect.Instance().GetConnection();
            String sql="insert groupid,userid into gulink values(?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,groupId);
            preparedStatement.setString(2,userId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }
    //将某人移出某群，也可用于退群
    public  static boolean RemoveFromGroup(String userId,String groupId){
        return true;
    }
    //解散群
    public static  boolean DissovleGroup(String groupId){
        return true;
    }
    //得到群成员ID
    public  static ArrayList getMembersID(String groupId){
       ArrayList userList=new ArrayList();
       try{

        }catch(Exception e){

        }
        return  new ArrayList();
    }
    //得到群成员信息
    public  static ArrayList  getMembersInfo(String groupId){

        return  new ArrayList();
    }
    //得到群主ID
    public  static User getGroupOwner(String groupId){
        return new User();
    }

}
