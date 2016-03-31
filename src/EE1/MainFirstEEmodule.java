public class MainFirstEEmodule {
    static final int COUNT_LIST_TEST_METHODS = 7;
    static final int COUNT_SET_TEST_METHODS = 4;
    static final int NUMBER_OF_TESTS = 10;

    private static final int NUM10K = 10000;
    private static final int NUM100K = 100000;
    private static final int NUM1000K = 1000000;


    static long[] temp = new long[7];

    public static void main(String[] args) {
        long[] resArray = new long[7];
        long[] resLinked = new long[7];
        long[] resTree = new long[4];
        long[] resHash = new long[4];

        LinkedListMeasurements linkedListMeasurements = new LinkedListMeasurements();
        ArrayListMeasurements arrayListMeasurements = new ArrayListMeasurements();
        TreeSetMeasurements treeSetMeasurements = new TreeSetMeasurements();
        HashSetMeasurements hashSetMeasurements = new HashSetMeasurements();

        linkedListMeasurements.initialisation(NUM10K);
        long[] resTemp10k = linkedListMeasurements.getResultTimersLinkedList();
        linkedListMeasurements.initialisation(NUM100K);
        long[] resTemp100k = linkedListMeasurements.getResultTimersLinkedList();
        linkedListMeasurements.initialisation(NUM1000K);
        long[] resTemp1000k = linkedListMeasurements.getResultTimersLinkedList();

        for (int i = 0; i < resLinked.length; i++) {
            resLinked[i] = (resTemp10k[i] + resTemp100k[i] + resTemp1000k[i]) / 3;
        }

        arrayListMeasurements.initialisation(NUM10K);
        resTemp10k = arrayListMeasurements.getResultTimersArrayList();
        arrayListMeasurements.initialisation(NUM100K);
        resTemp100k = arrayListMeasurements.getResultTimersArrayList();
        arrayListMeasurements.initialisation(NUM1000K);
        resTemp1000k = arrayListMeasurements.getResultTimersArrayList();

        for (int i = 0; i < resArray.length; i++) {
            resArray[i] = (resTemp10k[i] + resTemp100k[i] + resTemp1000k[i]) / 3;
        }
        treeSetMeasurements.Initialization(NUM10K);
        resTemp10k = treeSetMeasurements.getResultTimersTreeSet();
        treeSetMeasurements.Initialization(NUM100K);
        resTemp100k = treeSetMeasurements.getResultTimersTreeSet();
        treeSetMeasurements.Initialization(NUM1000K);
        resTemp1000k = treeSetMeasurements.getResultTimersTreeSet();

        for (int i = 0; i < resTree.length; i++) {
            resTree[i] = (resTemp10k[i] + resTemp100k[i] + resTemp1000k[i]) / 3;
        }
        hashSetMeasurements.initialization(NUM10K);
        resTemp10k = hashSetMeasurements.getResultTimersHashSet();
        hashSetMeasurements.initialization(NUM100K);
        resTemp100k = hashSetMeasurements.getResultTimersHashSet();
        hashSetMeasurements.initialization(NUM1000K);
        resTemp1000k = hashSetMeasurements.getResultTimersHashSet();

        for (int i = 0; i < resHash.length; i++) {
            resHash[i] = (resTemp10k[i] + resTemp100k[i] + resTemp1000k[i]) / 3;
        }

        Print.printToConsole(resArray, resLinked, resTree, resHash);
        Print.printToFile(resArray,resLinked,resTree,resHash);
    }


}
