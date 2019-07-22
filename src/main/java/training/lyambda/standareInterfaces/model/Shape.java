package training.lyambda.standareInterfaces.model;

import java.util.List;

public interface Shape {

    double calcSquare();

    static double calcSumSquare(List<Shape> shapes){
        double squareSum = 0;
        for (Shape sh : shapes){
            squareSum = squareSum + sh.calcSquare();
        }
        return squareSum;
    }
}
