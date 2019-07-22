package training.collectionsClass;

public class Recursion {
    public static void main(String[] args) {
      //  numbers(10);
        System.out.println(aTob(20, 10));
    }

    static void numbers (int n){
        System.out.println(n);
        if (n == 1) return;

        numbers(n-1);
    }

    static String aTob (int a, int b){
        if (a == b) return Integer.toString(a);
        if (a < b) {
           return a + " " + aTob(a+1, b);
        }else return a + " " + aTob(a-1, b);
    }

    static void sum (int n){


    }

}
