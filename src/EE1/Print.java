import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;

public class Print {
    static private String strip = "+-----------------------------------------------------------------------------------------------+";

    static void printToConsole(long[] arrayList, long[] linkedList, long[] treeSet, long[] hashSet) {
        System.out.println(strip);
        Print.printHead();
        System.out.println(strip);
        Print.printArrayList("ArrayList", arrayList);
        Print.printLinkedList("LinkedList", linkedList);
        Print.printSet("TreeSet", treeSet);
        Print.printSet("HashSet", hashSet);
        System.out.println(strip);

    }

    static void printToFile(long[] arrayList, long[] linkedList, long[] treeSet, long[] hashSet) {

        try (Writer writer = new BufferedWriter(new FileWriter("result.txt", true))) {

            writer.write(strip + "\n");
            writer.write("|\t\t\t\t" + "add" + "\t\t" + "get" + "\t\t\t" + "remove" + "\t\t" +
                    "contains" + "\t" + "populate" + "\t" + "iter.add" + "\t" + "iter.remove" + " | \n");
            writer.write(strip + "\n");

            writer.write("| " + "ArrayList" + ":\t" + arrayList[0] / 1000 + "\t\t" + arrayList[1] / 1000 + "\t\t\t"
                    + arrayList[2] / 1000 + "\t\t\t" + arrayList[3] / 1000 + "\t\t" + arrayList[4] / 1000 + "\t\t"
                    + arrayList[5] / 1000 + "\t\t" + arrayList[6] / 1000 + "\t\t| \n");

            writer.write("| " + "LinkedList" + ":\t" + linkedList[0] / 1000 + "\t\t" + linkedList[1] / 1000 + "\t\t"
                    + linkedList[2] / 1000 + "\t\t" + linkedList[3] / 1000 + "\t\t" + linkedList[4] / 1000 + "\t\t"
                    + linkedList[5] / 1000 + "\t\t" + linkedList[6] / 1000 + "\t\t| \n");

            writer.write("| " + "TreeSet" + ":\t\t" + treeSet[0] / 1000 + "\t\t\t\t\t" + treeSet[1] / 1000 + "\t\t\t"
                    + treeSet[2] / 1000 + "\t\t\t" + treeSet[3] / 1000 + "\t\t\t\t\t\t\t\t\t" + "| \n");

            writer.write("| " + "HashSet" + ":\t\t" + hashSet[0] / 1000 + "\t\t\t\t\t" + hashSet[1] / 1000 + "\t\t\t"
                    + hashSet[2] / 1000 + "\t\t\t" + hashSet[3] / 1000 + "\t\t\t\t\t\t\t\t\t" + "| \n");

            writer.write(strip + "\n");

        } catch (Exception ex) {
            System.out.println("Error saving data to file Result.txt");
        }
    }


    private static void printHead() {
        System.out.println("|\t\t\t\t" + "add" + "\t\t" + "get" + "\t\t\t" + "remove" + "\t\t" +
                "contains" + "\t" + "populate" + "\t" + "iter.add" + "\t" + "iter.remove" + " |");
    }

    private static void printArrayList(String name, long[] result) {
        System.out.print("| " + name + ":\t" + result[0] / 1000 + "\t\t" + result[1] / 1000 + "\t\t\t"
                + result[2] / 1000 + "\t\t\t" + result[3] / 1000 + "\t\t" + result[4] / 1000 + "\t\t"
                + result[5] / 1000 + "\t\t" + result[6] / 1000 + "\t\t|");
        System.out.println();
    }

    private static void printLinkedList(String name, long[] result) {
        System.out.print("| " + name + ":\t" + result[0] / 1000 + "\t\t" + result[1] / 1000 + "\t\t"
                + result[2] / 1000 + "\t\t" + result[3] / 1000 + "\t\t" + result[4] / 1000 + "\t\t"
                + result[5] / 1000 + "\t\t" + result[6] / 1000 + "\t\t|");
        System.out.println();
    }

    private static void printSet(String name, long[] result) {
        System.out.print("| " + name + ":\t\t" + result[0] / 1000 + "\t\t\t\t\t" + result[1] / 1000 + "\t\t\t"
                + result[2] / 1000 + "\t\t\t" + result[3] / 1000 + "\t\t\t\t\t\t\t\t\t" + "|");
        System.out.println();
    }


}
