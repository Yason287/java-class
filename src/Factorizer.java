import java.util.Scanner;

public class Factorizer {
    public static void main(String[] args) {

        int result = 0;
        int counter = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("What number would you like to factor? ");
        int input = sc.nextInt();

        System.out.println("The factors of " + input + " are:");

        for (int i = 1; i <= input; i++) {
            if (input % i == 0) {
                result += i;
                counter++;
                System.out.print(i + " ");
            }
        }

        result -= input;

        System.out.println();
        System.out.println(input + " has " + counter + " factors.");

        if (input == result) {
            System.out.println(input + " is a perfect number.");
        } else {
            System.out.println(input + " is not a perfect number.");
        }

        if (input > 1 && counter == 2) {
            System.out.println(input + " is a prime number.");
        } else {
            System.out.println(input + " is not a prime number.");
        }

        sc.close();
    }
}
