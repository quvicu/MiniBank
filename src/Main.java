package PACKAGE_NAME;

import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        double currentBalance = 100;

        do {
            printStart();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    deposit(currentBalance, scanner);
                    break;
                case 2:
                    withdraw(currentBalance, scanner);
                    break;
                case 3:
                    printCurrentBalance(currentBalance);
                    break;
                case 4:
                    interestCalculator(scanner);
                    break;
                case 0:
                    printEndMessage();
                    break;
                default:
                    System.out.println("Ungültige Eingabe");
            }
        }  while (choice != 0);
    }

    private static void printStart() {
        System.out.println("\n---Willkommen---\n");
        System.out.println("Drücken Sie die 1 fürs Einzahlen");
        System.out.println("Drücken SIe die 2 fürs Auszahlen");
        System.out.println("Drücken Sie die 3 um ihren Kontostand zu sehen");
        System.out.println("Drücken Sie die 4 um den Zinsrechner zu bezahlen");
        System.out.println("Drücken Sie die 0 um das Programm zu beenden\n");
    }

    private static void deposit(double currentBalance, Scanner scanner) {
        System.out.println("Betrag einzahlen:  ");
        double amount = scanner.nextDouble();
        if (amount >= 1000) {
            System.out.println("Sie können nicht mehr als 1000 € einzahlen");
        } else {
            currentBalance += amount;
            System.out.println("Ihr Kontostand beträgt:" + currentBalance + "€. \nSie haben erfolgreich:" + amount + "€ eingezahlt");
        }
    }

    private static void withdraw(double currentBalance, Scanner scanner) {
        System.out.println("Betrag abheben:  ");
        double withdrawValue = scanner.nextDouble();
        if (withdrawValue > currentBalance) {
            System.out.println("Fehler!! Sie haben nicht genug Geld auf ihrem Konto");
        } else if (withdrawValue >= 1000) {
            System.out.println("Sie können nicht mehr als 1000 € auszahlen");
        } else {
            currentBalance -= withdrawValue;
            System.out.println("Ihr Kontostand beträgt:" + currentBalance + "€. \nSie haben erfolgreich:" + withdrawValue + "€ ausgezhalt");
        }
    }

    private static void printCurrentBalance(double currentBalance) {
        System.out.println("Ihr Kontostand beträgt:" + currentBalance + "€");
    }

    private static void interestCalculator(Scanner scanner) {
        double startingCapital = 0;
        double interestRate = 0;
        double duration = 0;
        double finalCapital = 0;
        double interest = 0;

        System.out.print("Enter Capital: ");
        startingCapital = scanner.nextDouble();

        System.out.print("Enter Interest rate: ");
        interestRate = scanner.nextDouble();

        System.out.print("Enter Duration: ");
        duration = scanner.nextDouble();

        for (int i = 1; i <= duration; i++) {
            finalCapital = startingCapital * Math.pow(1 + interestRate, i);
            double capitalRounded = rounder(finalCapital);
            System.out.println("Year: " + i + " Capital: " + capitalRounded);

            interest = finalCapital - startingCapital;
            double interestRounded = rounder(interest);
            System.out.println("Year: " + i + " Interest: " + interestRounded + "\n");
        }
    }

    private static double rounder(double number) {
         return new BigDecimal(number)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }

    private static void printEndMessage() {
        System.out.println("Auf Wiedersehen  ");
    }
}

