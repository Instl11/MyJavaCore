package training.Generic;

public class GenConstructor {
    private double d;

    public <T extends Number> GenConstructor(T d) {
        this.d = d.doubleValue();
    }
}
