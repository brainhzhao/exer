package priv.zh;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

    private int count;
    private int taskId;

    @Before
    public void runBefore() {

    }

    @Test
    public void threadPoolExecutor() {
    }

    @Test
    public void threadWaitAndNotify() {
        final List<Integer> resource = new ArrayList<>();

        // 生产者线程
        Thread producterThread = new Thread(() -> {
            try {
                synchronized (resource) {
                    while (true) {
                        if (resource.size() == 5) {
                            resource.wait();
                        }
                        resource.addAll(Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 }));
                        // System.out.println(Thread.currentThread().getName()+"put data success");
                        resource.notify();

                    }

                }
            } catch (InterruptedException ex) {
                System.out.println("get interrupt message,producter thread exit");
            }
        });
        // 消费者线程
        Thread consumerThread = new Thread(() -> {
            try {
                synchronized (resource) {
                    while (true) {
                        if (resource.size() == 0) {
                            resource.wait();
                        }
                        // System.out.println(Thread.currentThread().getName()+"get data success
                        // :"+resource);
                        resource.clear();
                        resource.notify();
                    }
                }
            } catch (InterruptedException ex) {
                System.out.println("get interrupt message,consumer thread exit");
            }
        });
        producterThread.setName("producter");
        consumerThread.setName("consumer");
        producterThread.start();
        consumerThread.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            System.out.println("main thread sleep");
            producterThread.interrupt();
            consumerThread.interrupt();
        }
    }

    @Test
    public void threadSleepAndNotify() {
        System.out.println("Hello World");
    }

    @Test
    public void threadPoolExecutorTest() {
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        try {
            for (int i = 0; i < 10; i++) {
                executorService.submit(() -> {
                    System.out.println("current thread is " + Thread.currentThread().getName());
                });
            }
        } catch (Exception ex) {

        }
    }

    @Test
    public void customerExecutor() {
        new Thread(()->{
            ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
                public Integer initialValue() {
                    return 1;
                }
            };
            ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 1, TimeUnit.MILLISECONDS,
                    new ArrayBlockingQueue<>(100));
            executor.setThreadFactory((Runnable runnable) -> {
                Thread thread = new Thread(runnable);
                thread.setName("thread pool ->thread_" + String.format("%03d", ++count));
                return thread;
            });
            executor.setRejectedExecutionHandler((Runnable r, ThreadPoolExecutor threadPoolExecutor) -> {
                System.out.println("reject handle");
            });
            try {
                for (int i = 0; i < 100; i++) {
                    executor.submit(() -> {
                        threadLocal.set(threadLocal.get() + 1);
                        System.out.println("handle thread is " + Thread.currentThread().getName()
                                + ", handle request is task" + (++taskId));
                        System.out.println("thread local variable is " + threadLocal.get());
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            System.out.println(ex.getMessage());
                        }
                        System.out.println("shutdown this thread "+Thread.currentThread().getName());
                    });
                }
            } catch (NullPointerException ex) {
                System.out.println(ex.getMessage());
            }

            Thread daemonThread = new Thread(() -> {
                boolean isInterrupt = true;

                while (isInterrupt) {
                    System.out.println("current activity thread is " + executor.getActiveCount());
                    System.out.println("current thread pool queue size is " + executor.getQueue().size());
                    // Thread.sleep(100);
                }

            });
            daemonThread.setDaemon(true);
            daemonThread.setName("daemon");
            daemonThread.start();
        }).start();
    }

    @Test
    public void threadGroupTest() throws Exception {
        ThreadGroup threadGroup = new ThreadGroup("NewThreadGroup");
        ThreadLocal<Integer> threadLocalVariable = new ThreadLocal<Integer>() {
            @Override
            public Integer initialValue() {
                return 1;
            }
        };
        for (int i = 0; i < 10; i++) {
            new Thread(threadGroup, () -> {
                threadLocalVariable.set((threadLocalVariable.get() + 1));
                System.out.println("current Thread is " + Thread.currentThread().getName() + ",threadLocalVariable is "
                        + threadLocalVariable.get());
                System.out.println("current thread is " + (++this.count) + ",current threadgroup is "
                        + Thread.currentThread().getThreadGroup().getName() + ",parent threadgroup is "
                        + Thread.currentThread().getThreadGroup().getParent().getName() + ",grandparent group is "
                        + Thread.currentThread().getThreadGroup().getParent().getParent().getName()
                        + ",thread is deamon " + Thread.currentThread().isDaemon());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("发生中断，程序退出");
                }
            }).start();
        }
    }
}