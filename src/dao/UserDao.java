/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JOptionPane;
import model.User;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author emiry
 */
public class UserDao {

    public static void save(User user) {
        String query = "insert into user(name,email,password,mobileNumber,status) values('" + user.getName() + "','" + user.getEmail() + "','" + user.getPassword() + "','" + user.getNumber() + "','true')";
        DbOperations.setDataorDelete(query, "Registrado correctamente, espera aprovacion");
    }

    public static User login(String email, String password) {
        User user = null;
        try {
            ResultSet rs = DbOperations.getData("select *from user where email='" + email + "' and password='" + password + "'");
            while (rs.next()) {
                user = new User();
                user.setStatus(rs.getString("status"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }

    public static ArrayList<User> getAllRecords(String name) {
        ArrayList<User> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("select *from user where name like '%" + name + "%'");
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setNumber(rs.getString("mobileNumber"));
                user.setStatus(rs.getString("status"));
                if (user.getName() != null) {
                    arrayList.add(user);
                } else {
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }

    public static void changeStatus(String name, String status) {
        String query = "update user set status='" + status + "' where name = '" + name + "'";
        DbOperations.setDataorDelete(query, "El estatus se cambio.");
    }
}
