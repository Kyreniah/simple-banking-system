package banking;

import java.util.Random;

public class Card {
    long number;
    int pin;

    public Card(long number, int pin) {
        this.number = number;
        this.pin = pin;
    }

    static Card generateCard() {
        Random rnd = new Random();
        String str = "400000";
        for (int i = 0; i < 10; i++) {
            str += Integer.toString(rnd.nextInt(9));
        }
        long number = Long.parseLong(str);
        int pin = rnd.nextInt(9999);
        return new Card(number, pin);
    }

}
