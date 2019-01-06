package priv.zh;


import priv.zh.model.HelloWorld;
import priv.zh.model.HelloWorldService;
import priv.zh.thread.ThreadLocalDemo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
@author SilenceZhao
@propose exer Spring
*/

public class App  
{
    public static void main( String[] args ) 
    {
        try {
         /*   ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
            HelloWorldService service=(HelloWorldService)context.getBean("helloWorldService");
            HelloWorld helloWorld=service.getHelloWorld();
            helloWorld.sayHello();*/
            ThreadLocalDemo localDemo=new ThreadLocalDemo();
            localDemo.start();
        } catch (Exception e) {

        }      
    }
}
