/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UTS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ISMAIL
 */
public class MkDb {
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Statement st;
    
    public MkDb (){
        try{
            Class.forName("org.postgresql.Driver");
                try{
                    con = DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5432/pbo","postgres","isma111004");
                }catch (SQLException ex){
                    Logger.getLogger(MkDb.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Koneksi sukses");
        }catch (ClassNotFoundException ex){
            Logger.getLogger(MkDb.class.getName()).log(Level.SEVERE, null,ex);
        }
    }
    
    public void insertDB(String kodemk, String sks, String namamk, String semesterajar){
        try {
            String sql = "insert into MataKuliah values(?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, kodemk);
            pst.setString(2, sks);
            pst.setString(3, namamk);
            pst.setString(4, semesterajar);
            pst.executeUpdate();
        } catch (SQLException ex){
            Logger.getLogger(MkDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateDb(String kodemk, String sks, String namamk, String semesterajar){
        try {
            String sql = "update MataKuliah set SKS=?, NamaMk=?, SemesterAjar=? where KodeMk=?";
            pst = con.prepareStatement(sql);
            pst.setString(4, kodemk);
            pst.setString(1, sks);
            pst.setString(2, namamk);
            pst.setString(3, semesterajar);
            pst.executeUpdate();
        } catch (SQLException ex){
            Logger.getLogger(MkDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet selectDb(){
        try{
            String sql = "select * from MataKuliah";
            st = con.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex){
            Logger.getLogger(MkDb.class.getName()).log(Level.SEVERE, null,ex);
        }
        return rs;
    }
    
    public void deleteDb(String kodemk){
        try{
           String sql = "delete from MataKuliah where KodeMk=?";
        pst = con.prepareStatement(sql);
        pst.setString(1, kodemk);
        pst.executeUpdate(); 
        } catch (SQLException ex){
            Logger.getLogger(MkDb.class.getName()).log(Level.SEVERE, null,ex);
        }
    }
}
