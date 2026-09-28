import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    private static final double MAX_DEPOSIT_AMOUNT = 1000;
    private static final double MAX_WITHDRAW_AMOUNT = 1000;
    private static final double MIN_WITHDRAW_AMOUNT = 0;
    private static String formatAmount(double zahl) {
        long cents = Math.round(zahl * 100);
        long euroTeil = cents / 100;
        long centTeil = cents % 100;

        return String.format("%,d", euroTeil)
                .replace(",", ".")
                + ","
                + String.format("%02d", centTeil)
                + " €";

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        double currentBalance = 100;

        do {
            printStart();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    currentBalance = deposit(currentBalance, scanner);
                    break;
                case 2:
                    currentBalance = withdraw(currentBalance, scanner);
                    break;
                case 3:
                    printCurrentBalance(currentBalance);
                    break;
                case 4:
                    calculateInterest(scanner);
                    break;
                case 0:
                    printEndMessage();
                    break;
                default:
                    System.out.println("Ungültige Eingabe");
            }
        } while (choice != 0);
    }

    private static void printStart() {
        System.out.println("\n---Willkommen---\n");
        System.out.println("Drücken Sie die 1 fürs Einzahlen");
        System.out.println("Drücken SIe die 2 fürs Auszahlen");
        System.out.println("Drücken Sie die 3 um ihren Kontostand zu sehen");
        System.out.println("Drücken Sie die 4 um den Zinsrechner zu bezahlen");
        System.out.println("Drücken Sie die 0 um das Programm zu beenden\n");
    }

    private static double deposit(double currentBalance, Scanner scanner) {
        System.out.println("Betrag einzahlen: ");
        double amount = scanner.nextDouble();
        if (amount > MAX_DEPOSIT_AMOUNT) {
            System.out.println("Sie können nicht mehr als 1.000,00 € einzahlen");
            return currentBalance;
        } else {
            currentBalance += amount;
            System.out.println("Sie haben erfolgreich " + formatAmount(amount) + " eingezahlt");
            System.out.println("Ihr neuer Kontostand beträgt: " + formatAmount(currentBalance));
            return currentBalance;
        }
    }

    private static double withdraw(double currentBalance, Scanner scanner) {
        System.out.println("Betrag abheben:  ");
        double withdrawValue = scanner.nextDouble();
        if (withdrawValue > currentBalance) {
            System.out.println("Fehler!! Sie haben nicht genug Geld auf ihrem Konto");
            return currentBalance;
        } else if (withdrawValue > MAX_WITHDRAW_AMOUNT) {
            System.out.println("Sie können nicht mehr als 1000 € auszahlen");
            return currentBalance;
        } else if (withdrawValue < MIN_WITHDRAW_AMOUNT) {
            System.out.println("Sie können keine negativen Beträge abheben");
            return currentBalance;
        } else {
            currentBalance -= withdrawValue;
            System.out.println("Ihr Kontostand beträgt:" + formatAmount(currentBalance) + ".\nSie haben erfolgreich:" + formatAmount(withdrawValue) + "ausgezhalt");
            return currentBalance;
        }
    }

    private static void printCurrentBalance(double currentBalance) {
        System.out.println("Ihr Kontostand beträgt:" + formatAmount(currentBalance));
    }

    private static void calculateInterest(Scanner scanner) {
        double startingCapital;
        double interestRate;
        int duration;

        double capitalWeg2;

        System.out.print("Geben Sie ihr Kapital an: ");
        startingCapital = scanner.nextDouble();

        System.out.print("Geben Sie die Zinsrate als Dezimalzahl an (zum Beispiel gib 0,05 für 5% ein): ");
        interestRate = scanner.nextDouble();

        System.out.print("Geben Sie die Laufzeit in Jahren an: ");
        duration = scanner.nextInt();

        double capitalWeg1 = startingCapital;  // einmal auf 1000 setzen

        for (int i = 1; i <= duration; i++) {
            capitalWeg1 += capitalWeg1 * interestRate;// wächst jedes Jahr weiter
            System.out.println("Jahr: " + i + "\nGesamtkapital: " + roundDecimal(capitalWeg1) + " Zinsen: " + roundDecimal(capitalWeg1 - startingCapital));
        }
        System.out.println("Weg 1: " + roundDecimal(capitalWeg1));

        capitalWeg2 = startingCapital * Math.pow(1 + interestRate, duration);
        System.out.println("Weg 2: " + roundDecimal(capitalWeg2));

        boolean check = roundDecimal(capitalWeg1) == roundDecimal(capitalWeg2);
        System.out.println(check);
    }

    private static double roundDecimal(double number) {
        return new BigDecimal(number)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }

    private static void printEndMessage() {
        System.out.println("Auf Wiedersehen  ");
    }
}

