package training.lyambda.comparing;

public class HighTemp {
    private int hTemp;

    public HighTemp(int hTemp) {
        this.hTemp = hTemp;
    }

    public int gethTemp() {
        return hTemp;
    }

    boolean sameTemp (HighTemp ht){
        return ht.gethTemp() == this.gethTemp();
    }
}
