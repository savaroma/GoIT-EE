package module1;

public class MainFirstEEmodule {
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

        linkedListMeasurements.Initialisation(NUM10K);
        long[] resTemp10k = linkedListMeasurements.getResultTimersLinkedList();
        linkedListMeasurements.Initialisation(NUM100K);
        long[] resTemp100k = linkedListMeasurements.getResultTimersLinkedList();
        linkedListMeasurements.Initialisation(NUM1000K);
        long[] resTemp1000k = linkedListMeasurements.getResultTimersLinkedList();

        for (int i = 0; i < resLinked.length; i++) {
            resLinked[i] = (resTemp10k[i] + resTemp100k[i] + resTemp1000k[i]) / 3;
        }

        arrayListMeasurements.Initialisation(NUM10K);
        resTemp10k = arrayListMeasurements.getResultTimersArrayList();
        arrayListMeasurements.Initialisation(NUM100K);
        resTemp100k = arrayListMeasurements.getResultTimersArrayList();
        arrayListMeasurements.Initialisation(NUM1000K);
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
        hashSetMeasurements.Initialization(NUM10K);
        resTemp10k = hashSetMeasurements.getResultTimersHashSet();
        hashSetMeasurements.Initialization(NUM100K);
        resTemp100k = hashSetMeasurements.getResultTimersHashSet();
        hashSetMeasurements.Initialization(NUM1000K);
        resTemp1000k = hashSetMeasurements.getResultTimersHashSet();

        for (int i = 0; i < resHash.length; i++) {
            resHash[i] = (resTemp10k[i] + resTemp100k[i] + resTemp1000k[i]) / 3;
        }

        Print.printToConsole(resArray, resLinked, resTree, resHash);
        Print.printToFile(resArray,resLinked,resTree,resHash);
    }


}
