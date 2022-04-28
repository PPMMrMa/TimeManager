package tool;

import entities.Group;
import entities.User;

import java.util.ArrayList;

public class GroupDao {
    //创建一个群，传入名字即可
    public static  Group CreateGroup(String name){
        return  new Group();
    }
    //在群里添加一个用户，也可以用作用户加群，
    public  static  boolean JoinGroup(String userId,String groupId){
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
