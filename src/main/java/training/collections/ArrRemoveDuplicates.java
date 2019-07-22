package training.collections;

import java.util.Arrays;
import java.util.Random;

@FunctionalInterface
interface ArrayActionable {
    void action(int[] arr);
}


public class ArrRemoveDuplicates {
    public static void main(String[] args) {

        Random random = new Random();
        int[] sourceArr = new int[100000];
        for (int i = 0; i < sourceArr.length; i++) {
            sourceArr[i] = random.nextInt(1000);
        }
        int[] ints = Arrays.copyOf(sourceArr, sourceArr.length);


        //   List<Integer> list = Arrays.stream(sourceArr).boxed().collect(Collectors.toList());

        System.out.println(timeOfExecution(sourceArr, ArrRemoveDuplicates::removeDuplicatesSimple));
        System.out.println(timeOfExecution(ints, ArrRemoveDuplicates::removeDuplicatesBoolean));


    }

    private static void removeDuplicatesSimple(int[] sourceArr) {
        int zeroElement = sourceArr[0];
        for (int i = 1; i < sourceArr.length; i++) {
            if (sourceArr[i] != zeroElement) {
                for (int j = i + 1; j < sourceArr.length; j++) {
                    if (sourceArr[i] == sourceArr[j])
                        sourceArr[j] = zeroElement;
                }
            }
        }
        int count = 0;
        for (int i = 1; i < sourceArr.length; i++) {
            if (sourceArr[i] == zeroElement)
                count++;
        }
        int[] result = new int[sourceArr.length - count];
        result[0] = zeroElement;
        for (int i = 1, j = 1; i < sourceArr.length; i++) {
            if (sourceArr[i] != zeroElement) {
                result[j] = sourceArr[i];
                j++;
            }
        }
        System.out.println(Arrays.toString(result));
    }

    public static void removeDuplicatesBoolean(int[] values) {

        boolean[] marks = new boolean[values.length];
        int count = 0;

        for (int i = 0; i < values.length; i++) {
            if (!marks[i]) {
                for (int j = i + 1; j < values.length; j++) {
                    if (values[i] == values[j]) {
                        marks[j] = true;
                        count++;
                    }
                }
            }
        }
        int[] result = new int[values.length - count];
        for (int j = 0, m = 0; j < values.length; j++) {
            if (!marks[j]) {
                result[m] = values[j];
                m++;
            }
        }

        System.out.println(Arrays.toString(result));
    }

    static double timeOfExecution(int[] arr, ArrayActionable func) {

        double start = System.currentTimeMillis();
        func.action(arr);
        double end = System.currentTimeMillis();
        return end - start;
    }

}
