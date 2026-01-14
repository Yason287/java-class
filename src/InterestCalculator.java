import java.util.Scanner;

public class InterestCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How much do you want to invest? ");
        double currentBalance = sc.nextDouble();

        System.out.print("How many years are investing? ");
        int years = sc.nextInt();

        System.out.print("What is the annual interest rate % growth? ");
        double annualRate = sc.nextDouble();

        System.out.println("\nCalculating...");

        double quarterlyRate = annualRate / 4.0;

        for (int year = 1; year <= years; year++) {
            double begin = currentBalance;

            for (int q = 0; q < 4; q++) {
                currentBalance *= (1 + quarterlyRate / 100.0);
            }

            double earned = currentBalance - begin;

            System.out.printf("Year %d:%n", year);
            System.out.printf("Began with $%.2f%n", begin);
            System.out.printf("Earned $%.2f%n", earned);
            System.out.printf("Ended with $%.2f%n%n", currentBalance);
        }

        sc.close();
    }
}
