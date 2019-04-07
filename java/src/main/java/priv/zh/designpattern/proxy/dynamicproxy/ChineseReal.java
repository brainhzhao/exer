package priv.zh.designpattern.proxy.dynamicproxy;


public class ChineseReal implements AbstractProxyObject{
 
    @Override 
    public void sayHello(){
        System.out.println("I'am chinese people");
    }
}