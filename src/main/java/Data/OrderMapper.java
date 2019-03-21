/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sinanjasar
 */
 class OrderMapper extends IOrderMapper {
    
     private static OrderMapper instance = null;
    
    public synchronized static OrderMapper getInstance()
    {
        if(instance == null) instance = new OrderMapper();
        return instance;
    }
    @Override
    public Order insertOrder(int user_id, int length, int height, int width) {
        int order_id = 0;
        Connection conn = null;
        try {
            conn = DB.getConnection();
            conn.setAutoCommit(false);
            String sql = "INSERT INTO `order`(user_id, height, width, length) "
                    + "VALUES(?, ?, ?, ?);";
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, user_id);
            pstmt.setInt(2, height);
            pstmt.setInt(3, width);
            pstmt.setInt(4, length);
            pstmt.executeUpdate();

            sql = "SELECT order_id FROM `order` WHERE user_id = ? ORDER BY order_id DESC LIMIT 1;";
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, user_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                order_id = rs.getInt("order_id");
            }
            conn.commit();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                System.out.println(ex1.getMessage());
            }
        }
        return new Order(order_id, user_id, height, width, length, null);
    }

    @Override
    public void markShipped(int id, String datetime) {
        try {
            Connection conn = DB.getConnection();
            String sql = "UPDATE `order` SET shipped = ? WHERE order_id = ?;";
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, datetime);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        OrderMapper om = new OrderMapper();
        String datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        System.out.println(datetime);
        om.markShipped(10, datetime);
    }

    @Override
    public Order getOrder(int id) {
        int order_id = 0;
        int user_id = 0;
        int height = 0;
        int width = 0;
        int length = 0;
        String datetime = "";
        try {
            Connection conn = DB.getConnection();
            String sql = "SELECT * FROM `order` WHERE order_id = ?;";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {

                order_id = rs.getInt("order_id");
                user_id = rs.getInt("user_id");
                height = rs.getInt("height");
                width = rs.getInt("width");
                length = rs.getInt("length");
                datetime = rs.getString("shipped");

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return new Order(order_id, user_id, height, width, length, datetime);
    }

    @Override
    public List<Order> getOrders() {
        int order_id = 0;
        int user_id = 0;
        int height = 0;
        int width = 0;
        int length = 0;
        String datetime = "";
        List<Order> orders = new ArrayList();
        try {
            Connection conn = DB.getConnection();
            String sql = "SELECT * FROM `order`;";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                order_id = rs.getInt("order_id");
                user_id = rs.getInt("user_id");
                height = rs.getInt("height");
                width = rs.getInt("width");
                length = rs.getInt("length");
                datetime = rs.getString("shipped");
                orders.add(new Order(order_id, user_id, height, width, length, datetime));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return orders;
    }
    
    @Override
    public List<Order> getOrders(int id) {
        int order_id = 0;
        int user_id = 0;
        int height = 0;
        int width = 0;
        int length = 0;
        String datetime = "";
        List<Order> orders = new ArrayList();
        try {
            Connection conn = DB.getConnection();
            String sql = "SELECT * FROM `order` WHERE user_id = ?;";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                order_id = rs.getInt("order_id");
                user_id = rs.getInt("user_id");
                height = rs.getInt("height");
                width = rs.getInt("width");
                length = rs.getInt("length");
                datetime = rs.getString("shipped");
                orders.add(new Order(order_id, user_id, height, width, length, datetime));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return orders;
    }
}

