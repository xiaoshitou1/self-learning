package com.study.concurrency.chapter10;

/**
 * 给应用程序输入钩子程序，好处是在程序出现异常，或者使用kill命令(不包括kill -9 这个命令)
 * 杀掉程序时，都会执行钩子程序用于释放一些连接等资源
 *
 * 【 kill - 9 表示强制杀死该进程；与SIGTERM相比，这个信号不能被捕获或忽略，
 * 同时接收这个信号的进程在收到这个信号时不能执行任何清理。】
 */
public class ExitCapture {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("The application will be exit.");
            notifyAndRelease();
        }));
        int i = 0;
        while (true) {
            try {
                Thread.sleep(1_000L);
                System.out.println("I am working...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
            if (i > 20) {
                throw new RuntimeException("error");
            }
        }



    }

    private static void notifyAndRelease() {
        System.out.println("notify to the admin");
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {

        }
        System.out.println("will release resource(socket,file,connection.)");
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {

        }
    }

}
