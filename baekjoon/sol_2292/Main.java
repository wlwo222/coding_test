package baekjoon.sol_2292;

import java.util.Scanner;

//Problem 2292
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        int minimum = 1;
        int count = 1;

        while (minimum < target) {
            minimum += count * 6;
            count++;
        }

        System.out.println(count);
    }

}