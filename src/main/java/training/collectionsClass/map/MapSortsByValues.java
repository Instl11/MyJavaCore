package training.collectionsClass.map;

import java.io.IOException;
import java.util.*;

/*Делаем сортировку по значению с помощью листа и компаратора
* Помещаем отсортированный лист в LinkedHashMap чтобы не сбился порядок, т.к.
* он сохраняет порядок ввода в него элементов.
* Используем лист, так как sort() работает только с листами.*/

public class MapSortsByValues {
    public static void main(String[] args) throws IOException {

        Map<String,Integer> map = new HashMap<>();

        map.put("aaa", 4);
        map.put("bbb", 2);
        map.put("eee", 20);
        map.put("ccc", 3);
        map.put("ddd", 1);

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, Comparator.comparingInt(Map.Entry::getValue));

        Map<String,Integer> result = new LinkedHashMap<>();
        for (Map.Entry<String,Integer> entry : list){
            result.put(entry.getKey(), entry.getValue());
        }
        result.forEach((s, v) -> System.out.println(s + " - " + v));


    }
}
