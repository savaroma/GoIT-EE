package EE_3_2_Phaser;

import java.util.concurrent.Callable;
import java.util.concurrent.Phaser;

import java.util.concurrent.Callable;
import java.util.concurrent.Phaser;

public class Calculating implements Callable<Long> {
    private int[] values;
    private int numberOfThreads;
    private int arrayParty;
    Phaser phaser;

    public Calculating(int[] values, int numberOfThreads, Phaser phaser, int arrayParty) {
        this.values = values;
        this.numberOfThreads = numberOfThreads;
        this.phaser = phaser;
        this.arrayParty = arrayParty;
        phaser.register();
    }

    @Override
    public Long call() throws Exception {
        String threadName = Thread.currentThread().getName();
        System.out.println("Thread " + threadName + " started");
        phaser.arriveAndAwaitAdvance();
        Thread.sleep(500);

        long squareSum = computeSquares();
        System.out.println("Thread " + threadName + " waiting.");
        phaser.arriveAndAwaitAdvance();
        Thread.sleep(500);

        System.out.println("Thread " + threadName + " return " + squareSum + " value.");
        phaser.arriveAndDeregister();
        return squareSum;
    }

    public long computeSquares() {
        long squaresSum = 0;
        int firstIndex = arrayParty * (values.length / numberOfThreads);

        int lastIndex;
        boolean isTheLastParty = arrayParty + 1 == numberOfThreads;
        if (isTheLastParty) {
            lastIndex = values.length;
        } else {
            lastIndex = firstIndex + (values.length / numberOfThreads);
        }

        while (firstIndex < lastIndex) {
            squaresSum += Math.pow(values[firstIndex], 2);
            firstIndex++;
        }
        return squaresSum;
    }
}