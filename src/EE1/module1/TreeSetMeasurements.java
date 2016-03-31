package module1;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetMeasurements extends MainFirstEEmodule {

    private long[][] measurementsTreeSet = new long[4][NUMBER_OF_TESTS];
    private long[] resultTimersTreeSet = new long[4];

    private final Set<Integer> treeSet = new TreeSet<>();

    void Initialization(int size) {
        for (int i = 0; i < size; i++) {
            treeSet.add(i);
        }

        MeasurementsTreeSet();

        temp = CalculateTreeSetTimers();
    }

    private long[] CalculateTreeSetTimers() {
        long res = measurementsTreeSet[0][0];

        for (int j = 0; j < measurementsTreeSet.length; j++) {
            for (int i = 1; i < NUMBER_OF_TESTS - 1; i++) {

                res += measurementsTreeSet[j][i];
            }
            resultTimersTreeSet[j] = res / NUMBER_OF_TESTS;
        }
        return resultTimersTreeSet;
    }

    long[] getResultTimersTreeSet() {
        return resultTimersTreeSet;
    }

    private void MeasurementsTreeSet() {
        Random randomNumber = new Random();
        for (int i = 0; i < NUMBER_OF_TESTS; i++) {

            int rnd = randomNumber.nextInt(treeSet.size() + 1);

            long timerAdd = System.nanoTime();
            treeSet.add(rnd);
            measurementsTreeSet[0][i] = System.nanoTime() - timerAdd;

            long timerRemove = System.nanoTime();
            treeSet.remove(rnd);
            measurementsTreeSet[1][i] = System.nanoTime() - timerRemove;

            long timerContains = System.nanoTime();
            treeSet.contains(rnd);
            measurementsTreeSet[2][i] = System.nanoTime() - timerContains;

            treeSet.clear();
            long timerPopulate = System.nanoTime();
            Set<Integer> newTreeSet = new TreeSet<>(treeSet);
            measurementsTreeSet[3][i] = System.nanoTime() - timerPopulate;
        }

    }
}
