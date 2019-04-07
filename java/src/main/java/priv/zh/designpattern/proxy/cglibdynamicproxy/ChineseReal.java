package priv.zh.designpattern.proxy.cglibdynamicproxy;


public class ChineseReal extends AbstractProxyObject{
 
    @Override 
    public void sayHello(){
        System.out.println("I'am chinese people");
    }
}