package module1;

class Print {
    public static void print(int number, long[] arrayList, long[] linkedList) {
        System.out.println("-----------------------------------------------------------------------------------------------");

        Print.printHead(number);
        Print.printBody("ArrayList", arrayList);
        Print.printBody("LinkedList", linkedList);
        System.out.println("-----------------------------------------------------------------------------------------------");

    }

    public static void printHead(int number) {
        System.out.println(number);
        System.out.println("\t\t\t" + "add" + "\t\t\t" + "get" + "\t\t\t" + "remove" + "\t\t" +
                "contains" + "\t" + "populate" + "\t" + "iter.add" + "\t" + "iter.remove");
    }

    public static void printBody(String name, long[] result) {
        System.out.print(name + ":\t");
        for (long aResult : result) {
            System.out.print(aResult + "\t\t");
        }
        System.out.println();
    }


}
