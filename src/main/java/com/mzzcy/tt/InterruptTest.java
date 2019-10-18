package com.mzzcy.tt;

/**
 * @author d 10/18/19
 */
public class InterruptTest {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new Worker());
        t.start();

//        Thread.sleep(200);
        Thread.interrupted();
        t.interrupt();

        System.out.println("Main IsInterrupted: " +
            Thread.currentThread().isInterrupted());
        System.out.println("Main thread stopped.");
    }

    public static class Worker implements Runnable {

        @Override
        public void run() {
            System.out.println("Worker started.");
            System.out.println("Worker IsInterrupted: " +
                Thread.currentThread().isInterrupted());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Worker IsInterrupted: " +
                    Thread.currentThread().isInterrupted());
            }

            System.out.println("Worker stopped.");
        }
    }
}
