package training.OOP;

import java.util.Arrays;

public class ArrayVarArgs {
    public static void main(String[] args) {
        double a = 0.56;
        double b = 5.56;
        double c = 4.56;
        double d = 10.56;
        System.out.printf("2 elements: %8.2f \n", calcAverage(a,b));
        System.out.printf("4 elements: %8.2f \n", calcAverage(a,b,c,d));

        int [] arr = {4, 54, 664, 22,3};
        int[] ints = Arrays.copyOf(arr, 10);
        System.out.println(Arrays.toString(ints));

        int[] ints2 = new int [5];
        System.arraycopy(arr, 0, ints2, 0, arr.length);
        System.out.println(Arrays.toString(ints2));


    }

    private static double calcAverage(double... args) {
        double sum = 0;
        for (double d : args) {
            sum = sum + d;
        }
        return sum / args.length;
    }
}
