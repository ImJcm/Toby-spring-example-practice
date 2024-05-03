package com.imjcm.tobyspringexamplepractice.user.dao;

import com.imjcm.tobyspringexamplepractice.user.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserDaoTest {
    @Test
    @DisplayName("UserDao Test")
    public void UserDaoTest_main() throws ClassNotFoundException, SQLException {
        UserDao dao = new UserDao();

        User user = new User();
        user.setId("whiteship");
        user.setName("JCM");
        user.setPassword("1234");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());

        Assertions.assertThat(user2.getName()).isEqualTo(user.getName());
        Assertions.assertThat(user2.getPassword()).isEqualTo(user.getPassword());
    }
}