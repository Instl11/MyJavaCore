package training.collectionsClass.map;

public final class AverageStudentGrade implements Comparable<AverageStudentGrade> {
    private final String name;
    private final double averageGrade;

    public AverageStudentGrade(String name, double averageGrade) {
        this.name = name;
        this.averageGrade = averageGrade;
    }

    public String getName() {
        return name;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    @Override
    public int compareTo(AverageStudentGrade that) {
        return averageGrade != that.getAverageGrade() ? ((averageGrade > that.averageGrade) ? 1 : -1) : name.compareTo(that.getName());
    }

    @Override
    public String toString() {
        return "Name: " + name + "; Average Grade: " + averageGrade;
    }
}
