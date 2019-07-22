package training.innerclasses;

public class RadioModule {

    public RadioModule() {
        System.out.println("RM initialized");
    }

    public void call(String number) {
        int length = 10;

        class GSMModule {
            private String phoneNumber;
            private int validNumber;

            public GSMModule(String phoneNumber) {
                this.phoneNumber = phoneNumber;
            }

            public boolean isValid() {
                if (phoneNumber.length() != length) {
                    return false;
                } else {
                    try {
                        validNumber = Integer.parseInt(phoneNumber);
                        return true;
                    } catch (NumberFormatException e) {
                        return false;
                    }
                }
            }
            public void dialin() {
                if (isValid()) {
                    System.out.println("Calling number" + validNumber);
                }else System.out.println("Number is invalid, pls input correct number");
            }
        }

        GSMModule module = new GSMModule(number);
        module.dialin();
    }
}
