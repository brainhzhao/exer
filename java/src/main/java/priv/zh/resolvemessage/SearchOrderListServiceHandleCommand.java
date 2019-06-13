package priv.zh.resolvemessage;

public class SearchOrderListServiceHandleCommand implements IServiceHandleCommand{
    private ServiceReceiver receiver;

    public SearchOrderListServiceHandleCommand(ServiceReceiver receiver){
        this.receiver=receiver;
    }

    @Override
    public void execute(){
        receiver.searchOrderList();
    }
}
