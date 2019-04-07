
@RestController
class HelloWorld{
    @RequestMapping("/")
    String name(){
        "Helle World!"
    }
}