package org.udemy.section2;

public class CreatingThread1 {
    public static void main(String[] args) throws InterruptedException {

        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("this is from custom thread " + Thread.currentThread().getName());
                throw new RuntimeException("Intentional error");

            }
        });
        myThread.setName("WorkerThread");
        myThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable throwable) {
                System.out.println("Error occured on " + thread.getName() + " error message " + throwable.getMessage());
            }
        });

        myThread.start();


        Thread threadLambda = new Thread(() -> System.out.println("This is from Lambda thread " + Thread.currentThread().getName()));
        threadLambda.setName("threadLambda");
        threadLambda.setUncaughtExceptionHandler((thread, exception) ->
                System.out.println("Error occured on " + thread.getName() + " error message " + exception.getMessage()));
        threadLambda.start();
    }
}
