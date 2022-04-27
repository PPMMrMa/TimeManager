package tool;
import database.MySQLConnect;
import  entities.*;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDao {
    private  static  UserDao _instance;
    public static UserDao Instance(){
        if(_instance==null){
            _instance=new UserDao();
        }
        return _instance;
    }
    //验证登录
    public boolean CheckPassword(String userId,String password){
        return  true;
    }
    //得到用户信息
    public User GetUserInfo(String userId){
        return new User();
    }
    //注册用户
    public User RegisterUser(String name,String password,String phoneNumber){
        User user=new User();
        String uid=ID.Instance().GenerateUserID();
        String sql="INSERT INTO USER(name,passWord,phoneNumber,id) VALUES(?,?,?,?)";
        Connection connection=null;
        try{
            connection=MySQLConnect.Instance().GetConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,phoneNumber);
            preparedStatement.setString(4,uid);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (Exception e){
          e.printStackTrace();
        }
        user.setId(uid);
        user.setName(name);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        return  new User();
    }
    //得到用户所在的群的ID
    public ArrayList getGroups(String userId){
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
                System.out.println("一行"+"  "+str);
            }
            preparedStatement.close();
            connection.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return  group;
    }
    //得到用户创建的群
    public  ArrayList  getOwnGroup(String userId){
        return  new ArrayList();
    }
    //得到用户好友信息
    public ArrayList getFriendsInfo(String userId){
        return  new ArrayList();
    }
    //得到用户朋友ID
    public  ArrayList getFriendsId(String userId){
        return  new ArrayList();
    }
}
