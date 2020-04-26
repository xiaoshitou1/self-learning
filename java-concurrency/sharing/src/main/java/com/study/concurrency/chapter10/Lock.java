package com.study.concurrency.chapter10;

import java.util.Collection;

/**
 * 自定义一个显示锁
 */
public interface Lock {

    class TimeOutException extends Exception {
        public TimeOutException (String message) {
            super(message);
        }
    }

    void lock() throws InterruptedException;

    void lock(long mills) throws InterruptedException, TimeOutException;

    void unlock();

    Collection<Thread> getBlockedThread();

    int getBlockedSize();
}
