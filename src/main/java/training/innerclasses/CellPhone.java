package training.innerclasses;


import java.awt.event.ActionListener;
import java.security.PublicKey;

public class CellPhone {

    private String make;
    private String model;
    private Display display;
    private RadioModule gsm;

    public interface AbstractPhoneButton{
        void click();
    }

    public CellPhone(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public void turnOn(){
        initDisplay();
        gsm = new RadioModule();
    }

    public void call(String number){
        gsm.call(number);
    }

    private void initDisplay(){
        display = new Display();
    }


    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }
}
