package priv.zh.demo1;


import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;


@RestController
@EnableAutoConfiguration
public  class  HelloWorld{

    @RequestMapping("/")
    public  String sayHelloWorld(){
        return "Hello World";
    }

    public  static  void main(String[] args) {
        SpringApplication.run(HelloWorld.class,args);
    }
}