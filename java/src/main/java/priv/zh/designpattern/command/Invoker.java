package priv.zh.designpattern.command;

import java.util.ArrayList;

public class Invoker {

    public static void execute(Command command,CommandReceiver receiver){
        command.execute(receiver);
    }
}
