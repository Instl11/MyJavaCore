package training.input_output;

import training.collectionsClass.map.SubjectGrade;

import java.io.Serializable;
import java.util.Set;

public class Student implements Serializable {

    private String name;
    private double averageGrade;
    private Set<SubjectGrade> grades;

    public Student(String name, double averageGrade, Set<SubjectGrade> grades) {
        this.name = name;
        this.averageGrade = averageGrade;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public Set<SubjectGrade> getGrades() {
        return grades;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", averageGrade=" + averageGrade +
                ", grades=" + grades +
                '}';
    }
}
