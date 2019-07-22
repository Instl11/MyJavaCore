package training.Generic;

public class Stats<T extends Number> {
    private T [] arr;

    public Stats(T[] arr) {
        this.arr = arr;
    }

    public double average(){
        double sum = 0;
        for (T n : arr){
            sum += n.doubleValue();
        }
        return sum/arr.length;
    }

    public boolean sameAvrg (Stats<?> num){
        return this.average() == num.average();
    }
}
