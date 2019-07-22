package training.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayLeaders {
    public static void main(String[] args) {

    }

    public static List arrayLeader(int[] numbers){

        return IntStream.range(0, numbers.length - 1)
                .filter(i -> numbers[i] > (Arrays.stream(Arrays.copyOfRange(numbers, i+1, numbers.length-1))).sum())
                .mapToObj(n -> numbers[n]).collect(Collectors.toList());
    }
}
