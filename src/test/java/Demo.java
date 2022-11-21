import marin.tool.db.SuperToolDb;
import marin.tool.db.bo.DbConnectionBo;
import org.testng.annotations.Test;

/**
 * @author :Marin Wu
 * @email：marin_kx@163.com
 * @date : 2022/11/21
 */
public class Demo {

    @Test
    public void aaa(){

        SuperToolDb db = new SuperToolDb();

        DbConnectionBo dbConnectionBo = new DbConnectionBo();
        dbConnectionBo.setUrl("jdbc:mysql://s10.z100.vip:26194/");
        dbConnectionBo.setUserName("budtech_marin");
        dbConnectionBo.setPassword("marin@123");
        dbConnectionBo.setDatabases("abi-cloud-middle-platform-user-dev");

        System.out.println( db.getDbConnection(dbConnectionBo));

    }
}
