package priv.zh.dbframe.mybatis;

import java.io.InputStream;
import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;

public class MybatisDemo{

    private final static Logger logger=Logger.getLogger(MybatisDemo.class);

    /*
    * @param uri配置文件路径
    * @return 一个SqlSessionFactory实例
    *  get SqlSessionFactory by xml
    */
    public static SqlSessionFactory getSqlSessionFactoryByXml(String uri){
        Assert.notNull(uri, "配置路径不可为空!");
        SqlSessionFactory ssf=null;
        try {
            InputStream is=Resources.getResourceAsStream(uri);
            ssf=new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            System.out.println("io error");
        }
        return ssf;     
    }


    public static  String generateDynamicSql(){

        return new SQL(){{ SELECT("P.ID, P.USERNAME, P.PASSWORD, P.FULL_NAME");
            SELECT("P.LAST_NAME, P.CREATED_ON, P.UPDATED_ON");
            FROM("PERSON P");
            FROM("ACCOUNT A");
            INNER_JOIN("DEPARTMENT D on D.ID = P.DEPARTMENT_ID");
            INNER_JOIN("COMPANY C on D.COMPANY_ID = C.ID");
            WHERE("P.ID = A.ID");
            WHERE("P.FIRST_NAME like ?");
            OR();
            WHERE("P.LAST_NAME like ?");
            GROUP_BY("P.ID");
            HAVING("P.LAST_NAME like ?");
            OR();
            HAVING("P.FIRST_NAME like ?");
            ORDER_BY("P.ID");
            ORDER_BY("P.FULL_NAME");}}.toString();
    }
}