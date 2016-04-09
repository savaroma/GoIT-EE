import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class ArrayListMeasurements {

    private long[][] measurementsArrayList = new long[MainFirstEEmodule.COUNT_LIST_TEST_METHODS][MainFirstEEmodule.NUMBER_OF_TESTS];
    private long[] resultTimersArrayList = new long[MainFirstEEmodule.COUNT_LIST_TEST_METHODS];

    //ѕо логике не очень выходит, что ты константы объ€вл€ешь в мейне, а потом используешь их в других классах.  ласс с
    //методом мейн - это считай клиентска€ сторона. ¬се измен€ющиес€ данные должны в твое приложение приходить параметрами.
    //» задаватьс€ клиентом. —ейчас он хочет на такое количество тестов, потом на другое. ¬ этом случае константа - не очень
    //подходит. ћен€ть уже не надо, но учти на будущее. ¬се, что должно происходить в мейне - это создание инстансов твоего приложени€,
    //вызовы их методов и передачи в эти методы какие-то параметры. Ћогики там не должно быть. » констант дл€ использовани€
    //в приложении тем более. ѕредставь, что ты всегда можешь переписать мейн, что-то в нем изменить, а приложении при этом трогать
    //не надо.


    private ArrayList<Integer> arrayList = new ArrayList<>();

    public void initialisation(int size) {

        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }

        measureArrayList();

        MainFirstEEmodule.temp = calculateArrayListTimers();
    }

    private long[] calculateArrayListTimers() {
        long res = measurementsArrayList[0][0];

        for (int j = 0; j < measurementsArrayList.length; j++) {
            for (int i = 1; i < MainFirstEEmodule.NUMBER_OF_TESTS - 1; i++) {

                res += measurementsArrayList[j][i];
            }
            resultTimersArrayList[j] = res / MainFirstEEmodule.NUMBER_OF_TESTS;
        }
        return resultTimersArrayList;
    }

    public long[] getResultTimersArrayList() {
        return resultTimersArrayList;
    }

    private void measureArrayList() {
        Random randomNumber = new Random();
        for (int i = 0; i < MainFirstEEmodule.NUMBER_OF_TESTS; i++) {

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
