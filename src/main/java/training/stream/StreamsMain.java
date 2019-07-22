package training.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsMain {

    private static List<Employee> employees = new ArrayList<>();
    private static List<Employee> secondList = new ArrayList<>(employees);
    private static Map<Integer, Employee> employeeMap = null;

    public static void main(String[] args) throws IOException {

        Department it = new Department("IT");
        Department accounting = new Department("Accounting");
        Department managers = new Department("Manager");

        employees.add(new Employee(1, "Alex", "Black", 50000, it));
        employees.add(new Employee(2, "John", "Green", 75000, managers));
        employees.add(new Employee(6, "Sam", "Brown", 80000, accounting));
        employees.add(new Employee(9, "Tony", "Grey", 90000, it));
        employees.add(new Employee(10, "Mike", "Yellow", 60000, managers));
        employees.add(new Employee(11, "Vick", "Pink", 75000, accounting));
        employees.add(new Employee(16, "Sean", "Magenta", 80000, it));
        employees.add(new Employee(19, "Kate", "Black", 88000, managers));
        employees.add(new Employee(9, "Tony", "Grey", 90000, accounting));
        employees.add(new Employee(10, "Mike", "Yellow", 60000, it));
        employees.add(new Employee(11, "Vick", "Pink", 75000, managers));

      //  testStreamFromList();
      //  testStreamFromFile();

       /* Map<Department, Integer> collect = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingInt(Employee::getSalary)));

        collect.forEach((k, v) -> System.out.println(k.getName() + ": " + v));

        testSortAndReduce();*/


       /* Map<String, Integer> map = employees.stream()
                .collect(Collectors.groupingBy(Employee::getFirstName, Collectors.summingInt(Employee::getSalary)));
        map.forEach((k,v) -> System.out.println(k + v));*/

       /* Map<Boolean, List<Employee>> richEmp = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.getSalary() > 80000));
        richEmp.forEach((k,v) -> System.out.println(k + " " + v));*/

        IntSummaryStatistics summary = employees.stream()
                .collect(Collectors.summarizingInt(Employee::getSalary));

        double asDouble = employees.stream().mapToInt(Employee::getSalary).average().getAsDouble();
        System.out.println(asDouble);
       /* int sum = employees.stream()
                .sorted(Comparator.comparing(Employee::getFirstName))
                .filter(e -> e.getId() < 5)
                .mapToInt(Employee::getSalary)
                .sum();
        System.out.println(sum);*/
    }

    private static void parallelStream() throws IOException {
        employees.parallelStream()
                .map(Employee::getId)
                .sorted()
                .collect(Collectors.toList());

        Files.lines(Paths.get("1.txt"))
                .parallel()
                .filter(e -> e.length() > 4)
                .map(String::toUpperCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }

    private static void testStreamFromList() {

        employees.stream()
                .filter(e -> e.getSalary() > 60000)
                .filter(e -> e.getId() < 10)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        Integer[] ids = {1, 2, 3, 4, 5, 6, 7, 8, 9, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        Stream.of(ids)
                .map(StreamsMain::findById)
                .filter(Objects::nonNull)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        Integer result = Stream.of(ids)
                .filter(i -> i % 2 == 0)
                .filter(i -> i % 3 == 0)
                .filter(i -> i % 5 == 0)
                .findFirst()
                .orElse(0);

        int sum = Stream.of(ids)
                .map(StreamsMain::findById)
                .filter(Objects::nonNull)
                .mapToInt(Employee::getSalary)
                .sum();

        List<List<Employee>> departments = new ArrayList<>();
        departments.add(employees);
        departments.add(secondList);

        departments.stream()
                .flatMap(l -> l.stream().map(Employee::getFirstName))
                .forEach(System.out::println);


    }

    private static void testStreamFromFile() throws IOException {
        Files.lines(Paths.get("1.txt"))
                .filter(e -> e.length() > 4)
                .map(String::toUpperCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }

    private static Employee findById(int id) {
        if (employeeMap == null)
            employeeMap = employees.stream()
                    .distinct()
                    .collect(Collectors.toMap(Employee::getId, e -> e));
        return employeeMap.get(id);
    }

    private static void testSortAndReduce(){

        Employee identity = new Employee(0, "", "", 0);
        Employee reduced = employees.stream()
                .reduce(identity, (e1, e2) -> {
                    e1.setSalary(e1.getSalary() + e2.getSalary());
                    e1.setId(e1.getId() + e2.getId());
                    return e1;
                });
        System.out.println(reduced);
    }

    private static void testStreamIterator(){
        Stream<Integer> limit = Stream.iterate(1, e -> e * 3).limit(10);
    }


    private static void testStreamGenerator(){
        Stream<Double> limit = Stream.generate(Math::random).limit(10);
    }

}
