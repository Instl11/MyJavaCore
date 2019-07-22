package training.lyambda.comparing;

public class TempRunner {
    public static void main(String[] args) {
        int count;
        HighTemp[] weekDaysHigh = {new HighTemp(22), new HighTemp(10), new HighTemp(45)};
        count = counter(weekDaysHigh, HighTemp::sameTemp, new HighTemp(10));
        System.out.println(count);
    }

    static <T> int counter(T[] arr, MyFunc<T> f, T value) {
        int count = 0;
        for (T param : arr)
            if (f.func(param, value)) count++;
        return count;
    }
}
