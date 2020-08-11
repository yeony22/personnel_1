package com.yeon.exam1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
 
import com.yeon.exam1.dto.UserDto;

public class UserDao {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    
    public UserDao() {
        try {
            String dbURL = "jdbc:mysql://localhost:3306/practice1?serverTimezone=UTC";
            String dbID = "root";
            String dbPassword = "1234";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL,dbID,dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public int register(UserDto dto) {
        String SQL = "INSERT INTO PERSONNEL(ID, NAME, DEPT, POSITION, DUTY, PHONE) VALUES(?,?,?,?,?,?)";
        try {
            pstmt= conn.prepareStatement(SQL);
            pstmt.setString(1, dto.getID());
            pstmt.setString(2, dto.getNAME());
            pstmt.setString(3, dto.getDEPT());
            pstmt.setString(4, dto.getPOSITION());
            pstmt.setString(5, dto.getDUTY());
            pstmt.setString(6, dto.getPHONE());           
            return pstmt.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return -1; // database error
    }
}
