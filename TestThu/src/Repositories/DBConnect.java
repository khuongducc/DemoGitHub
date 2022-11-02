/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author khuong duc
 */
public class DBConnect {

    private static final String USERNAME = "duc";
    private static final String PASSWORD = "123";
    private static final String SERVER = "DESKTOP-RK49KB5\\SQLEXPRESS";
    private static final String PORT = "1433";
    private static final String DATABASE_NAME = "SOF2041_DAM";
    private static final boolean USING_SSL = true;
    private static String CONNECT_STRING;

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            StringBuilder connectStringBuilder = new StringBuilder();
            connectStringBuilder.append("jdbc:sqlserver://")
                    .append(SERVER).append(":").append(PORT).append(";")
                    .append("databaseName=").append(DATABASE_NAME).append(";")
                    .append("user=").append(USERNAME).append(";")
                    .append("password=").append(PASSWORD).append(";");
            if (USING_SSL) {
                connectStringBuilder.append("encrypt=true;trustServerCertificate=true;");
            }
            CONNECT_STRING = connectStringBuilder.toString();
            System.out.println("Connect String có dạng: " + CONNECT_STRING);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONNECT_STRING);
    }

    public static void main(String[] args) {
        try {
            System.out.println(getConnection().getMetaData());
        } catch (Exception e) {
        }
    }
    //duoc chua
}
