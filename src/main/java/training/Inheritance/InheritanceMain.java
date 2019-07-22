package training.Inheritance;

import java.util.List;

public class InheritanceMain {

    public static void main(String[] args) {

        Engine busEngine = new Engine(5.0, EngineType.DIESEL, 500, 3);
        Auto bus = new Bus("Mercedes", "Sprinter", busEngine, 100, 500, 1);

        Auto truck = new Truck("VF", "Polo", busEngine, 100, 500,  25);

        runCar(bus);
        runCar(truck);



    }

    private  static void runCar (Auto auto){
        auto.start();
        auto.stop();
        /*if (auto instanceof FuelAuto){
            FuelAuto fAuto = (FuelAuto) auto;
            fAuto.fuelUp(55);
        }*/
        auto.energize();
    }
}
