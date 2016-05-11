package EE_3_2_Phaser;


import org.junit.Test;

import java.util.concurrent.Phaser;

import static org.junit.Assert.*;

public class MySquareSumTest {
    private int[] values = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

    @Test
    public void testGetSquareSum() throws Exception {
        MySquareSum phaser = new MySquareSum();
        long result = phaser.getSquareSum(values, 4);

        assertEquals(649, result);
    }

    @Test
    public void testComputeSquaresIndex0() throws Exception {
        Phaser phaser = new Phaser();
        Calculating calculating = new Calculating(values, 4, phaser, 0);
        long result = calculating.computeSquares();

        assertEquals(13, result);
    }

    @Test
    public void testComputeSquaresLastIndex() throws Exception {
        Phaser phaser = new Phaser();
        Calculating calculating = new Calculating(values, 4, phaser, 3);
        long result = calculating.computeSquares();

        assertEquals(510, result);
    }

}