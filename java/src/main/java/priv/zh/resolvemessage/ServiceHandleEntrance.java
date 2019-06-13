package priv.zh.resolvemessage;

import java.net.Socket;

public class ServiceHandleEntrance {

    private Socket socket;

    private String serviceId;

    public ServiceHandleEntrance(Socket socket){
        this.socket = socket;
    }

    /**
     * 服务识别
     *    提取客户端发送的报文的头部节点，根据Service_ID节点识别服务
     *        launchOrder -> 发起投诉
     *        searchOrderList -> 投诉信息查询
     *        searchOrderDetail -> 投诉详情查询
     * @author zhaoheng
     */
    public ServiceHandleEntrance serviceIdentify(){

        return this;
    }
}
