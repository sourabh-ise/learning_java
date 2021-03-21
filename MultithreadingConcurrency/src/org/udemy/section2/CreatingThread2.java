package org.udemy.section2;

public class CreatingThread2 {
    public static void main(String[] args) {
        Thread thread = new NewThread();
        thread.start();
    }

    private static class NewThread extends Thread{
        NewThread(){
            this.setName(this.getClass().getSimpleName());
        }
        @Override
        public void run() {
            System.out.println("Hello from "+this.getName());
        }
    }
}
