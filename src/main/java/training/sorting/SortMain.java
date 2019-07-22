package training.sorting;

public class SortMain {
    public static void main(String[] args) {
        int[] nonSortingArr = {599, 43, 212, 413, 121, 4444, 32, 3433, 322, 121, 200};
        // sortInsert(nonSortingArr);

        //  String[] nonSortingArr = {"g", "ds", "dsa", "zzzz", "zaaaa", "bbbbb", "rrrrr"};
        sortInsert(nonSortingArr);
        for (int a : nonSortingArr) {
            System.out.println(a);
        }

    }

    public static int[] sortBubble(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] sortSelect(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int minInd = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minInd] > arr[j]) {
                    minInd = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minInd];
            arr[minInd] = temp;
        }

        return arr;
    }

    public static int[] sortInsert(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >=0 && key < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        return arr;
    }

}
