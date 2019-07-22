package training.collectionsClass.textReading;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        String[] s = {"aaa", "_fff", "'fffsa", "ggg:"};
        for (int i = 0; i<s.length; i++){
            s[i] = s[i].replaceAll("\\p{Punct}*(\\w+)\\p{Punct}*", "$1");
        }
        System.out.println(Arrays.toString(s));
    }
}
