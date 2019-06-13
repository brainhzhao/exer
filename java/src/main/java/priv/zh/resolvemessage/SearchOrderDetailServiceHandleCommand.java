package priv.zh.resolvemessage;

public class SearchOrderDetailServiceHandleCommand implements IServiceHandleCommand{
    private ServiceReceiver receiver;

    public SearchOrderDetailServiceHandleCommand(ServiceReceiver receiver){
        this.receiver=receiver;
    }

    @Override
    public void execute(){
        receiver.searchOrderDetail();
    }
}
