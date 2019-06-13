package priv.zh.resolvemessage;

public class LaunchOrderServiceHandleCommand implements IServiceHandleCommand{

    private ServiceReceiver receiver;

    public LaunchOrderServiceHandleCommand(ServiceReceiver receiver){
        this.receiver=receiver;
    }

    @Override
    public void execute(){
        receiver.add();
    }
}