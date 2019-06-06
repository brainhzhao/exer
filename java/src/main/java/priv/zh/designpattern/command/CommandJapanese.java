package priv.zh.designpattern.command;


public class CommandJapanese implements Command{
    @Override
    public void execute(CommandReceiver receiver){
        receiver.sayHello();
        receiver.sayWhereFrom();
    }
}