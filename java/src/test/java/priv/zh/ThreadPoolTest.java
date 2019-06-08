package priv.zh;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolTest {


    @Test
    public void threadPoolExecutor(){
    }



    @Test
    public void threadWaitAndNotify() {
        final List<Integer> resource = new ArrayList<>();

        //生产者线程
        Thread producterThread = new Thread(() -> {
            try{
                synchronized (resource){
                    while(true){
                        if(resource.size()==5){
                            resource.wait();
                        }
                        resource.addAll(Arrays.asList(new Integer[]{1,2,3,4,5}));
                        //System.out.println(Thread.currentThread().getName()+"put data success");
                        resource.notify();

                    }

                 }
            }catch (InterruptedException ex){
                System.out.println("get interrupt message,producter thread exit");
            }
        });
        //消费者线程
        Thread consumerThread = new Thread(() -> {
            try{
                synchronized (resource){
                    while(true){
                        if(resource.size()==0){
                            resource.wait();
                        }
                        //System.out.println(Thread.currentThread().getName()+"get data success :"+resource);
                        resource.clear();
                        resource.notify();
                    }
                }
            }catch (InterruptedException ex){
                System.out.println("get interrupt message,consumer thread exit");
            }
        });
        producterThread.setName("producter");
        consumerThread.setName("consumer");
        producterThread.start();
        consumerThread.start();
        try{
            Thread.sleep(10);
        }catch (InterruptedException ex){
            System.out.println("main thread sleep");
            producterThread.interrupt();
            consumerThread.interrupt();
        }
    }

    @Test
    public void threadSleepAndNotify(){

    }
}
