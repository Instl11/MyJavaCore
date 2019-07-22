package training.lyambda.higherOrderFunction;

public class RichPerson {

    private String name;
    private String lastNme;
    private int salary;
    private int age;

    public RichPerson(String name, String lastNme, int salary, int age) {
        this.name = name;
        this.lastNme = lastNme;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getLastNme() {
        return lastNme;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastNme(String lastNme) {
        this.lastNme = lastNme;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "RichPerson{" +
                "name='" + name + '\'' +
                ", lastNme='" + lastNme + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}
