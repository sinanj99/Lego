/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Logic.DuplicateException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sinanjasar
 */
class UserMapper extends IUserMapper {

    private static UserMapper instance = null;
    
    public synchronized static UserMapper getInstance()
    {
        if(instance == null) instance = new UserMapper();
        return instance;
    }
    
    @Override
    public User getUser(String username) {
        int user_id = 0;
        String username_ = "";
        String password = "";
        int balance = 0;
        int isAdmin = 0;
        try {
            Connection con = DB.getConnection();

            String sql = "SELECT * FROM user WHERE username = ?";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                user_id = rs.getInt("user_id");
                username_ = rs.getString("username");
                password = rs.getString("password");
                balance = rs.getInt("balance");
                isAdmin = rs.getInt("isAdmin");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return new User(user_id, username_, password, balance, isAdmin);
    }

    @Override
    public void insertUser(String name, String password, int balance) throws DuplicateException {

        try {
            Connection conn = DB.getConnection();
            String sql = "INSERT INTO user(username, password, balance, isAdmin) "
                    + "VALUES (?, ?, ?, 0);";
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            pstmt.setInt(3, balance);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new DuplicateException(ex.getMessage());
        }
    }
//
//    @Override
//    public void setBalance(String username, int balance) throws SQLException {
//        Connection conn = DB.getConnection();
//        String sql = "UPDATE user SET balance = ? WHERE username = ?;";
//        PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//        pstmt.setInt(1, balance);
//        pstmt.setString(2, username);
//        pstmt.executeUpdate();
//    }
}
