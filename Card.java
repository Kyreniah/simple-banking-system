package banking;

import java.util.Random;

public class Card {
    String number;
    String pin;

    public Card(String number, String pin) {
        this.number = number;
        this.pin = pin;
    }

    static Card generateCard() {
        Random rnd = new Random();
        StringBuilder str = new StringBuilder("400000");
        for (int i = 0; i < 10; i++) {
            str.append(rnd.nextInt(10));
        }
        String number = str.toString();
        String pin = String.format("%04d", rnd.nextInt(10000));
        return new Card(number, pin);
    }

}
