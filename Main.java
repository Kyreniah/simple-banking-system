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

        do {
            switch (option) {
                case 1:
                    createCard();
                    break;
                case 2:
                    login();
                    break;
                case 0:
                    bye();
                    break;
            }
            option = scanner.nextInt();
        } while (option != 0);
    }

    private static void createCard() {
        Card card = Card.generateCard();
        cards.add(card);
        System.out.println("Your card has been created");
        System.out.println("Your card number:");
        System.out.println(card.number);
        System.out.println("Your card PIN:");
        System.out.println(card.pin);
    }

    private static void login() {
        System.out.println("Enter your card number");
        long number = scanner.nextLong();
        System.out.println("Enter your PIN");
        int pin = scanner.nextInt();

        if (cards.stream().anyMatch(c -> c.number == number && c.pin == pin)) {
            System.out.println("You have successfully logged in!");
            int option;
            do {
                System.out.println("1. Balance");
                System.out.println("2. Log out");
                System.out.println("0. Exit");
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("Balance: 0");
                        break;
                    case 2:
                        logout();
                        break;
                    case 0:
                        bye();
                        break;
                }
            } while (option == 1);
        }  else {
            System.out.println("Wrong card number or PIN!");
        }
    }

    private static void logout() {
        System.out.println("You have successfully logged out!");
        startBanking();
    }

    private static void bye() {
        System.out.println("Bye!");
    }
}