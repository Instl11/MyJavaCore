package training.collections;

import java.util.ArrayList;
import java.util.Iterator;

public class CollectionsTestMyself {

    public static void main(String[] args) {

        ArrayList <Integer> list = new ArrayList<>();
        list.add(555);
        list.add(55);
        list.add(5);
        list.add(55125);
        list.add(223);

       /* for (int a: list){
            System.out.println(a);
        }

        list.forEach(System.out::println);*/

        Iterator<Integer> it = list.iterator();
        it.forEachRemaining(System.out::println);


    }
}
