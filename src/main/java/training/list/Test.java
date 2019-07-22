package training.list;

import java.util.*;

public class Test {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        int [] to = {1,2,3,4,5,6,7,8,9, -1, -2,-3,-4};
        Integer [] copyFrom = {10, 20, 30, 40, 50, 60, 70};
        String[] colors = {"blue", "black"};

        LinkedList<Integer> ints = new LinkedList<>(Arrays.asList(copyFrom));
        ints.forEach(System.out::println);

        Integer [] backToArray = ints.toArray(new Integer[0]);

       /* list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        System.arraycopy(copyFrom, 4, to, 6, to.length - 4);
        System.out.println(Arrays.toString(to));*/
    }
}
