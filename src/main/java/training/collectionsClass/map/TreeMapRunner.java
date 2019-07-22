package training.collectionsClass.map;

import java.util.*;

public class TreeMapRunner {
    public static void main(String[] args) {

        Set<SubjectGrade> markGrade = new HashSet<>();
        markGrade.add(new SubjectGrade("Math", 80));
        markGrade.add(new SubjectGrade("Phisics", 70));
        markGrade.add(new SubjectGrade("Biology", 90));

        Set<SubjectGrade> alinaGrade = new HashSet<>();
        alinaGrade.add(new SubjectGrade("Math", 60));
        alinaGrade.add(new SubjectGrade("Phisics", 70));
        alinaGrade.add(new SubjectGrade("Biology", 86));

        Set<SubjectGrade> antonGrade = new HashSet<>();
        antonGrade.add(new SubjectGrade("Math", 82));
        antonGrade.add(new SubjectGrade("Phisics", 79));
        antonGrade.add(new SubjectGrade("Biology", 40));

        NavigableMap<AverageStudentGrade, Set<SubjectGrade>> students = new TreeMap<>();

        students.put(new AverageStudentGrade("Mark", calcAverage(markGrade)), markGrade);
        students.put(new AverageStudentGrade("Alina", calcAverage(alinaGrade)), alinaGrade);
        students.put(new AverageStudentGrade("Anton", calcAverage(antonGrade)), antonGrade);

        aPrint(students, true);
        System.out.println("========================================");
        System.out.println(students.descendingMap().firstEntry());

        /*AverageStudentGrade border = students.ceilingKey(new AverageStudentGrade("", 75));
        SortedMap<AverageStudentGrade, Set<SubjectGrade>> nearMoney = students.tailMap(border);
        System.out.println("===========================================");
        aPrint(nearMoney, false);

        AverageStudentGrade cleverOfStupid = students.lowerKey(border);
        System.out.println(cleverOfStupid);*/


    }

    public static double calcAverage(Set<SubjectGrade> grades) {
        double sum = 0;
        for (SubjectGrade s : grades) {
            sum += s.getGrade();
        }
        return sum / grades.size();
    }

    private static void aPrint(Map<AverageStudentGrade, Set<SubjectGrade>> map, boolean printValue){
        Set<AverageStudentGrade> keys = map.keySet();
        for (AverageStudentGrade s : keys){
            System.out.println(s);
            if (printValue) System.out.println(map.get(s));
        }

    }
}
