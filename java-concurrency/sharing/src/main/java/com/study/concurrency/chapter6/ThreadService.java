package com.study.concurrency.chapter6;

public class ThreadService {

    private Thread executeThread;  //执行线程
    private boolean finished = false;

    public void execute(Runnable task) {
        executeThread = new Thread() {
            @Override
            public void run() {
                Thread runner = new Thread(task); //创建一个守护线程
                System.out.println("===============");
                runner.setDaemon(true);
                runner.start();

                try {
                    runner.join(); //执行线程在这里block住了，直到守护线程执行完，才开始往下执行
                    finished = true;
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                }
            }
        };

        executeThread.start();
    }

    public void shutdown(long mills) {
        long currentTime = System.currentTimeMillis();
        while (!finished) {
            if ((System.currentTimeMillis() - currentTime) >= mills) {
                System.out.println("任务超时， 需要结束它!");
                executeThread.interrupt();
                break;
            }

            try {
                executeThread.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("执行线程被打断");
                break;
            }
        }

        finished = false;
    }
}
