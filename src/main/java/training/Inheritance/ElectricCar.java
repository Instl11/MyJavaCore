package training.Inheritance;

public class ElectricCar extends Auto {

    private int batteryVolume;
    private int passangersNumber;


    public ElectricCar(String producer, String model, int batteryVolume, int passangersNumber) {
        super(producer, model, new Engine());
        this.batteryVolume = batteryVolume;
        this.passangersNumber = passangersNumber;
    }

    public int getBatteryVolume() {
        return batteryVolume;
    }

    public void setBatteryVolume(int batteryVolume) {
        this.batteryVolume = batteryVolume;
    }

    public int getPassangersNumber() {
        return passangersNumber;
    }

    public void setPassangersNumber(int passangersNumber) {
        this.passangersNumber = passangersNumber;
    }

    private void charge(){
        System.out.println("Battery is charging");
    }

    @Override
    public void energize() {
        charge();
    }
}
