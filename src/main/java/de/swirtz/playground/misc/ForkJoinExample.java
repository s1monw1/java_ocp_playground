package de.swirtz.playground.misc;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ThreadLocalRandom;

public class ForkJoinExample {

    public static void main(String[] args) {
        ForkJoinPool fjPool = new ForkJoinPool();
        int arraySize = 100_000_000;
        int[] data = new int[arraySize];
        System.out.println("(1) Invoking ForkJoinTask with " + Runtime.getRuntime().availableProcessors() +
                " available Processors.\n Going to initialize array of length " + arraySize + " with random integers");
        long startTime = System.currentTimeMillis();
        fjPool.invoke(new MyForkJoinTask(data, 0, data.length));
        long endTime = System.currentTimeMillis();
        System.out.println("Duration: " + (endTime - startTime) + " ms");
        System.out.println("Random at start: " + data[0]);
        System.out.println("Random at end: " + data[arraySize - 1]);

//        System.out.println("(2) Going to initialize array of length " + arraySize + " with random integers.");
//
//        //Sequential
//        int [] data2 = new int[arraySize];
//        startTime = System.currentTimeMillis();
//        for(int i = 0; i<data2.length; i++){
//            data2[i] = ThreadLocalRandom.current().nextInt();
//        }
//        endTime = System.currentTimeMillis();
//        System.out.println("Duration: " + (endTime - startTime) + " ms");
//        System.out.println("Random at start: " + data2[0]);
//        System.out.println("Random at end: " + data2[arraySize - 1]);

    }

    static class MyForkJoinTask extends RecursiveAction {
        private static final int THRESHOLD = 10_000;
        private int[] data;
        private int start, end;

        public MyForkJoinTask(int[] data, int start, int end) {
            this.data = data;
            this.start = start;
            this.end = end;
        }

        protected void compute() {
            if (end - start <= THRESHOLD) {
                for (int i = start; i < end; i++) {
                    data[i] = ThreadLocalRandom.current().nextInt();
                }
            } else {
                int halfway = ((end - start) / 2) + start;
                MyForkJoinTask t1 = new MyForkJoinTask(data, start, halfway);
                t1.fork();
                MyForkJoinTask t2 = new MyForkJoinTask(data, halfway, end);
                t2.compute();
                t1.join();
            }
        }
    }


}
