package priv.zh.model;


public class HelloWorldService{
    private HelloWorld helloWorld;

    public HelloWorldService(){

    }
    
    public void setHelloWorld(HelloWorld helloWorld){
        this.helloWorld=helloWorld;
    }

    public HelloWorld getHelloWorld(){
        return this.helloWorld;
    }
}