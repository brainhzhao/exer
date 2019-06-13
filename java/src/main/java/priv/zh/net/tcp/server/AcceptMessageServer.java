package priv.zh.net.tcp.server;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;


import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;

/**
 * accept message from client
 * @author zhaoheng
 * @version 20190610
 */


 public class AcceptMessageServer{
    
    private final static Logger logger = Logger.getLogger(AcceptMessageServer.class);

    private ServerSocket server;

    private ThreadPoolExecutor executor;

    public AcceptMessageServer(ThreadPoolExecutor executor,String ip,int port){
        try {
            InetSocketAddress socketAddress = (ip==null||ip.equals(""))?new InetSocketAddress(port):new InetSocketAddress(ip, port); 
            this.executor=executor;
            server = new ServerSocket();
            server.setSoTimeout(60000);
            server.bind(socketAddress);
            if(logger.isDebugEnabled()){
                logger.debug("在"+port+"处成功绑定服务");
            }
        } catch (IOException ex){
            logger.error("在"+port+"处绑定服务端口失败",ex);
        }
    }

    public AcceptMessageServer(){
        if(logger.isDebugEnabled()){
            logger.debug("默认使用65533端口进行服务绑定");
        }
        InetSocketAddress socketAddress = new InetSocketAddress(65533);
        try{
            server = new ServerSocket();
            server.setSoTimeout(60000);
            server.bind(socketAddress);
        }catch (IOException ex){
            logger.error("在65533处绑定服务端口失败",ex);
        }
    }

    public void accept(){
        if(server!=null){
            while(true){
                try{
                    final Socket clientMessageSocket = server.accept();
                    if(logger.isDebugEnabled()){
                        logger.debug("接收到来自"+clientMessageSocket.getInetAddress().getHostAddress()+"的请求");
                    }
                    executor.submit(new Runnable(){
                        @Override
                        public void run(){

                        }
                    });
                } catch (IOException ex){
                    logger.error("获取数据失败",ex);
                }
            }
        }
    }

    private ThreadPoolExecutor getDefaultExecutor(){
        if(logger.isDebugEnabled()){
            logger.debug("使用默认线程池处理客户端任务");
        }
        ThreadPoolExecutor executor = new ThreadPoolExecutor(50, 100, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        final AtomicInteger threadCount = new AtomicInteger(1);
        //定义线程工厂
        executor.setThreadFactory(new ThreadFactory(){
            @Override
            public Thread newThread(Runnable runnable){
                Thread thread = new Thread(runnable);
                thread.setName("handle-message-pool-thread"+threadCount.getAndAdd(1));
                return thread;
            }
        });
        //设置拒绝任务的策略为在调用线程执行任务
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }
 }