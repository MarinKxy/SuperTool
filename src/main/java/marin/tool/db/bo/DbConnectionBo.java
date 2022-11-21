package marin.tool.db.bo;

import lombok.Data;

/**
 * @author :Marin Wu
 * @email：marin_kx@163.com
 * @date : 2022/11/21
 */

@Data
public class DbConnectionBo {

    String url;      //数据库连接地址
    String userName; //数据库连接名
    String password; //数据库密码
    String driver;  //数据库驱动
    String databases; //数据库库名
    String setting; //数据库连接串
}
