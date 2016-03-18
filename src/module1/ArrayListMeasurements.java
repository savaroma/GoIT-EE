package module1;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

class ArrayListMeasurements extends MainFirstEEmodule {

    private long[][] measurementsArrayList = new long[7][NUMBER_OF_TESTS];
    private long[] resultTimersArrayList = new long[7];

    private ArrayList<Integer> arrayList = new ArrayList<>();

    void Initialisation(int size) {

        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }

        MeasurementsArrayList();

        temp = CalculateArrayListTimers();
    }

    private long[] CalculateArrayListTimers() {
        long res = measurementsArrayList[0][0];

        for (int j = 0; j < measurementsArrayList.length; j++) {
            for (int i = 1; i < NUMBER_OF_TESTS - 1; i++) {

                res += measurementsArrayList[j][i];
            }
            resultTimersArrayList[j] = res / NUMBER_OF_TESTS;
        }
        return resultTimersArrayList;
    }

    long[] getResultTimersArrayList() {
        return resultTimersArrayList;
    }

    private void MeasurementsArrayList() {
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
            List<Integer> newArrayList = new ArrayList<Integer>(arrayList);
            measurementsArrayList[4][i] = System.nanoTime() - timerPopulate;

            long timerIterAdd = System.nanoTime();
            ListIterator iterator = arrayList.listIterator();
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
