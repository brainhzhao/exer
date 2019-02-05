package priv.zh.model;


public class HelloWorldService{
    private HelloWorld helloWorld;
    private int count=0;
    public HelloWorldService(){

    }
    
    public void setHelloWorld(HelloWorld helloWorld){
        this.helloWorld=helloWorld;
    }

    public HelloWorld getHelloWorld(){
        return this.helloWorld;
    }

    public void addCount(){
        count++;
        System.out.println("count is "+count);
    }
}