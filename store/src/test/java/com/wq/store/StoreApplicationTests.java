package com.wq.store;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class StoreApplicationTests {

    @Test
    void contextLoads() {
    }



    @Autowired
    DataSource dataSource;
    @Test
    public void getConnection() throws SQLException {
        /*
        * 数据库连接池：
        * 1、DBCP
        * 2、c3p0
        * 3、Hikari(目前最快的)：管理数据库的连接对象
        * */
        //HikariProxyConnection@1149993098 wrapping com.mysql.cj.jdbc.ConnectionImpl@7e62cfa3
        System.out.println(dataSource.getConnection());
    }
}
