package EE1_Collections;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

class TreeSetMeasurements {

    private static final int COUNT_SET_TEST_METHODS = 4;
    private static final int NUMBER_OF_TESTS = 10;

    private long[][] measurementsTreeSet = new long[COUNT_SET_TEST_METHODS][NUMBER_OF_TESTS];
    private long[] resultTimersTreeSet = new long[COUNT_SET_TEST_METHODS];

    private final Set<Integer> treeSet = new TreeSet<>();

    void Initialization(int size) {
        for (int i = 0; i < size; i++) {
            treeSet.add(i);
        }

        measureTreeSet();

        MainFirstEEmodule.temp = calculateTreeSetTimers();
    }


    private long[] calculateTreeSetTimers() {
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

    private void measureTreeSet() {
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
            measurementsTreeSet[3][i] = System.nanoTime() - timerPopulate;
        }

    }
}
