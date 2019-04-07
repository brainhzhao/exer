package priv.zh.designpattern.proxy.staticproxy;


public class ProxyObject implements AbstractProxyObject{
    private ChineseReal real;

    public ProxyObject(){
        if(real==null){
            real=new ChineseReal();
        }
    }

    @Override
    public void sayHello(){
        System.out.println("begin print ....");
        this.real.sayHello();
        System.out.println("end print ....");
    }
}