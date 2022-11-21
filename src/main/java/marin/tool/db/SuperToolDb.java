package marin.tool.db;

import marin.tool.db.bo.DbConnectionBo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author :Marin Wu
 * @email：marin_kx@163.com
 * @date : 2022/11/21
 */
public class SuperToolDb {

    /**
     * 和数据库建立连接
     * @return 数据库连接对象
     */
    public Connection getDbConnection(DbConnectionBo dbConnectionBo)  {
        //定义数据库连接对象
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbConnectionBo.getUrl()+dbConnectionBo.getDatabases()+"?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
                    dbConnectionBo.getUserName(),
                    dbConnectionBo.getPassword());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }




}
