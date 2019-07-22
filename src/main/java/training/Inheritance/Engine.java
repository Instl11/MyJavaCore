package training.Inheritance;

import java.util.ArrayList;
import java.util.List;


public class Engine {

    public Engine() {
        number++;
    }

    private static int number = 0;

    private double volume;
    private EngineType engineType;
    private int power;
    private List<Piston> pistons = new ArrayList<>();

    public Engine(double engineVol, EngineType engineType, int power, int pistonVol) {
        number++;
        this.volume = engineVol;
        this.engineType = engineType;
        this.power = power;
        this.pistons.add(new Piston(pistonVol, number));
    }

    public static int getNumber() {
        return number;
    }

    public double getVolume() {
        return volume;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public int getPower() {
        return power;
    }

    public List<Piston> getPistons() {
        return pistons;
    }
}
