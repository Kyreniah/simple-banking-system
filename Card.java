package banking;

import java.util.Arrays;
import java.util.Random;

public class Card {
    final String number;
    final String pin;
    private static final String BIN = "400000";

    public Card(String number, String pin) {
        this.number = number;
        this.pin = pin;
    }

    static Card generateCard() {
        Random rnd = new Random();
        StringBuilder str = new StringBuilder(BIN);
        for (int i = 0; i < 9; i++) {
            str.append(rnd.nextInt(10));
        }
        str.append(calculateCheckSum(str.toString()));
        String number = str.toString();
        String pin = String.format("%04d", rnd.nextInt(10000));
        return new Card(number, pin);
    }

    static int calculateCheckSum(String digits) {
        int[] arr = new int[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            arr[i] = digits.charAt(i) - '0';
        }
        for (int i = 0; i < arr.length; i+=2) {
            arr[i] *= 2;
            if (arr[i] > 9) {
                arr[i] -= 9;
            }
        }
        int sum = Arrays.stream(arr).sum();
        return (10 - (sum % 10)) % 10;
    }

    static boolean isCardNumberValid(String cardNumber) {
        String numberSequence = cardNumber.substring(0, cardNumber.length() - 1);
        String lastDigit = cardNumber.substring(cardNumber.length() - 1);
        int checkSum = calculateCheckSum(numberSequence);
        return checkSum == Integer.parseInt(lastDigit);
    }
}
