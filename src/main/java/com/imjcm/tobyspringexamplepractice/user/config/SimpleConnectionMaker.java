package com.imjcm.tobyspringexamplepractice.user.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConnectionMaker {

    /*
        spring boot 환경에서 DataSource를 통해 DB에 접근하기 때문에 아래와 같은 형태로 접근하기 위해서
        ~Application.java에 @EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})를 추가한다.
     */
    public Connection makeNewConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/toby_spring_example","root","jcm0909!");

        return con;
    }
}
