package training.exceptions;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionhandlingMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true;  //если программа отработает верно, то переменная станет false и выйдет из цикла
        do {
            try {
                System.out.println("Pls enter numerator");
                int numerator = scanner.nextInt();
                System.out.println("Pls enter denumerator");
                int denominator = scanner.nextInt();
                System.out.println(divide(numerator, denominator));

                saveToFile(divide(numerator, denominator));

                continueLoop = false;
            } catch (ArithmeticException | InputMismatchException e) {
                System.out.println("Exception: " + e);
                scanner.nextLine();
                System.out.println("Only integer non-zero parameters allowed");
            } catch (IOException e) {
                System.out.println("Unable to open file");
                e.printStackTrace();
            } finally {
                System.out.println("Finally called");

            }
        } while (continueLoop);  //цикл чтобы программа после ошибки возвращалась к вводу данных снова, а не просто выходила из программы
    }

    private static int divide(int numerator, int denumenator) {
        return numerator / denumenator;
    }

    private static void saveToFile(int res) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter("out.txt"));
        writer.println("Our result: " + res);
        writer.close();
    }
}
