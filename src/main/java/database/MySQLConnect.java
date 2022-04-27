package database;

import java.sql.*;

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
        //这段代码用于开发初期调试用
        if(!isInit){
            this.url="jdbc:mysql://localhost:3306/timemanager";;
            this.userName="root";
            this.password="mpc1314520";
            this.isInit=true;
            System.out.println("创建成功");
        }
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

    public boolean isInit()
    {
        return isInit;
    }


}
