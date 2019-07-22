package training.input_output;

import training.collectionsClass.map.AverageStudentGrade;
import training.collectionsClass.map.SubjectGrade;

import java.io.*;
import java.util.*;

import static training.collectionsClass.map.TreeMapRunner.calcAverage;

public class IOMain {
    public static void main(String[] args) throws IOException {

        SortedMap<AverageStudentGrade, Set<SubjectGrade>> students = initMap();

        MyWriter writer = new MyWriter();
        writer.writeToFile(students, "GradeBook.txt");

       /* MyReader reader = new MyReader();
   //     reader.readFromFile("GradeBook.txt");


        readWriteByte();

        //       writeWithFormatter("BankAccounts.txt");

        processGrade(students, writer, "BinaryFile.bin");
        List<Student> studentsFromFile = reader.readObjects("BinaryFile.bin");
        System.out.println(studentsFromFile);

        String property = System.getProperty("user.dir");
        System.out.println(property);
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("1.doc"));*/

        /*MyReader reader = new MyReader();
        reader.nioReadWithChannel("GradeBook.txt");*/

        writer.nioWriteWithChannel("3.txt");
    }


    private static void processGrade(SortedMap<AverageStudentGrade, Set<SubjectGrade>> students, MyWriter writer, String filename) {
        List<Student> list = new ArrayList<>();
        for (AverageStudentGrade gr : students.keySet()) {
            list.add(new Student(gr.getName(), gr.getAverageGrade(), students.get(gr)));
        }
        writer.writeObject(list, filename);
    }

    private static void readWriteByte() throws IOException {
        try (FileOutputStream wr = new FileOutputStream("GradeBookBite.txt");
             FileInputStream rdr = new FileInputStream("GradeBook.txt")) {
            int c;
            while ((c = rdr.read()) != -1) {
                wr.write(c);
            }
        }
    }


    private static NavigableMap<AverageStudentGrade, Set<SubjectGrade>> initMap() {
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
        return students;
    }


}
