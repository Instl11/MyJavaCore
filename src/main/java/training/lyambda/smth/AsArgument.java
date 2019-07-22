package training.lyambda.smth;

import java.util.ArrayList;
import java.util.List;

public class AsArgument {
    static String stringOp (StringFunc sf, String s){
        return sf.func(s);
    }

    public static void main(String[] args) {
        String toUpCase = stringOp(s -> s.toUpperCase(), "privet");

        StringFunc rev = s -> {
            StringBuilder str = new StringBuilder(s);
            return str.reverse().toString();
        };
        String revString = stringOp(rev, "Hello");

        List<Integer> list = new ArrayList<>();
        list.forEach(System.out::println );
    }
}
