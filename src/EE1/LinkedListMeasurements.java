import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class LinkedListMeasurements {

    private long[][] measurementsLinkedList = new long[MainFirstEEmodule.COUNT_LIST_TEST_METHODS][MainFirstEEmodule.NUMBER_OF_TESTS];
    private long[] resultTimersLinkedList = new long[MainFirstEEmodule.COUNT_LIST_TEST_METHODS];

    private LinkedList<Integer> linkedList = new LinkedList<>();

    public void initialisation(int size) {

        for (int i = 0; i < size; i++) {
            linkedList.add(i);
        }

        measureLinkedList();

        MainFirstEEmodule.temp = calculateLinkedListTimers();
    }

    private long[] calculateLinkedListTimers() {
        long res = measurementsLinkedList[0][0];

        for (int j = 0; j < measurementsLinkedList.length; j++) {
            for (int i = 1; i < MainFirstEEmodule.NUMBER_OF_TESTS; i++) {

                res += measurementsLinkedList[j][i];
            }
            resultTimersLinkedList[j] = res / MainFirstEEmodule.NUMBER_OF_TESTS;
        }
        return resultTimersLinkedList;
    }

    long[] getResultTimersLinkedList() {
        return resultTimersLinkedList;
    }

    private void measureLinkedList() {
        Random randomNumber = new Random();
        for (int i = 0; i < MainFirstEEmodule.NUMBER_OF_TESTS; i++) {

            int rnd = randomNumber.nextInt(linkedList.size() + 1);

            long timerAdd = System.nanoTime();
            linkedList.add(rnd);
            measurementsLinkedList[0][i] = System.nanoTime() - timerAdd;

            long timerGet = System.nanoTime();
            linkedList.get(rnd);
            measurementsLinkedList[1][i] = System.nanoTime() - timerGet;

            long timerRemove = System.nanoTime();
            linkedList.remove(rnd);
            measurementsLinkedList[2][i] = System.nanoTime() - timerRemove;

            long timerContains = System.nanoTime();
            linkedList.contains(rnd);
            measurementsLinkedList[3][i] = System.nanoTime() - timerContains;

            long timerPopulate = System.nanoTime();
            List<Integer> newLinkedList = new LinkedList<Integer>(linkedList);
            measurementsLinkedList[4][i] = System.nanoTime() - timerPopulate;

            long timerIterAdd = System.nanoTime();
            ListIterator<Integer> iterator = linkedList.listIterator();
            iterator.next();
            iterator.add(rnd);

            measurementsLinkedList[5][i] = System.nanoTime() - timerIterAdd;

            long timerIterRemove = System.nanoTime();
            iterator = linkedList.listIterator();
            iterator.next();
            iterator.remove();

            measurementsLinkedList[6][i] = System.nanoTime() - timerIterRemove;
        }
    }


}


