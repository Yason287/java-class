import java.util.Scanner;
import java.util.Random;

public class LuckySevens {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("How many dollars do you have? ");
        int amount = sc.nextInt();

        int maxAmount = amount;
        int rollCount = 0;
        int rollAtMax = 0;

        while (amount > 0) {
            int dice1 = rand.nextInt(6) + 1; // 1..6
            int dice2 = rand.nextInt(6) + 1; // 1..6
            rollCount++;

            if (dice1 + dice2 == 7) {
                amount += 4;
            } else {
                amount -= 1;
            }

            if (amount > maxAmount) {
                maxAmount = amount;
                rollAtMax = rollCount;
            }
        }

        System.out.println("You are broke after " + rollCount + " rolls.");
        System.out.println("You should have quit after " + rollAtMax +
                " rolls when you had $" + maxAmount + ".");

        sc.close();
    }
}
