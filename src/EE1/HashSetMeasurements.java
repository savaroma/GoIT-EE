import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class HashSetMeasurements {

    private long[][] measurementsHashSet = new long[MainFirstEEmodule.COUNT_SET_TEST_METHODS][MainFirstEEmodule.NUMBER_OF_TESTS];
    private long[] resultTimersHashSet = new long[MainFirstEEmodule.COUNT_SET_TEST_METHODS];

    private final Set<Integer> hashSet = new HashSet<>();

    public void initialization(int size) {
        for (int i = 0; i < size; i++) {
            hashSet.add(i);
        }

        measureHashSet();

        MainFirstEEmodule.temp = calculateHashSetTimers();
    }

    private long[] calculateHashSetTimers() {
        long res = measurementsHashSet[0][0];

        for (int j = 0; j < measurementsHashSet.length; j++) {
            for (int i = 1; i < MainFirstEEmodule.NUMBER_OF_TESTS - 1; i++) {

                res += measurementsHashSet[j][i];
            }
            resultTimersHashSet[j] = res / MainFirstEEmodule.NUMBER_OF_TESTS;
        }
        return resultTimersHashSet;
    }

    public long[] getResultTimersHashSet() {
        return resultTimersHashSet;
    }

    private void measureHashSet() {
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
            measurementsHashSet[3][i] = System.nanoTime() - timerPopulate;
        }
    }
}
