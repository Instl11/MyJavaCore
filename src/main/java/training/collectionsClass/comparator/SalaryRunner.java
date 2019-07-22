package training.collectionsClass.comparator;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SalaryRunner {
    public static void main(String[] args) {

        ArrayList<Salary> list = new ArrayList<>();
        list.add(new Salary(500));
        list.add(new Salary(600));
        list.add(new Salary(700));
        list.add(new Salary(999));

        Comparator<Salary> comp = Comparator.comparingDouble(Salary::getSalary);

        Salary max = Collections.max(list, comp);

        System.out.printf("%.2f", max.getSalary());

    }
}
