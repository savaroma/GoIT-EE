package module1;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class HashSetMeasurements extends MainFirstEEmodule {

    private long[][] measurementsHashSet = new long[4][MainFirstEEmodule.NUMBER_OF_TESTS];
    private long[] resultTimersHashSet = new long[4];

    private final Set<Integer> hashSet = new HashSet<>();

    void Initialization(int size) {
        for (int i = 0; i < size; i++) {
            hashSet.add(i);
        }

        MeasurementsHashSet();

        MainFirstEEmodule.temp = CalculateHashSetTimers();
    }

    private long[] CalculateHashSetTimers() {
        long res = measurementsHashSet[0][0];

        for (int j = 0; j < measurementsHashSet.length; j++) {
            for (int i = 1; i < MainFirstEEmodule.NUMBER_OF_TESTS - 1; i++) {

                res += measurementsHashSet[j][i];
            }
            resultTimersHashSet[j] = res / MainFirstEEmodule.NUMBER_OF_TESTS;
        }
        return resultTimersHashSet;
    }

    long[] getResultTimersHashSet() {
        return resultTimersHashSet;
    }

    private void MeasurementsHashSet() {
        Random randomNumber = new Random();
        for (int i = 0; i < MainFirstEEmodule.NUMBER_OF_TESTS; i++) {

            int rnd = randomNumber.nextInt(hashSet.size() + 1);

            long timerAdd = System.nanoTime();
            hashSet.add(rnd);
            measurementsHashSet[0][i] = System.nanoTime() - timerAdd;

            long timerRemove = System.nanoTime();
            hashSet.remove(rnd);
            measurementsHashSet[1][i] = System.nanoTime() - timerRemove;

            long timerContains = System.nanoTime();
            hashSet.contains(rnd);
            measurementsHashSet[2][i] = System.nanoTime() - timerContains;

            hashSet.clear();
            long timerPopulate = System.nanoTime();
            Set<Integer> newHashSet = new HashSet<>(hashSet);
            measurementsHashSet[3][i] = System.nanoTime() - timerPopulate;
        }
    }
}
