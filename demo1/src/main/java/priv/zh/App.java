package priv.zh;


import priv.zh.thread.ThreadLocalDemo;


/*
@author SilenceZhao
@propose exer Spring
*/

public class App  
{
    public static void main( String[] args ) 
    {
        try {
            ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
            HelloWorldService service=(HelloWorldService)context.getBean("helloWorldService");
            HelloWorld helloWorld=service.getHelloWorld();
            helloWorld.sayHello();
            ThreadLocalDemo localDemo=new ThreadLocalDemo();
            localDemo.start();
        } catch (Exception e) {

        }      
    }
}
