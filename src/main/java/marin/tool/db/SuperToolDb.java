package marin.tool.db;

import marin.tool.db.bo.DbConnectionBo;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author :Marin Wu
 * @email :marin_kx@163.com
 * @date :2022/11/21
 */
public class SuperToolDb {


    /**
     * 和数据库建立连接
     * @return 数据库连接对象
     */
    private Connection dbConnection(DbConnectionBo dbConnectionBo)  {
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


    /**
     * 查询所有的数据
     * @return 返回查询结果
     */
    public List<Map<String,Object>> dbSelectAllList(DbConnectionBo dbConnectionBo){

        //1、建立连接
        Connection conn = dbConnection(dbConnectionBo);
        //2、QueryRunner对象生成
        QueryRunner queryRunner = new QueryRunner();
        //3、执行sql
        List<Map<String,Object>> data = null;
        try {
            data = queryRunner.query(conn,dbConnectionBo.getSql(),new MapListHandler());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return data;
    }


    /**
     * 根据id 和 table 查询一条数据
     * @return 返回查询结果
     */
    public List<Map<String,Object>> dbSelectById(DbConnectionBo dbConnectionBo,Integer id, String table){

        String sql = "SELECT * FROM "+table+" WHERE id = "+ id +" ;";

        //1、建立连接
        Connection conn = dbConnection(dbConnectionBo);
        //2、QueryRunner对象生成
        QueryRunner queryRunner = new QueryRunner();
        //3、执行sql
        List<Map<String,Object>> data = null;
        try {
            data = queryRunner.query(conn,sql,new MapListHandler());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return data;
    }

    /**
     * 根据ids 和单表 查询多条数据
     * @return 返回查询结果
     */
    public List<Map<String,Object>> dbSelectByIds(DbConnectionBo dbConnectionBo,List<Integer> ids, String table){

        String idsData = ids.toString().replaceAll("\\[","").replaceAll("\\]","");

        String sql = "SELECT * FROM "+table+" WHERE id in ("+ idsData +") ;";

        //1、建立连接
        Connection conn = dbConnection(dbConnectionBo);
        //2、QueryRunner对象生成
        QueryRunner queryRunner = new QueryRunner();
        //3、执行sql
        List<Map<String,Object>> data = null;
        try {
            data = queryRunner.query(conn,sql,new MapListHandler());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return data;
    }

    /**
     * 根据ids 和单表 查询多条数据
     * @return 返回查询结果
     */
    public List<Map<String,Object>> dbSelectLike(DbConnectionBo dbConnectionBo,String key, String value, String table){

        String sql = "SELECT * FROM "+table+" WHERE "+key+"LIKE '%"+value+"%';";

        //1、建立连接
        Connection conn = dbConnection(dbConnectionBo);
        //2、QueryRunner对象生成
        QueryRunner queryRunner = new QueryRunner();
        //3、执行sql
        List<Map<String,Object>> data = null;
        try {
            data = queryRunner.query(conn,sql,new MapListHandler());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return data;
    }

    /**
     * 修改数据库数据操作（插入、修改、删除）
     */
    public int db(DbConnectionBo dbConnectionBo){
        Integer result = null;
        //1、建立连接
        Connection conn = dbConnection(dbConnectionBo);
        //2、QueryRunner对象生成
        QueryRunner queryRunner = new QueryRunner();
        //3、执行sql
        try {
            result = queryRunner.update(conn,dbConnectionBo.getSql());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //关闭连接
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return result;
    }


}
