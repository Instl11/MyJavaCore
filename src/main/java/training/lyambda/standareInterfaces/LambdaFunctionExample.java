package training.lyambda.standareInterfaces;


import training.lyambda.standareInterfaces.model.Circle;
import training.lyambda.standareInterfaces.model.Rectangle;
import training.lyambda.standareInterfaces.model.Square;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaFunctionExample {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alex", "Black", 50000));
        employees.add(new Employee("John", "Green", 60000));
        employees.add(new Employee("Tony", "White", 70000));

        List<Person> people = new ArrayList<>();
        people.add(new Person("Alex", "Smith", 25));
        people.add(new Person("John", "Green", 40));
        people.add(new Person("Tony", "Grey", 60));

//PREDICATE
        Employee richEmployee = findMatch(employees, e -> e.getSalary() > 60000);
        Person oldPerson = findMatch(people, p -> p.getAge() > 50);
//FUNCTION
        System.out.println(sum(employees, Employee::getSalary));
        System.out.println(sum(people, Person::getAge));
//BINARYOPERATOR
        BinaryOperator<Integer> combiner = (i1, i2) -> i1 + i2; //(i1, i2) -> Math.max(i1, i2);
        Integer zeroElement = Integer.MAX_VALUE;
        System.out.println(combine(employees, zeroElement, Employee::getSalary, combiner));
//CONSUMER
        employees.forEach(e -> e.setSalary(e.getSalary() + 9999));
        employees.forEach(System.out::println);
//SUPPLIER
        Supplier[] shapes = {Circle::new, Square::new, Rectangle::new};
        Random random = new Random();
        for (int i = 0; i < 4; i++){
            int ind = random.nextInt(3);
            Supplier supplier = shapes[ind];
            supplier.get();
        }

    }

    private static <T> T findMatch(List<T> elements, Predicate<T> func){
        for (T e : elements){
            if(func.test(e)) return e;
        }
        return null;
    }

    private static <T> int sum (List<T> elements, Function<T, Integer> func){
        int sum = 0;
        for (T e : elements){
            sum += func.apply(e);
        }
        return sum;
    }

    private static <T, R> R combine(List<T> elements, R zeroElement, Function<T, R> func, BinaryOperator<R> biFunc){
        for (T e : elements){
            zeroElement = biFunc.apply(zeroElement, func.apply(e));
        }
        return zeroElement;
    }


}
