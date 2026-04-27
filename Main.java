package banking;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Card> cards = new ArrayList<Card>();

    public static void main(String[] args) {
        startBanking();
    }

    private static void startBanking() {
        System.out.println("1. Create an account");
        System.out.println("2. Log into account");
        System.out.println("0. Exit");

        int option = scanner.nextInt();

        while (option != 0) {
            switch (option) {
                case 1: createCard();
                    break;
                case 2: login();
                    break;
            }
            option = scanner.nextInt();
        }

        logout();
    }

    private static void createCard() {
        Card card = Card.generateCard();
        cards.add(card);
        System.out.println("Your card has been created");
        System.out.println("Your card number: " + card.number);
        System.out.println("Your card PIN:  " + card.pin);
    }

    private static void login() {
        System.out.println("Enter your card number");
        int number = scanner.nextInt();
        System.out.printf("Enter your PIN");
        int pin = scanner.nextInt();

        if (cards.stream().anyMatch(c -> c.number == number && c.pin == pin)) {
            System.out.println("You have successfully logged in!");
        }  else {
            System.out.printf("Wrong card number or PIN!");
        }
    }

    private static void logout() {
        System.out.println("You have successfully logged out!");
    }
}