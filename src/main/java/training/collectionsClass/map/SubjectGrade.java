package training.collectionsClass.map;

import java.io.Serializable;
import java.util.Objects;

public final class SubjectGrade implements Serializable {
    private final String subject;
    private final int grade;

    public SubjectGrade(String subject, int grade) {
        this.subject = subject;
        this.grade = grade;
    }

    public String getSubject() {
        return subject;
    }

    public double getGrade() {
        return grade;
    }


    @Override
    public String toString() {
        return "Subject: " + subject + "; Grade: " + grade;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubjectGrade)) return false;
        SubjectGrade that = (SubjectGrade) o;
        return getGrade() == that.getGrade() &&
                Objects.equals(getSubject(), that.getSubject());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSubject(), getGrade());
    }
}
