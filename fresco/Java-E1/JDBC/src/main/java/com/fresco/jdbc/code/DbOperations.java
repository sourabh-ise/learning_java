package com.fresco.jdbc.code;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fresco.jdbc.code.util.DbUtil;

public class DbOperations {
    private Connection conn;
    public boolean insertCategory(String type) throws SQLException {
        //category
        Statement stmt = null;
        conn = DbUtil.getConnection();
        System.out.println("Connected database successfully...");

        //STEP 4: Execute a query
        System.out.println("Inserting records into the table...");
        stmt = conn.createStatement();

        String sql = "INSERT INTO category VALUES ("+type+")";
        int i = stmt.executeUpdate(sql);
        if(i>0){
            return true;
        }
        return false;

    }
    public ArrayList getCategoryById(int id) throws SQLException {
        return null;
    }
    public ResultSet getAllCategory() throws SQLException {
        return null;
    }
    public boolean insertProduct(String name, float price, String type) throws SQLException {
        return false;
    }
    public ArrayList getProductById(int id) throws SQLException {
        return null;
    }
    public ResultSet getAllProduct() throws SQLException {
        return null;
    }
    public boolean insertOrder(String product_name, Date date) throws SQLException {
        return false;
    }
    public ArrayList getOrderById(int id) throws SQLException {
        return null;
    }
    public ResultSet getAllOrder() throws SQLException {
        return null;
    }
}


//    sudo apt-get update
//        sudo apt-get install -y debconf-utils
//        export DEBIAN_FRONTEND="noninteractive"
//        sudo debconf-set-selections <<< "mysql-server mysql-server/root_password password rootpw"
//        sudo debconf-set-selections <<< "mysql-server mysql-server/root_password_again password rootpw"
//        sudo apt-get install -y mysql-server
//        sudo service mysql start
//        echo "create database grocery" | mysql -uroot -prootpw