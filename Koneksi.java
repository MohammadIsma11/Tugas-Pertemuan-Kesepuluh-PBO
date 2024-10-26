/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTS;

import java.sql.*;

/**
 *
 * @author ISMAIL
 */
public class Koneksi {
    public static Connection getConnection() {
    try {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/pbo", "postgres", "isma111004");
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}
}

   
