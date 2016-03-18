package module1;

public class MainFirstEEmodule {
    protected static final int NUMBER_OF_TESTS = 10;
    protected static final int NUM10K = 10000;
    protected static final int NUM100K = 100000;
    protected static final int NUM1000K = 1000000;
    protected static long[] temp = new long[7];

    public static void main(String[] args) {
        LinkedListMeasurements linkedListMeasurements = new LinkedListMeasurements();
        ArrayListMeasurements arrayListMeasurements = new ArrayListMeasurements();

        linkedListMeasurements.Initialisation(NUM10K);
        arrayListMeasurements.Initialisation(NUM10K);
        long[] resArray = arrayListMeasurements.getResultTimersArrayList();
        long[] resLinked = linkedListMeasurements.getResultTimersLinkedList();
        Print.print(NUM10K, resArray, resLinked);

        linkedListMeasurements.Initialisation(NUM100K);
        arrayListMeasurements.Initialisation(NUM100K);
        resArray = arrayListMeasurements.getResultTimersArrayList();
        resLinked = linkedListMeasurements.getResultTimersLinkedList();
        Print.print(NUM100K, resArray, resLinked);
    }


}
