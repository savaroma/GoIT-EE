package test.java.com.builder.java;

import main.java.com.builder.java.TestCollections;
import main.java.com.builder.java.TimeResult;
import org.junit.Test;

import java.util.AbstractList;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyListTest {

    @Test
    public void testGetClassName() throws Exception {
        AbstractList<Integer> list = new ArrayList<>();
        String name = list.getClass().getSimpleName();

        assertEquals("ArrayList", name);
    }

    @Test
    public void testStopwatch() throws Exception {
        long start = System.currentTimeMillis();
        int[] array = new int[1000_000];
        for (int i = 0; i < 1000_000; i++) {
            array[i] = 1000;
        }
        long end = System.currentTimeMillis();
        System.out.println(start);
        System.out.println(end);
        System.out.println(end - start);
    }

    @Test
    public void testStringEquals() throws Exception {
        String[] table = new String[3];
        table[0] = "ArrayList";
        table[1] = "LinkedList";
        table[2] = "Set";
        TimeResult time = new TimeResult("LinkedList", "useMethod", 25.0);
        boolean resultEqual = false;
        for (int i = 0; i < table.length; i++) {
            if (table[i].equals(time.getRow())) {
                resultEqual = true;
            }
        }
        assertTrue(resultEqual);
    }

    @Test
    public void testAllMethod() throws Exception {
        TestCollections collection = new TestCollections();
        collection.add();
        collection.get();
        collection.remove();
        collection.contains();
        collection.iteratorAdd();
        collection.iteratorRemove();
    }

    @Test
    public void testClear() throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(25);
        arrayList.add(36);
        arrayList.add(89);
        arrayList.clear();
        assertEquals(0, arrayList.size());
    }
}