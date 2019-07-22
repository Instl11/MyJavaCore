package training.OOP;

public class Dog {

    private static int dogsCount = 0;

    public static final int PAWS = 4;
    public static final int TAIL = 1;

    private String name;
    private Size size = Size.UNDEFINED;

    public Dog() {
        dogsCount++;
    }

    public Dog(int paws, int tail, String name, Size size) {
        this.name = name;
        this.size = size;
        dogsCount++;

    }


    public static int getDogsCount() {
        return dogsCount;
    }


    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void bark() {

        switch (size) {

            case BIG:
                System.out.println("WOOOOOOOOOOOF");
                break;
            case AVERAGE:
                System.out.println("WOOOoooof");
                break;
            case SMALL:
                System.out.println("Wof");
            default:
                System.out.println("Size undefined");
        }


    }

    public void bite() {
        if (dogsCount > 2) {
            System.out.println("Dogs are biting you");
        } else {
            bark();
        }
    }


}
