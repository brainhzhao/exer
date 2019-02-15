package priv.zh.thread.lockdemo;

import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo{
    private class Point{
        // define coordinate x,y
        private double x,y;
        private final StampedLock sl=new StampedLock();
        

    }
}