package EE_3_2_Phaser;

public class Runner {
    public static void main(String[] args) {
        int[] values = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        MySquareSum phaser = new MySquareSum();
        long result = phaser.getSquareSum(values, 4);
        System.out.println(result);
    }
}
