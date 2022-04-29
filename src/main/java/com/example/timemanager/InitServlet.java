package com.example.timemanager;

import database.MySQLConnect;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
public class InitServlet extends HttpServlet {
    private String message;
   public  InitServlet(){
       try{
           if(!MySQLConnect.Instance().isInit()){
               String url="jdbc:mysql://localhost:3306/timemanager";
               String name="root";
               String password="mpc1314520";
               MySQLConnect.Instance().InitMySQL(url,name,password);
               System.out.println("数据库初始化成功");
           }
       }catch (Exception e){
           e.printStackTrace();
       }
}
    public void init() {
    }

   @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
       response.sendRedirect("./pages/Group.jsp");
    }
    public void destroy() {
    }
}