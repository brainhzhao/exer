package priv.zh.resolvemessage;

import java.net.Socket;
import java.util.Objects;

public class ServiceReceiver {
    private Socket socket;

    public ServiceReceiver(Socket socket){
        this.socket= Objects.requireNonNull(socket);
    }

    //新增
    public void add(){

    }
    //查询列表
    public void searchOrderList(){

    }
    //查询明细
    public void searchOrderDetail(){

    }
}
