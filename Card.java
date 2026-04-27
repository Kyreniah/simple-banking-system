package banking;

import java.util.Random;

public class Card {
    int number;
    int pin;

    public Card(int number, int pin) {
        this.number = number;
        this.pin = pin;
    }

    static Card generateCard() {
        Random rnd = new Random();
        int number = rnd.nextInt(9999);
        int pin = rnd.nextInt(9999);
        return new Card(number, pin);
    }

}
