package training.lyambda;

@FunctionalInterface
interface Transformable <T>{
     T action(T t);
}

public class TransformUtil<T> {

    T transform (T t, Transformable<T> func){
        return func.action(t);
    }


    static String exclaim(String s){
        return s.toUpperCase().concat("!!!!!");
    }
}
