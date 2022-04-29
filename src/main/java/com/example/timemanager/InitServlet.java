package com.example.timemanager;

import database.MySQLConnect;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
public class InitServlet extends HttpServlet {
    private String message;
   public  InitServlet(){
    System.out.println("初始化成功");
}
    public void init() { System.out.println("初始化成功");
    }

   @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
              try{
                  if(!MySQLConnect.Instance().isInit()){
                      String url="jdbc:mysql://localhost:3306/timemanager";
                      String name="root";
                      String password="mpc1314520";
                      MySQLConnect.Instance().InitMySQL(url,name,password);
                  }
                  response.getWriter().println("..jashdjahsdjkas");
              }catch (Exception e){
                  e.printStackTrace();
              }
    }
    public void destroy() {
    }
}