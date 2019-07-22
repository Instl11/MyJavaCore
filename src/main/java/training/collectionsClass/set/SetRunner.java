package training.collectionsClass.set;

import java.util.HashSet;
import java.util.Set;

public class SetRunner {
    public static void main(String[] args) {

        Set<Car> sixCars = new HashSet<>();
        sixCars.add(new Car("VW", "golf", 45));
        sixCars.add(new Car("Audi", "A3", 60));
        sixCars.add(new Car("VW", "Polo", 25));

        Set<Car> europaCars = new HashSet<>();
        europaCars.add(new Car("Toyota", "Auris", 45));
        europaCars.add(new Car("Reno", "Clio", 30));
        europaCars.add(new Car("Audi", "A3", 60));
        europaCars.add(new Car("Reno", "Megan", 50));
        europaCars.add(new Car("VW", "golf", 45));


        Set<Car> unionCars = new HashSet<>(sixCars);
        unionCars.addAll(europaCars);
        sixCars.retainAll(europaCars);
        unionCars.removeAll(sixCars);

        unionCars.forEach(System.out::println);


    }
}
