package baekjoon.sol_2720;

import java.util.Scanner;

//Problem 2720
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] changes = new int[count];

        for (int i = 0; i < count; i++) {
            changes[i] = scanner.nextInt();
            Main.calculateChange(changes[i]);
        }

    }

    static void calculateChange(int change) {
        int[] coins = new int[4];
        final int QUARTER = 25;
        final int DIME = 10;
        final int NICKEL = 5;
        final int PENNY = 1;

        while (change != 0) {
            if (change >= QUARTER) {
                change = change - QUARTER;
                coins[0] += 1;
            } else if (change >= DIME) {
                change = change - DIME;
                coins[1] += 1;
            } else if (change >= NICKEL) {
                change = change - NICKEL;
                coins[2] += 1;
            } else if (change >= PENNY) {
                change = change - PENNY;
                coins[3] += 1;
            }
        }

        for (int coin : coins) {
            System.out.println(coin);
        }
    }
}
