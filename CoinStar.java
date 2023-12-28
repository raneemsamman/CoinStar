/**
*CoinStar.java
* @description Takes in coins, calculates value, and returns cash
* @ author R Samman
* @version 2.0 2022-02-04
*/


import java.util.Scanner;

public class CoinStar {

// --- attributes ---

    private int[] coinCounts = new int[11];
    private static final int[] COIN_VALUES = {1, 5, 10, 25, 50, 100, 500, 1000, 2000, 5000, 10000};
    private Scanner scan = new Scanner(System.in);


// --- methods ----


/** Constructor */
    public CoinStar() {}

  /** takes in coins from user */

    public void intake() {
        String[] coinNames = {"pennies", "nickels", "dimes", "quarters", "halfDollars", "ones", "fives", "tens", "twenties", "fifties", "hundreds"};

        for (int i = 0; i < coinCounts.length; i++) {
            System.out.print("Enter the number of " + coinNames[i] + ": ");
            coinCounts[i] = scan.nextInt();
        }
    }

    public int totalValue() {
        int money = 0;
        for (int i = 0; i < coinCounts.length; i++) {
            money += COIN_VALUES[i] * coinCounts[i];
        }

        System.out.println("You have $" + (money / 100.0));
        return money;
    }

    public void makeChange(int money) {
        for (int i = COIN_VALUES.length - 1; i >= 0; i--) {
            if (money >= COIN_VALUES[i]) {
                int count = money / COIN_VALUES[i];
                money %= COIN_VALUES[i];
                System.out.println("You get " + count + " $" + COIN_VALUES[i] / 100.0 + " bills/coins");
            }
        }
    }

    public static void main(String[] args) {
        CoinStar machine = new CoinStar();
        machine.intake();
        int n = machine.totalValue();
        machine.makeChange(n);
    }
}
