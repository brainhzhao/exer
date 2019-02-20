package priv.zh.base.keyword;


public class FinalDemo{

    
    public class Super{
        public Super(){
            System.out.println("Super");
        }
        public  void sayHello(){
            System.out.println("HelloWorld");
        }
    }
    public class Child extends Super{
        public Child(){
            System.out.println("123");
        }
        public void sayHello(){
            System.out.println("Child Hello World");
        }
    }

   
}