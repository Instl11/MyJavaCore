package training.Generic.company;
import training.Generic.company.employees.Accountant;
import training.Generic.company.employees.ITSpec;
import training.Generic.company.employees.Manager;

import java.util.ArrayList;
import java.util.List;

public class CompanyMain {
    public static void main(String[] args) {
        Company company = new Company();

        Department<Accountant> accounting = new Department<>("Accounting", 5);
        Department<Manager> management = new Department<>("management", 2);
        Department<ITSpec> itGuys = new Department<>("IT", 10);




        Accountant accountant = new Accountant("Alex", 1000f);
        ITSpec it = new ITSpec("James", 2000f);
        Manager manager = new Manager("Michail", 4000f);

        accounting.addEmployee(accountant);
        management.addEmployee(manager);
        itGuys.addEmployee(it);

        List<String> list = new ArrayList<>();
        list.add("dfsd");
        list.add("fsd");
        list.add("dfd");
        list.add("dfs");

        company.print(list);




        List<Integer> list2 = new ArrayList<>();
        pr(list2);

    }
    public static <T extends Number> void pr(List<T> list){
        System.out.println(list);
    }
}
