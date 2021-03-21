package org.udemy.section3;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        List<Long> inputNumber = Arrays.asList(0L, 3435L, 2324L, 4656L, 23L, 2435L, 5566L,1000000L);
        List<FactorialThread> factorialThreads = new ArrayList<>();
        inputNumber.forEach(x->factorialThreads.add(new FactorialThread(x)));
        for (FactorialThread thread : factorialThreads) {
            thread.setDaemon(true); // find a good solution //TODO
            thread.start();
        }
        for(Thread thread:factorialThreads){
            thread.join(2000); //max duration for a calculation, optional argument else the thread will be waiting for completion
        }
        for(int i=0;i<inputNumber.size();i++){
            FactorialThread  thread = factorialThreads.get(i);
            if(thread.isFinished()){
                System.out.println("Factorial of "+inputNumber.get(i)+" is "+thread.getResult());
            }
        }
    }

    private static class FactorialThread extends Thread {
        private long inputNumber;
        private boolean isFinished = false;
        private BigInteger result = BigInteger.ZERO;

        public FactorialThread(long inputNumber) {
            this.inputNumber = inputNumber;
        }

        @Override
        public void run() {
            this.result = factorial(inputNumber);
            this.isFinished = true;
        }

        private BigInteger factorial(long n) {
            BigInteger tmpResult = BigInteger.ONE;
            for (long i = n; i > 0; i--) {
                tmpResult = tmpResult.multiply(new BigInteger(Long.toString(n)));
            }
            return tmpResult;
        }

        public boolean isFinished() {
            return isFinished;
        }

        public BigInteger getResult() {
            return result;
        }
    }
}
