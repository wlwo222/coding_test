package baekjoon.sol_2869;

import java.util.Scanner;

//Problem 2869
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int climb = scanner.nextInt();
        int slide = scanner.nextInt();
        int goal = scanner.nextInt();
        int day = (int) Math.ceil((double) (goal - climb) / (climb - slide));

        if (day <= 0) {
            day = 1;
        } else {
            day += 1;
        }

        System.out.println(day);
    }
}