package training.lyambda.higherOrderFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class HigherOrderFunctionExample {
    public static void main(String[] args) {

        List<RichPerson> persons = new ArrayList<>();
        persons.add(new RichPerson("Alex", "Black", 50000, 25));
        persons.add(new RichPerson("John", "Green", 75000, 35));
        persons.add(new RichPerson("Sam", "Brown", 80000, 40));
        persons.add(new RichPerson("Tony", "Grey", 90000, 50));

       testPredicate(persons);
    }

    private static void testPredicate(List<RichPerson> persons) {
        Predicate<RichPerson> isRich = p -> p.getSalary() >= 75000;
        Predicate<RichPerson> isYoung = p -> p.getAge() <= 40;
        findAll(persons, isRich.and(isYoung)).forEach(System.out::println);
        findAll(persons, isRich.or(isYoung)).forEach(System.out::println);
        findAll(persons, isYoung.negate()).forEach(System.out::println);
    }

    private static <T> List<T> findAll(List<T> elements, Predicate<T> predicate) {
        List<T> filteredList = new ArrayList<>();
        for (T el : elements) {
            if (predicate.test(el))
                filteredList.add(el);
        }
        return filteredList;
    }

    private static void testFunction(List<RichPerson> persons){
        Function<RichPerson, String> name = p -> p.getName() + " " + p.getLastNme();
        Function<String, String> helloName = p -> "Hello" + p;
        Function<RichPerson, String> composeFunction = helloName.compose(name);
        transform(persons, composeFunction);
    }

    private static <T, R> List<R> transform(List<T> elements, Function<T, R> function){
        List<R> list = new ArrayList<>();
        for (T el : elements){
            list.add(function.apply(el));
        }
        return list;
    }

    private static <T> Function<T,T> compose(Function<T,T> ... function){
        Function<T, T> result = Function.identity();
        for (Function<T,T> f : function){
            result = result.andThen(f);
        }
        return result;
    }


    private static void testConsumer(List<RichPerson> persons){
        Consumer<RichPerson> raiseSalary = p -> p.setSalary(p.getSalary()+5000);
        processList(persons, raiseSalary.andThen(System.out::println));
    }

    private static <T> void processList(List<T> elements, Consumer<T> consumer){
        for (T e : elements)
            consumer.accept(e);
    }
}
