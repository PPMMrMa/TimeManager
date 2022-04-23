package database;

import java.sql.*;

public class MySQLOP {
    private  static MySQLOP _instance;
    public static MySQLOP Instance(){

        return  _instance;
    }
    private Statement statement;
    private Connection connection;
    private  String url;
    private  String userName;
    private String password;
    public MySQLOP(String url,String userName,String password){
        this.url=url;
        this.userName=userName;
        this.password=password;
        ConnectDB();
    }
    private void ConnectDB(){
        try {
            //1.加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            //2.获得数据库的连接
            connection = DriverManager.getConnection(url,userName,password);
            statement=connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void Destory(){
        try{
            if(statement!=null){
                statement.close();
            }
            if(connection!=null){
                connection.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
