package priv.zh.jvm.classloader;


/**
 * @author zhaoheng
 * @version 1.0
 */
public class ClassLoading{
    /**
     * jvm加载类的过程为 1、加载(从磁盘或者网络Io加载加载二进制class流)
     *                 2、验证 （verification）
     *                 3、准备 (prepration)
     *                 4、解析 (resolvation)
     *                 5、初始化
     *                 6、使用
     *                 7、卸载
     */
    public static int a=10;
    static {
        System.out.println("ClassLoading init...");
    }
    public static class Loading{
        final static int a=20;
        static{
            System.out.println("ClassLoading.Loading init...");
        }
        public static void printA(){
            System.out.println(a);
        }
    }
}