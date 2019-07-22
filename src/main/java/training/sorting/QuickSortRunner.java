package training.sorting;

import java.util.Arrays;

public class QuickSortRunner {
    public static void main(String[] args) {

        int[] nonSorted = {1, 10, 3, 6, 12, 4, 9};
        quicksort(nonSorted, 0, nonSorted.length - 1);

        System.out.println(Arrays.toString(nonSorted));


    }

    private static void quicksort(int[] array, int low, int high) {
        if (low < high) {
            int separator = partition(array, low, high);
            quicksort(array, low, separator);
            quicksort(array, separator + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {

        int midValue = array[(low + high) >>> 1];
        int left = low - 1;
        int right = high + 1;

        while (true) {
            while (array[++left] < midValue) ;
            while (array[--right] > midValue) ;

            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            } else return right;
        }

    }
}
