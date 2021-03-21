package org.udemy.section3;

public class ThreadInterrupt {
    public static void main(String[] args) {
        Thread t= new Thread(new BlockingTask());
        t.start();
        t.interrupt();
    }

    public static class BlockingTask implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Exiting blocking thread");
            }
        }
    }
}
