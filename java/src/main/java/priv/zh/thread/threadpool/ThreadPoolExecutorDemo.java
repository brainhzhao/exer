package priv.zh.thread.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {
    private static int count;
    private static int taskId;

    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 1);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 1, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(20));
        executor.setThreadFactory((Runnable runnable) -> {
            Thread thread = new Thread(runnable);
            thread.setName("thread pool ->thread_" + String.format("%03d", ++count));
            return thread;
        });
        executor.prestartAllCoreThreads();
        // executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        createThread(executor, threadLocal, 100);

        Thread daemonThread = new Thread(() -> {
            boolean isInterrupt = true;

            while (isInterrupt) {
                if (executor.getActiveCount() == 0) {
                    System.out.println("线程执行结束,重新提交新任务去执行");
                    createThread(executor, threadLocal, 20);
                    if (taskId >= 299) {
                        executor.shutdown();
                    }
                }
                System.out.print("current activity thread is " + executor.getActiveCount());
                System.out.println(",current thread pool queue size is " + executor.getQueue().size());
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException ex) {
                    ex.getStackTrace();
                }
            }

        });
        daemonThread.setDaemon(true);
        daemonThread.setName("daemon");
        daemonThread.start();
        System.out.println(Thread.currentThread().isDaemon());
    }

    private static void createThread(ThreadPoolExecutor executor, ThreadLocal<Integer> threadLocal, int count) {
        for (int i = 0; i < count; i++) {
            executor.submit(() -> {
                threadLocal.set(threadLocal.get() + 1);
                System.out.println("handle thread is " + Thread.currentThread().getName() + ", handle request is task"
                        + (++taskId));
                // System.out.println("thread local variable is " + threadLocal.get());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.out.println(ex.getMessage());
                }
                // System.out.println("shutdown this thread "+Thread.currentThread().getName());
            });
        }
    }
}