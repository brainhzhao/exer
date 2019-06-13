package priv.zh;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ThreadFactory;
import org.junit.Test;

import priv.zh.net.tcp.server.AcceptMessageServer;

/**
 * accept message from client 
 * @author zhaoheng
 * @version 20190610
 */

 public class HandleMessageTest{

    @Test
    public void connectServer(){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(50, 100, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        final AtomicInteger threadCount = new AtomicInteger(1);
        executor.setThreadFactory(new ThreadFactory(){
            @Override
            public Thread newThread(Runnable runnable){
                Thread thread = new Thread(runnable);
                thread.setName("handle-message-pool thread"+threadCount.getAndAdd(1));
                return thread;
            }
        });
        AcceptMessageServer server = new AcceptMessageServer(executor, "", 65533);
        

    }
 }