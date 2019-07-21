package priv.zh;

import org.junit.Test;
import priv.zh.model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class QueueTest {

    @Test
    public void arrayBlockingQueue() {
        try {
            final BlockingQueue<Student> studentsArrayBlockingQueue = new ArrayBlockingQueue<>(8);
            new Thread(() -> {
                for (int i = 0; i <= 10; i++) {
                    studentsArrayBlockingQueue.offer(new Student("" + i, "赵恒" + i, "男", "2" + i));
                }

            }).start();
            new Thread(() -> {
                Collection<Student> list = new ArrayList<>();
                try {
                    Thread.sleep(5000);
                    studentsArrayBlockingQueue.drainTo(list, 2);
                    System.out.println(studentsArrayBlockingQueue.toString());
                } catch (InterruptedException ex) {

                }
            }).start();
            Thread.sleep(10000);

            System.out.println(studentsArrayBlockingQueue.toString());
            System.out.println(studentsArrayBlockingQueue.size());
            System.out.println(studentsArrayBlockingQueue.remainingCapacity());

        } catch (InterruptedException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Test
    public void synchronisionQueue() {
        final BlockingQueue<Student> synchronisionBlockQueue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                for (int i = 0; i <= 9; i++) {
                    System.out.println("生产者放入:" + "赵恒" + i);
                    synchronisionBlockQueue.offer(new Student("" + i, "赵恒" + i, "i", ""), 5, TimeUnit.SECONDS);

                    Thread.sleep(2000);
                }

            } catch (InterruptedException ex) {
                ex.getStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i <= 9; i++) {
                    System.out.println("消费者获取到:" + synchronisionBlockQueue.take());
                }
            } catch (InterruptedException ex) {
                ex.getStackTrace();
            }
        }).start();
    }
}