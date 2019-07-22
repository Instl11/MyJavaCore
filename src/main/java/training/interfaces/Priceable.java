package training.interfaces;

public interface Priceable extends Orderable, Deliverable {

    default int calcPrice(){
        return calcOrderPrice() + calcDeliveryPrice();
    }

    static void doSmth(){
        System.out.println("Тест статического метода с реализацией в интерфейсе");
    }
}
