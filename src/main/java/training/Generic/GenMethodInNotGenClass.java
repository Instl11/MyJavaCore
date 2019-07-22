package training.Generic;

public class GenMethodInNotGenClass {

    static <T extends Comparable<T>, V extends T> boolean isIn (T obj, V[] arr){
        for (V v : arr){
            return v.compareTo(obj) == 0;
        }return false;
    }
}
