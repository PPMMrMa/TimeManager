package database;

import User.Event;

import java.sql.*;

public class MySQLOP {

    private  static  MySQLOP _instance=null;
    public  static MySQLOP Instance(){

        if(_instance==null){
            _instance=new MySQLOP();
        }
        return  _instance;
    }
   private MySQLOP(){

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
    public boolean InsertEvent(Event event)throws Exception{
        if(!isInit())return false;
        try {
            ConnectDB();
            String sql="INSERT INTO event(id,title,remark,type) VALUES(?,?,?,?)";
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setString(1,event.getId());
            ps.setString(2,event.getTitle());
            ps.setString(3,event.getRemark());
            ps.setString(4,event.EventTypeToString());
            ps.executeUpdate();
            Destory();
        }catch (Exception e){
            throw e;
        }
        return true;
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
