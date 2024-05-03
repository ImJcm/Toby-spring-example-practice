package com.imjcm.tobyspringexamplepractice.user.dao;

import com.imjcm.tobyspringexamplepractice.user.config.SimpleConnectionMaker;
import com.imjcm.tobyspringexamplepractice.user.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private SimpleConnectionMaker simpleConnectionMaker;

    public UserDao() {
        this.simpleConnectionMaker = new SimpleConnectionMaker();
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection con = simpleConnectionMaker.makeNewConnection();

        PreparedStatement pstmt = con.prepareStatement(
                "insert into user(id,name,password) values(?,?,?)"
        );

        pstmt.setString(1,user.getId());
        pstmt.setString(2,user.getName());
        pstmt.setString(3,user.getPassword());

        pstmt.executeUpdate();

        pstmt.close();
        con.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection con = simpleConnectionMaker.makeNewConnection();

        PreparedStatement pstmt = con.prepareStatement(
                "select * from user where id = ?"
        );
        pstmt.setString(1, id);

        ResultSet rs = pstmt.executeQuery();

        rs.next();

        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        pstmt.close();
        con.close();

        return user;

    }
}
