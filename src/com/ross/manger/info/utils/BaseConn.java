package com.ross.manger.info.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public final class BaseConn {
    private static String driver=null,url=null,username=null,password=null;
    public static Connection getConnection(){
        InputStream input=BaseConn.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties=new Properties();
        try {
            properties.load(input);
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            Class.forName(driver);
            return DriverManager.getConnection(url,username,password);

        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void release(Connection connection, Statement statement, ResultSet result){
        try {
            if (connection != null){
                connection.close();
            }
            if (statement != null){
                statement.close();
            }
            if (result != null){
                result.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*public static void main(String[] args) {
        System.out.println(BaseConn.getConnection());
    }*/
}
