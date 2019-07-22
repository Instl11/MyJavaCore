package training.Generic;

import java.util.ArrayList;
import java.util.List;

public class StatsRunner {
    public static void main(String[] args) {
       /* Integer[] num = {2, 5, 7, 8, 34, 5, 2};
        Stats <Integer> i = new Stats<>(num);

        Double[] dNum = {3.5, 4.4, 6.6, 8.8, 3.5};
        Stats<Double> d = new Stats<>(dNum);

        System.out.println(i.sameAvrg(d));

        System.out.println(GenMethodInNotGenClass.isIn(2, num));*/

       List<Integer> l = new ArrayList<>();
       l.add(1);
       l.add(2);
       l.add(3);
       l.add(4);
       l.add(5);
       pE(l);

    }

    private static void pE(List<? extends Number> list){
        list.forEach(System.out::println);
    }

    //или вот так:   private static <T extends Number> void pE2(List<T> list){}
}

