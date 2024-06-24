/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JOptionPane;

/**
 *
 * @author emiry
 */
public class tables {

    public static void main(String[] args) {
        try {
            String userTable = "create table user(id int AUTO_INCREMENT primary key,name varchar(200), email varchar(200),mobileNumber varchar(200),password varchar(200), status varchar(20),UNIQUE (email))";
            String adminDetails = "insert into user(name,email,mobileNumber,password,status) values('Admin','admin@gmail.com','1234567890','cbtis2008','true')";
            String categoryTable = "create table category(id int AUTO_INCREMENT primary key,name varchar(200))";
            String productTable = "create table product(id int AUTO_INCREMENT primary key,name varchar(200),category varchar(200), price varchar(200))";
            String billTable = "create table bill(id int primary key,name varchar(200),mobileNumber varchar(200),email varchar(200), date varchar(200),total varchar(200), createdBy varchar(200))";
            DbOperations.setDataorDelete(productTable, "Tabla de Productos creada");
            DbOperations.setDataorDelete(userTable, "Tabla de Usuario Creada");
            DbOperations.setDataorDelete(adminDetails, "Usuario de Admin Creado");
            DbOperations.setDataorDelete(categoryTable, "Tabla de Category Creada");
            DbOperations.setDataorDelete(billTable, "Tabla de bill Creada");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
