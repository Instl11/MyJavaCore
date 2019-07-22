package training.collectionsClass.comparator;

public class Salary {
    private double salary;

    public Salary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Salary is: " + salary;
    }
}
