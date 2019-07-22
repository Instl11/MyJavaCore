package training.Inheritance;

public class Bus extends FuelAuto {

    private int passangerNumber;


    public Bus(String producer, String model, Engine engine, int availablePetrol, int tankVolume, int passangerNumber) {
        super(producer, model, engine, availablePetrol, tankVolume);
        this.passangerNumber = passangerNumber;
        System.out.println("Bus was initialized");
    }

    public void fuelUp(){
        int volume = getTankVolume() - getAvailablePetrol();
        fuelUp(volume);
    }

    @Override
    public void fuelUp(int petrolVolume) {
        int volume = getAvailablePetrol() + petrolVolume;
        if (volume>getTankVolume()){
            setAvailablePetrol(getTankVolume());
        }else setAvailablePetrol(volume);
    }

    public int getPassangerNumber() {
        return passangerNumber;
    }

    public void setPassangerNumber(int passangerNumber) {
        this.passangerNumber = passangerNumber;
    }

    public void pickUpPass(int passengerNumber){
        this.passangerNumber+=passengerNumber;
        System.out.println("Picing up " + passengerNumber + " passangers");
    }

    public void releasePass(){
        if (isRunning){
            stop();
        }
        passangerNumber = 0;
        System.out.println("Passangers released");
    }

    @Override
    public void start() {
        isRunning = true;
        setCurrentSpeed(10);
        System.out.println("Bus is starting");
    }

    @Override
    public void stop() {
        isRunning = false;
        setCurrentSpeed(10);
        System.out.println("Bus has stopped");
    }

    @Override
    public void energize() {
        fuelUp(getTankVolume() - getAvailablePetrol());
        System.out.println("Bus has been fueled");
    }
}
