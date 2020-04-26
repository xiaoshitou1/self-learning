package com.study.concurrency.chapter6;

/**
 * 强制结束线程生命周期
 */
public class ThreadCloseForce {

    public static void main(String[] args) {

         ThreadService service = new ThreadService();
         long start = System.currentTimeMillis();
         service.execute(() -> {
             //load a very heavy resource.
//             while (true) {
//
//             }

             try {
                 System.out.println("-----------------");
                 Thread.sleep(5000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         });
         service.shutdown(10000);
         long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
