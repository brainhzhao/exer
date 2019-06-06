package priv.zh.designpattern.command;


/**
 * @author zhaoheng
 * command 接口
 */
public interface Command {
    void execute(CommandReceiver commandReceiver);
}
