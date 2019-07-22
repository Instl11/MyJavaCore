package training.OOP;

import java.time.LocalDate;
import java.util.Objects;

public class Manager extends Employee {

    private double bonus;

    public Manager(double salary, String name, LocalDate hireDay, double bonus) {
        super(salary, name, hireDay);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manager)) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return Double.compare(manager.getBonus(), getBonus()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getBonus());
    }
}
