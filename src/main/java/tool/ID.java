package tool;

import database.MySQLConnect;

import java.sql.*;
import java.util.Random;

public class ID {
    public Random random;
    //UID 11位  GID 13位
    private static ID _instance;
    public static ID Instance(){
        if(_instance==null){
            _instance=new ID();
            _instance.random=new Random();
        }
        return  _instance;
    }
    public String GenerateEventID(){
        long id=System.currentTimeMillis();
        char []temp=new char[15];
        for(int i=12;i>=0;i--){
            temp[i]=(char)(id%10+'0');
             id/=10;
        }

        temp[13]=(char)('0'+ Math.abs(random.nextInt())%10);
        temp[14]=(char)('0'+Math.abs(random.nextInt())%10);
        return String.valueOf(temp);
    }
    public String GenerateUserID(){
        String uid=GenerateID(false);
        while (CheckExist(uid)){
            uid=GenerateID(false);
        }
        return uid;
    }
    public  String GenerateGroupID(){
        String groupId= GenerateID(true);
        while (CheckExist(groupId)){
            groupId=GenerateID(true);
        }
        return groupId;
    }
    private String GenerateID(boolean type){
        //true 群ID false 用户ID
        if (type){
            long curTime=System.currentTimeMillis();
            char [] uid=new char[13];
            for(int i=10;i>=0;i--){
                uid[i]=(char)(((curTime%10)+Math.abs(random.nextInt())%10)%10+'0');
                curTime/=10;
            }
            int index=(int)Math.abs(random.nextInt())%11;
            uid[11]=(char)(uid[index]);
            index=(int)Math.abs(random.nextInt())%12;
            uid[12]=uid[index];

            return  String.valueOf(uid);
        }else {
            long curTime=System.currentTimeMillis();
            char [] uid=new char[11];
            for(int i=10;i>=0;i--){
                int temp=(int)((curTime%10)+(int)Math.abs((random.nextInt()))%10)%10;

                uid[i]=(char)(temp+'0');
                System.out.println("temp:"+temp+"   uid"+i+":"+uid[i]);
                curTime/=10;
            }
            return  String.valueOf(uid);
        }
    }
    public   boolean CheckUserId(String uid){
        return  uid.length()==11;

    }
    public   boolean CheckGroupId(String groupId){
         return groupId.length()==13;
    }
    private boolean CheckExist(String id){
        String sql="";
        if (id.length() == 13) {
            sql="SELECT name FROM timegroup WHERE id=?";
        }else if(id.length()==11){
            sql="SELECT name FROM USER WHERE id=?";
        }else{
            return true;
        }
        try{
            Connection connection=MySQLConnect.Instance().GetConnection();
           PreparedStatement preparedStatement=connection.prepareStatement(sql);
           preparedStatement.setString(1,id);
            ResultSet res=preparedStatement.executeQuery();
            if(res.next()){
                preparedStatement.close();
                connection.close();
                return true;
            }else{
                preparedStatement.close();
                connection.close();
                return false;
            }
        }catch (Exception e){
                e.printStackTrace();
        }

        return true;
    }
}
