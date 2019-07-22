package training.collectionsClass.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("Джон Сноу");
        names.add("Джо Сноу");
        names.add("Джозеф Сно");
        names.add("Джа Снау");
        names.add("Джэк Сноу");

        Comparator<String> lastName = Comparator.comparing(s -> s.substring(s.indexOf(' ')));
        Comparator<String> all = lastName.thenComparing(Comparator.naturalOrder());

        names.sort(all);
        names.forEach(System.out::println);
    }
}
