package EE1_Collections;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class ArrayListMeasurements {

    private static final int COUNT_LIST_TEST_METHODS = 7;
    private static final int NUMBER_OF_TESTS = 10;

    private long[][] measurementsArrayList = new long[COUNT_LIST_TEST_METHODS][NUMBER_OF_TESTS];
    private long[] resultTimersArrayList = new long[COUNT_LIST_TEST_METHODS];

    private ArrayList<Integer> arrayList = new ArrayList<>();

    void initialisation(int size) {

        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }

        measureArrayList();

        MainFirstEEmodule.temp = calculateArrayListTimers();
    }

    private long[] calculateArrayListTimers() {
        long res = measurementsArrayList[0][0];

        for (int j = 0; j < measurementsArrayList.length; j++) {
            for (int i = 1; i < NUMBER_OF_TESTS - 1; i++) {

                res += measurementsArrayList[j][i];
            }
            resultTimersArrayList[j] = res / NUMBER_OF_TESTS;
        }
        return resultTimersArrayList;
    }

    public long[] getResultTimersArrayList() {
        return resultTimersArrayList;
    }

    private void measureArrayList() {
        Random randomNumber = new Random();
        for (int i = 0; i < NUMBER_OF_TESTS; i++) {

            int rnd = randomNumber.nextInt(arrayList.size() + 1);

            long timerAdd = System.nanoTime();
            arrayList.add(rnd);
            measurementsArrayList[0][i] = System.nanoTime() - timerAdd;

            long timerGet = System.nanoTime();
            arrayList.get(rnd);
            measurementsArrayList[1][i] = System.nanoTime() - timerGet;

            long timerRemove = System.nanoTime();
            arrayList.remove(rnd);
            measurementsArrayList[2][i] = System.nanoTime() - timerRemove;

            long timerContains = System.nanoTime();
            arrayList.contains(rnd);
            measurementsArrayList[3][i] = System.nanoTime() - timerContains;

            long timerPopulate = System.nanoTime();
            measurementsArrayList[4][i] = System.nanoTime() - timerPopulate;

            long timerIterAdd = System.nanoTime();
            ListIterator<Integer> iterator = arrayList.listIterator();
            iterator.next();
            iterator.add(rnd);

            measurementsArrayList[5][i] = System.nanoTime() - timerIterAdd;

            long timerIterRemove = System.nanoTime();
            ListIterator iter = arrayList.listIterator();
            iter.next();
            iter.remove();

            measurementsArrayList[6][i] = System.nanoTime() - timerIterRemove;
        }
    }

}
