package marin.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author :Marin Wu
 * @email：marin_kx@163.com
 * @date : 2022/11/21
 */
public class SuperToolAll {

    /**
     * 和数据库建立连接
     * @return 数据库连接对象
     */
    public Connection getConnection(String url, String user, String password)  {
        //定义数据库连接对象
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

}
