package dao;
import database.MySQLConnect;
import  entities.*;
import tool.ID;
import tool.MD5Utils;

import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class UserDao {
    //验证登录
    public static boolean CheckPassword(String userId,String password){
        password= MD5Utils.stringToMD5(password);
        try{
            Connection connection=MySQLConnect.Instance().GetConnection();
            String sql="Select password from user where id=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,userId);
            ResultSet res=preparedStatement.executeQuery();
            if(res.getString("password").equals(password)){
                return true;
            }else{
                return  false;
            }
        }catch ( Exception e){
               e.printStackTrace();
        }
        return  false;
    }
    //得到用户信息
    public static  User getUserInfo(String userId){
        User user=new User();
        try{
            Connection connection=MySQLConnect.Instance().GetConnection();
            String sql="select name,phoneNumber,sex,address,remark,organization,head from user where id=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,userId);
            ResultSet res=preparedStatement.executeQuery();
            if(res.next()){
                user.setName(res.getString("name"));
                user.setPhoneNumber(res.getString("phoneNumber"));
                user.setAddress(res.getString("address"));
                user.setHead(res.getString("head"));
                user.setOrganization(res.getString("organization"));
                user.setRemark(res.getString("remark"));
                user.setSex(res.getString("sex").charAt(0));
            }

            preparedStatement.close();
            connection.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }
    //注册用户
    public static  User RegisterUser(String name,String password,String phoneNumber,char sex){
        User user=new User();
        String uid= ID.Instance().GenerateUserID();
        password=MD5Utils.stringToMD5(password);
        String sql="INSERT INTO USER(name,passWord,phoneNumber,id,sex) VALUES(?,?,?,?,?)";
        Connection connection=null;
        try{
            connection=MySQLConnect.Instance().GetConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,phoneNumber);
            preparedStatement.setString(4,uid);
            preparedStatement.setString(5,String.valueOf(sex));
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (Exception e){
          e.printStackTrace();
        }
        user.setId(uid);
        user.setName(name);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        user.setSex(sex);
        return  new User();
    }
    //得到用户所在的群的ID
    public static  ArrayList getGroups(String userId){
        ArrayList group=new ArrayList();
        try{
            Connection connection =MySQLConnect.Instance().GetConnection();
            String sql="SELECT groupid FROM gulink WHERE userid=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,userId);
            ResultSet res=preparedStatement.executeQuery();
            while (res.next()){
                String str=res.getString("groupid");
                group.add(str);

            }
            preparedStatement.close();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return  group;
    }
    //得到用户创建的群
    public  static  ArrayList  getOwnGroup(String userId){
        ArrayList group=new ArrayList();
        try{
            Connection connection =MySQLConnect.Instance().GetConnection();
            String sql="SELECT id FROM timegroup WHERE ownerId=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,userId);
            ResultSet res=preparedStatement.executeQuery();
            while (res.next()){
                String str=res.getString("id");
                group.add(str);
            }
            preparedStatement.close();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return  group;

    }
    //得到用户好友信息
    public  static ArrayList getFriendsInfo(String userId){
        ArrayList arrayList=new ArrayList();
        ArrayList friendList=new ArrayList();
        try{
            Connection connection=MySQLConnect.Instance().GetConnection();
            String sql="select id1,id2 from uulink where id1=?|id2=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,userId);
            preparedStatement.setString(2,userId);
            ResultSet res=preparedStatement.executeQuery();
            while (res.next()){
                String id1=res.getString("id1");
                String id2=res.getString("id2");
                if(id1.equals(userId)){
                    arrayList.add(id2);
                }else{
                    arrayList.add(id1);
                }
            }
           for(int i=0;i<arrayList.size();i++){
               friendList.add(getUserInfo(arrayList.get(i).toString()));
           }
            preparedStatement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  friendList;
    }
    //得到用户朋友ID
    public  static  ArrayList getFriendsId(String userId){
        ArrayList arrayList=new ArrayList();
        try{
            Connection connection=MySQLConnect.Instance().GetConnection();
            String sql="select id1,id2 from uulink where id1=?|id2=?";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,userId);
            preparedStatement.setString(2,userId);
            ResultSet res=preparedStatement.executeQuery();
            while (res.next()){
                String id1=res.getString("id1");
                String id2=res.getString("id2");
                if(id1.equals(userId)){
                    arrayList.add(id2);
                }else{
                    arrayList.add(id1);
                }
            }
            preparedStatement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  arrayList;
    }
    public static  boolean AddFriend(String id1,String id2){
        if(id1.length()!=11&&id2.length()!=11&&id1.equals(id2)){
            return false;
        }
        try{
            Connection connection=MySQLConnect.Instance().GetConnection();
            String sql="insert id1,id2 into uulink values(?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,id1);
            preparedStatement.setString(2,id2);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return  false;
    }
}
