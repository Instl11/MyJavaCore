package training.OOP;

public class Main {
    public static void main(String[] args) {

        System.out.println(Dog.getDogsCount());

        Dog lab = new Dog();
        lab.setName("Charley");
        lab.setSize(Size.BIG);
        lab.bite();
        System.out.println(Dog.getDogsCount());

        Dog dob = new Dog(4, 1, "Dobby", Size.AVERAGE);
        System.out.println(Dog.getDogsCount());
        dob.bite();

        Dog cat = new Dog(4, 1, "Pyshy", Size.SMALL);
        System.out.println(Dog.getDogsCount());
        cat.bite();


        Size s = Size.SMALL;
        Size[] values = Size.values();
    }

}
