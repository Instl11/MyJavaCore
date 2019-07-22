package training.interfaces;

public interface InterfaceRunner {

    public static void main(String[] args) {

        Priceable pizza = new Pizza("neapoletano", 1, 20, Size.L);
        Priceable phone = new CellPhone("Motorolla", "XT15", 1, 250);
        Priceable fridge = new Fridge("LG", "E90", 1, 300);

        printDeliveryPrice(phone);
        printDeliveryPrice(pizza);
        printDeliveryPrice(fridge);

    }

    private static void printDeliveryPrice(Priceable del) {
        System.out.println("Delivery price: " + del.calcDeliveryPrice());
        System.out.println("Order price " + del.calcOrderPrice());
    }
}
