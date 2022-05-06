package database;

import java.sql.*;
import java.util.ArrayList;

public class MySQLConnect {

    private  static MySQLConnect _instance=null;
    public  static MySQLConnect Instance(){

        if(_instance==null){
            _instance=new MySQLConnect();
        }
        return  _instance;
    }
   private MySQLConnect(){

   }
    private  String url;
    private  String userName;
    private String password;
    private boolean isInit=false;
    public void InitMySQL(String url, String userName, String password){
        this.url=url;
        this.userName=userName;
        this.password=password;
        this.isInit=true;

    }
    public  Connection GetConnection() throws SQLException{

        Connection connection=null;
        try {
            //1.加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            //2.获得数据库的连接
            connection = DriverManager.getConnection(url,userName,password);

        } catch (ClassNotFoundException e) {
        }catch (SQLException e) {
            throw e;
        }
        return connection;
    }
    public boolean UpdateDatabase(String sql,String []values){
        try{
            Connection connection=GetConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            for(int i=1;i<=values.length;i++){
                preparedStatement.setString(i,values[i-1]);
            }
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }


    public boolean isInit()
    {
        return isInit;
    }


}
