package training.collectionsClass.set;

import java.util.Objects;

public class Car {

    private final String carBrand;
    private final String model;
    private  final int pricePerDay;

    public Car(String carBrand, String model, int pricePerDay) {
        this.carBrand = carBrand;
        this.model = model;
        this.pricePerDay = pricePerDay;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public String getModel() {
        return model;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Car car = (Car) obj;
        return getPricePerDay() == car.getPricePerDay() &&
                Objects.equals(getCarBrand(), car.getCarBrand()) &&
                Objects.equals(getModel(), car.getModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCarBrand(), getModel(), getPricePerDay());
    }

    @Override
    public String toString() {
        return "Car{" +
                "carBrand='" + carBrand + '\'' +
                ", model='" + model + '\'' +
                ", pricePerDay=" + pricePerDay +
                '}';
    }
}
