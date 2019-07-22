package training.collectionsClass.map;

import java.util.*;
import java.util.stream.Collectors;

public class MapSortByValueStream {
    public static void main(String[] args) {
        Map<String, Integer> people = new HashMap<>();
        people.put("Lenny", 55);
        people.put("Bob", 35);
        people.put("Anton", 30);
        people.put("Jack", 10);
        people.put("Ken", 40);
        people.put("Alex", 25);

        System.out.println(people);

        LinkedHashMap<String, Integer> sortedByV = people.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getValue))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (i1, i2) -> i1, LinkedHashMap::new));


        System.out.println(sortedByV);

    }
}
