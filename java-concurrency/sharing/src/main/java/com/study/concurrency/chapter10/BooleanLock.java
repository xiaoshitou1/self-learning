package com.study.concurrency.chapter10;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BooleanLock implements Lock {

    // the initValue is true indicated the lock have be get.
    // the initValue is false indicated the lock is free (other thread can get this).
    private boolean initValue;
    public BooleanLock() {
        this.initValue = false;
    }
    private  Collection<Thread> blockedThreadCollection = new ArrayList<>();

    private Thread currentThread;

    @Override
    public synchronized void lock() throws InterruptedException {
        while (initValue) {
            blockedThreadCollection.add(Thread.currentThread());
            this.wait();
        }
        blockedThreadCollection.remove(Thread.currentThread());
        this.initValue = true;
        this.currentThread = Thread.currentThread();

    }

    @Override
    public synchronized void lock(long mills) throws InterruptedException, TimeOutException {
        if (mills <= 0) {
            lock();
        }
        long hasRemaining = mills;
        long endTime = System.currentTimeMillis() + mills;
        while (initValue) {
            if (hasRemaining <= 0) {
                throw new TimeOutException("Time out");
            }
            blockedThreadCollection.add(currentThread);
            this.wait(mills);
            hasRemaining = endTime - System.currentTimeMillis();
            System.out.println(Thread.currentThread() + ">> " + hasRemaining);
        }
        this.initValue = true;
        this.currentThread = Thread.currentThread();


    }

    @Override
    public synchronized void unlock() {
        if (Thread.currentThread() == currentThread) { //哪个线程获取的锁，就只能由这个线程去释放锁
            this.initValue = false;
            System.out.println(Thread.currentThread() + "release the lock monitor.");
            this.notifyAll();
        }
    }

    @Override
    public Collection<Thread> getBlockedThread() {
        return Collections.unmodifiableCollection(blockedThreadCollection); //通过这个方法拿到的集合只能读不能修改
    }

    @Override
    public int getBlockedSize() {
        return blockedThreadCollection.size();
    }
}
