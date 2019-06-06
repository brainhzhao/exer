package priv.zh.designpattern.command;


public class CommandChinese implements  Command{
    @Override
    public void execute(CommandReceiver receiver){
        receiver.sayHello();
        receiver.sayWhereFrom();
    }
}