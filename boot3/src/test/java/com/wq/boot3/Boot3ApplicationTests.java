package com.wq.boot3;

import com.wq.boot3.bean.UserLogin;
import com.wq.boot3.mapper.UserLoginMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class Boot3ApplicationTests {

    @Autowired
    DataSource dataSource;
    @Test
    void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection=dataSource.getConnection();
        System.out.println(connection);

        connection.close();
    }

    @Autowired
    UserLoginMapper userLoginMapper;
    @Test
    public void testUserLoginMapper(){
        List<UserLogin> userLogins=userLoginMapper.getAllUser();
        System.out.println(userLogins);
    }

}
