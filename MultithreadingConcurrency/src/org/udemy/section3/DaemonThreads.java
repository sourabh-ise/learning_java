package org.udemy.section3;

import java.math.BigInteger;

public class DaemonThreads {
    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadIsInterrupted.LongComputationTask(new BigInteger("20000"), new BigInteger("4")));
        thread.setDaemon(true);
        thread.start();
    }

    public static class LongComputationTask implements Runnable {
        private BigInteger base;
        private BigInteger power;

        public LongComputationTask(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            System.out.println(base + "^" + power + "=" + pow(base, power));
        }

        private BigInteger pow(BigInteger base, BigInteger power) {
            BigInteger result = BigInteger.ONE;
            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
                result = result.multiply(base);
            }
            return result;
        }
    }
}