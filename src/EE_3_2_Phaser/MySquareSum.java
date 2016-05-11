package EE_3_2_Phaser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MySquareSum implements SquareSum {
    @Override
    public long getSquareSum(int[] values, int numberOfThreads) {

        long result = 0;
        Phaser phaser = new Phaser(1);
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        List<Future<Long>> sum = new ArrayList<>();
        for (int i = 0; i < numberOfThreads; i++) {
            sum.add(executor.submit(new Calculating(values, numberOfThreads, phaser, i)));
        }

        int phaseNumber = phaser.getPhase() + 1;
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + phaseNumber + " ended.\n");

        phaseNumber = phaser.getPhase() + 1;
        phaser.arriveAndAwaitAdvance();
        System.out.println("Phase " + phaseNumber + " ended.\n");

        try {
            for (Future<Long> f : sum) {
                result += f.get();
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("Phase " + (++phaseNumber) + " ended.\n");
        phaser.arriveAndDeregister();

        return result;
    }
}