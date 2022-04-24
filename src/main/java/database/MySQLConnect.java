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
    private Statement statement;
    private Connection connection;

    private  String url;
    private  String userName;
    private String password;
    private boolean isInit=false;
    public void InitMySQL(String url, String userName, String password){
        this.url=url;
        this.userName=userName;
        this.password=password;
        this.isInit=true;
        System.out.println("创建成功");
    }
    private void ConnectDB() throws SQLException{
        try {
            //1.加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("找到成功");
            //2.获得数据库的连接
            connection = DriverManager.getConnection(url,userName,password);
            System.out.println("连接成功");
            statement=connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
    private void Destory()throws Exception{
        try{
            if(statement!=null){
                statement.close();
            }
            if(connection!=null){
                connection.close();
            }
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }

    }
    public boolean isInit() {
        return isInit;
    }


}
