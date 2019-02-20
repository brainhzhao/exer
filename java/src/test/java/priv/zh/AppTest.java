package priv.zh;

import static org.junit.Assert.assertTrue;




import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import priv.zh.algorithm.BinarySearch;
import priv.zh.base.keyword.FinalDemo;
import priv.zh.lambda.LambdaDemo;
import static priv.zh.dbframe.mybatis.MybatisDemo.getSqlSessionFactoryByXml;

import java.util.HashMap;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Before
    public void before(){

    }

    @After
    public void after(){

    }

    @BeforeClass
    public static void beforeClass(){

    }

    @AfterClass
    public static void afterClass(){

    }

    @Test
    public void testBinarySearch(){
        int[] orderList={2,3,5,6,7,8,12,3434,54454,3434343,34343232,93232323};
        System.out.println(BinarySearch.binarySearch(orderList, 7, 0, orderList.length-1));
    }
    
    @Test(timeout=10000)
    public void finalDemoTest(){
        //long startTime=System.currentTimeMillis();
        // final修饰变量时，该变量的值不可改变
        
        final String a="Hello1";
        String b="Hello1";
        String c=a+"1";
        String d="Hello";
        String e=d+"1";

        assertTrue(a==b);
        assertTrue(a==e);

        //final修饰方法时，该方法不能被子类重写
        
        // new FinalDemo().new Child().sayHello();
        // System.out.println(System.currentTimeMillis()-startTime);

        //final修饰类时标示此类不可被继承
    }

    /*
    *  mybatis demo's unit test method
     */
    @Test
    public void mybatisDemo(){
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
    * lambda demo test
     */
    @Test
    public void lambdaDemo(){
        new LambdaDemo().exec();
    }

    /*
    * collection demo unit test method
    */
    @Test
    public void collectionDemo(){

    }
}
