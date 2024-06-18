/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import javax.swing.JOptionPane;
import model.User;
import java.sql.*;
/**
 *
 * @author emiry
 */
public class UserDao {
    public static void save(User user) {
        String query = "insert into user(name,email,password,mobileNumber,status) values('"+user.getName()+"','"+user.getEmail()+"','"+user.getPassword()+"','"+user.getNumber()+"','false')";
        DbOperations.setDataorDelete(query, "Registrado correctamente, espera aprovacion");         
    }
    
    public static User login(String name, String password) {
        User user = null;
        try {
            ResultSet rs = DbOperations.getData("select *from user where name='"+name+"' and password='"+password+"'");
            while(rs.next()) {
                user = new User();
                user.setStatus(rs.getString("status"));
            }
        }
        
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }
}
