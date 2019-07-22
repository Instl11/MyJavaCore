package training.stream;

import java.util.ArrayList;
import java.util.List;

public class PeopleTest {
    public static void main(String[] args) {

        List<People> list = new ArrayList<>();
        list.add(new People("Вася", 16, People.Sex.MAN));
        list.add(new People("Петя", 23, People.Sex.MAN));
        list.add(new People("Елена", 42, People.Sex.WOMAN));
        list.add(new People("Иван Иванович", 69, People.Sex.MAN));

    }
}
