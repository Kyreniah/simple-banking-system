package banking;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        startBanking();

    }

    private static void startBanking() {
        System.out.println("1. Create an account");
        System.out.println("2. Log into account");
        System.out.println("0. Exit");

        int option = scanner.nextInt();

        switch (option) {
            case 1: createCard();
                break;
            case 2: login();
                break;
            case 3:
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    private static void createCard() {
        Card card = Card.generateCard();
        System.out.println("Your card has been created");
        System.out.println("Your card number: " + card.number);
        System.out.println("Your card PIN:  " + card.pin);
    }

    private static void login() {
        System.out.println("Enter your card number");
        int number = scanner.nextInt();
        System.out.printf("Enter your PIN");
        int pin = scanner.nextInt();
    }
}