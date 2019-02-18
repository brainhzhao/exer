package priv.zh.dbframe.mybatis;

import java.io.InputStream;
import java.util.HashMap;
import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.SqlSession;
import org.springframework.util.Assert;

public class MybatisDemo{
    public static void main(String[] args) {
        SqlSessionFactory ssf=getSqlSessionFactoryByXml("mybatis/mybatis-cfg.xml");
        SqlSession ss=ssf.openSession();
        try {
           HashMap<Object,Object> paramMap=new HashMap<>();
           paramMap.put("stuid","1");
           paramMap.put("stuname","2121");
           System.out.println(ss.selectList("StudentMapper.selectStudent",paramMap));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally{
            ss.close();
        }
    }

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
}