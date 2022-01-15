package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    public static final String dbUser = "postgres"; //user
    public static final String dbPassword = "newpassword"; //parol
    static String url; //murojaat yo'li
    static String host = "localhost"; //kun.uz //192.168.22.11

    static String dbName = "warehouse";
    static String port = "5432"; //postgres  //oracle //345 //mysql// 123

    public static Connection connection(){
        Connection connection=null;
        url="jdbc:postgresql://"+host+":"+port+"/"+dbName;
        try {
            Class.forName("org.postgresql.Driver");
            connection= DriverManager.getConnection(url,dbUser,dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;

    }
}
