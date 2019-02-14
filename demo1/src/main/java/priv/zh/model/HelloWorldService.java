package priv.zh.model;

import org.springframework.beans.factory.InitializingBean;;

public class HelloWorldService implements InitializingBean {
    private HelloWorld helloWorld;
    private int count = 0;

    @Override
    public void afterPropertiesSet() {
        System.out.println("init method");
    }

    public HelloWorldService() {

    }

    public HelloWorldService(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

    public void setHelloWorld(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

    public HelloWorld getHelloWorld() {
        return this.helloWorld;
    }

    public void addCount() {
        count++;
        System.out.println("count is " + count);
    }
}