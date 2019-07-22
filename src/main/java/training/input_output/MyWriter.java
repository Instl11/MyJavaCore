package training.input_output;

import training.collectionsClass.map.AverageStudentGrade;
import training.collectionsClass.map.SubjectGrade;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class MyWriter {

    public void writeToFile(SortedMap<AverageStudentGrade, Set<SubjectGrade>> students, String filePath) {
        try (PrintWriter wr = new PrintWriter(new FileWriter(filePath))) {
            for (AverageStudentGrade gradeKey : students.keySet()) {
                wr.write("========================================\n");
                wr.write("Student: " + gradeKey.getName() + " | Average grade: " + gradeKey.getAverageGrade());
                for (SubjectGrade subject : students.get(gradeKey))
                    wr.write("Subject: " + subject.getSubject() + ", Grade: " + subject.getGrade() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void writeWithFormatter(String filepath) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID, Name, Surname, Balance");
        int i = 0;

        while (i < 2) {  //чтобы записалось только две строки
            try (Formatter formatter = new Formatter(filepath)) {
                formatter.format("%d, %s, %s, %.2f%n", sc.nextInt(), sc.next(), sc.next(), sc.nextFloat());
                i++;
            } catch (InputMismatchException e) {
                System.out.println("Input si incorrect. Try again.");
                sc.nextLine();  //возвращаемся к набору с консоли
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
            }
        }
    }

    public void writeObject(List<Student> students, String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
            for (Student st : students) {
                out.writeObject(st);
            }
        } catch (IOException e) {
            System.out.println("File cannot be opened. Program terminates");
            e.printStackTrace();
        }
    }

    public void nioWriteWithBuffer(String fileName) {
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write("Hello, world");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void nioWriteWithStream(String fileName) {
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(path)))){
            writer.write("Hello world");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void nioWriteWithChannel(String fileName){
        String str = "Hello, my dear world! Im typing you from my keyboard.";
        try {
            RandomAccessFile file = new RandomAccessFile(fileName, "rw");
            FileChannel channel = file.getChannel();
            ByteBuffer buffer = ByteBuffer.wrap(str.getBytes());
            channel.write(buffer);
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}