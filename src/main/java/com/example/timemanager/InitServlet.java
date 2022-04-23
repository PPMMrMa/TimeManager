package com.example.timemanager;

import User.Event;
import database.MySQLOP;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "InitServert",value = "/pages")
public class InitServlet extends HttpServlet {
    private String message;

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println("进入");
        System.out.println("成功");
              if(!MySQLOP.Instance().isInit()){
                  String url="jdbc:mysql://localhost:3306/timemanager";
                  String name="root";
                  String password="mpc1314520";
                  MySQLOP.Instance().InitMySQL(url,name,password);
                  System.out.println("初始化成功");
              }
              try{
                  Event event=new Event("111","222","333",0);
                  System.out.println("创建成功");
                  MySQLOP.Instance().InsertEvent(event);
                  System.out.println("插入成功");
              }catch (Exception e){
                  e.printStackTrace();
              }
    }
    public void destroy() {
    }
}