package training.OOP;

public enum Size {
    SMALL("S"), AVERAGE("M"), BIG("L"), UNDEFINED("");

    private String abbreveation;

    Size(String abbreveation) {
        this.abbreveation = abbreveation;
    }

    public String getAbbreveation() {
        return abbreveation;
    }
}
