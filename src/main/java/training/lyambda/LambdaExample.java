package training.lyambda;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface ElementProcessor <T extends Number>{
    double process(T element);
}

@FunctionalInterface
interface ExecutiveFunction{
    double action();
}

public class LambdaExample {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);

        processElement(intList, x -> Math.pow(x.doubleValue(), 2));

        List<Double> doubleList = new ArrayList<>();
        doubleList.add(6.4);
        doubleList.add(6.7);
        doubleList.add(3.42);
        doubleList.add(10.0);
        doubleList.add(1.01);



        String hello = "Hello ";
        Double number = 0.54;

        TransformUtil<Double> doubleUtil = new TransformUtil<>();
        doubleUtil.transform(number, Math::sin); //Class::staticMethod

        TransformUtil<String> stringUtil = new TransformUtil<>();
        String suffix = "world!";
        stringUtil.transform(suffix, hello::concat); //ClassInstance::nonStaticMethod

        stringUtil.transform(hello, String::toUpperCase); //Class::nonStaticMethod !!!
        stringUtil.transform(hello, String::new); //Class::new !!!

    }

    private static<T extends Number> void processElement(List<T> list, ElementProcessor<T> func){
        List<Double> doubleList = new ArrayList<>();
        for (T i : list){
            doubleList.add(func.process(i));
        }
        System.out.println(doubleList);
    }
    public static class TimeUtil{
        private static double measure (ExecutiveFunction func){
            double start = System.currentTimeMillis();
            func.action();
            double finish = System.currentTimeMillis();
            return finish - start;
        }
    }
}
