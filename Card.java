package banking;

import java.util.Random;

public class Card {
    String number;
    int pin;

    public Card(String number, int pin) {
        this.number = number;
        this.pin = pin;
    }

    static Card generateCard() {
        Random rnd = new Random();
        String str = "400000";
        for (int i = 0; i < 10; i++) {
            str += Integer.toString(rnd.nextInt(9));
        }
        String number = str;
        int pin = rnd.nextInt(9999);
        return new Card(number, pin);
    }

}
