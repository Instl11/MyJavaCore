package training.Generic.company;

import training.Generic.company.employees.Employee;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<Department> departments = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();

    public <T extends Employee> void addDepartment (Department<T> dep){
        departments.add(dep);
        List<T> employeeList = dep.getEmployees();
        employees.addAll(employeeList);
    }

    public void print (List<?> list){
        System.out.println(list);
    }



    public List<Department> getDepartments() {
        return departments;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
