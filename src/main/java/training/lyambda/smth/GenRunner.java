package training.lyambda.smth;

public class GenRunner {
    public static void main(String[] args) {

        Gen_int<String> reverse = s -> {
            String res = "";
            for (int i = s.length() - 1; i >= 0; i--)
                res = res + s.charAt(i);
            return res;
        };
        System.out.println(reverse.func("Privet"));

        Gen_int<Integer> factorial = i -> {
            int res = 1;
            for (int j = 2; j <= i; j++)
                res = res * j;
            return res;
        };
        System.out.println(factorial.func(10));
    }
}
