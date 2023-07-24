package baekjoon.sol_2566;

import java.util.Scanner;

//Problem 2566
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] row = new int[3];
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                int a = scanner.nextInt();
                if (row[0] <= a) {
                    row[0] = a;
                    row[1] = i;
                    row[2] = j;
                }
            }
        }
        System.out.println(row[0]);
        System.out.println(String.format("%s %s", row[1], row[2]));
    }
}
