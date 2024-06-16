/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.*;
/**
 *
 * @author emir
 */
public class ConnectionProvider {
    public static Connection getCon(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://monorail.proxy.rlwy.net:16721/railway?useSSL=false","root","LjkhSEycRiJTWCYxpGrFaOgtJquZFVHg");
            return con;
        }
            catch(Exception e) {
                    return null;
                    }
    }
            
}
