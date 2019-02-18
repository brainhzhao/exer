package priv.zh.java8.interfacenew;


public interface Java8InterfaceDemo{
    default void sayHelloWorld(){
        System.out.println("HelloWorld");
    }
    public static void sayBye(){
        System.out.println("Bye");
    }

 
}