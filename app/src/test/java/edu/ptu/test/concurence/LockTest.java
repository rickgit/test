package edu.ptu.test.concurence;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by anshu.wang on 2016/3/29.
 */
public class LockTest {
    private int a;
    private int b;
    private Object o = new Object();
    private Lock l = new ReentrantLock();

    public void testSynchronized() {
        synchronized (LockTest.this) {
            a++;
        }
    }

    /**
     * 代码模板，具体可以看官方注释Reentrent注释
     */
    public void testLock() {
        l.lock();
        try {

        } catch (Exception e) {
        } finally {
            l.unlock();
        }
        try {
            Condition condition = l.newCondition();
            a++;
            condition.await();
            b++;
            condition.signalAll();
        } catch (Exception e) {

        }
    }

    public void testObjectWait() {
        try {

            a++;
            o.wait();
            b++;
            o.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void testTimer(){
        Timer timer = new Timer(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

            }
        },0l);
    }

    /**
     * 信号量
     */
    public void testSemaphore(){
        Semaphore semaphore = new Semaphore(5);
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
