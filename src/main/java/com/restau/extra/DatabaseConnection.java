package com.restau.extra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static String url;
    public static String dataBaseHost = "localhost";
    public static String dataBasePort = "3306";
    public static String dataBaseName = "miniproject_db";
    public static String dataBaseUser = "root";
    public static String dataBasePassword = "root";
    public static Connection con;
    String query;

    public static Connection getConnected(){
        try{
            url = "jdbc:mysql://"+dataBaseHost+":"+dataBasePort+"/"+dataBaseName;

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, dataBaseUser, dataBasePassword);
        }
        catch(Exception e){
            System.out.println("Connection failed : "+e);
            return null;
        }

        return con;
    }
    public static void releaseConnection(){
        try {
            con.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
