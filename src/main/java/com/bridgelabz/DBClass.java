package com.bridgelabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Driver;
import java.util.Enumeration;

public class DBClass {
    public static void main(String[] args) {
        String jdbcurl = "jdbc:mysql://localhost:3306/payroll_services?useSSL=false";
        String username = "root";
        String password = "Swati27";
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loded");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("cannot find the driver in the classpath", e);
        }
        listDrivers();
      try{
          System.out.println("Connecting to databases"+jdbcurl);
          connection=DriverManager.getConnection(jdbcurl,username,password);
          System.out.println("connection is successfull"+connection);
      }catch (Exception e){
          e.printStackTrace();
      }

    }

    private static void listDrivers() {
        Enumeration<Driver> driverList =DriverManager.getDrivers();
        while(driverList.hasMoreElements()){
            Driver driverClass=(Driver)  driverList.nextElement();
            System.out.println("   "+driverClass.getClass().getName());
        }

    }


}