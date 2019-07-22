package training.Inheritance;

public class Truck extends FuelAuto {

    private int CargoWeight;

    public Truck(String producer, String model, Engine engine, int availablePetrol, int tankVolume, int cargoWeight) {
        super(producer, model, engine, availablePetrol, tankVolume);
        CargoWeight = cargoWeight;
        System.out.println("Constructing truck");
    }

    public int getCargoWeight() {
        return CargoWeight;
    }

    public void setCargoWeight(int cargoWeight) {
        CargoWeight = cargoWeight;
    }

    public void load(){
        System.out.println("Cargo loaded");
    }

    public void unload(){
        System.out.println("Cargo unloaded");
    }

    @Override
    public void energize() {
        fuelUp(getTankVolume() - getAvailablePetrol());
        System.out.printf("Truck has been fueled");
    }

    @Override
    public void start() {
        isRunning = true;
        setCurrentSpeed(10);
        System.out.println("Truck is starting");
    }

    @Override
    public void stop() {
        isRunning = false;
        setCurrentSpeed(0);
        System.out.println("Truck has stopped");
    }
}
