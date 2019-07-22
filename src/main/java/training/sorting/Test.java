package training.sorting;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        int[] nonSorted = {1, 10, 55, 30, 55, -5435, -3, 232, 1, 222222, 2, 111, 2};

        quickSort(nonSorted, 0, nonSorted.length - 1);
        System.out.println(Arrays.toString(nonSorted));
  /*      Random random = new Random();
        System.out.println(random.nextInt(10));*/


    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int separator = partition(arr, low, high);
            quickSort(arr, low, separator);
            quickSort(arr, separator + 1, high);
        }


    }

    public static int partition(int[] arr, int low, int high) {

        int pivot = arr[(low + high) >>> 1];
        int left = low - 1;
        int right = high + 1;

        while (true) {
            while (arr[++left] < pivot) ;
            while (arr[--right] > pivot) ;
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            } else return right;
        }

    }
}
