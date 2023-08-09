package programmers.sol_12980;

import java.util.*;

/**
 * 1. 한 칸 뛴다.
 * 2. n의 약수를 찾는다.
 * 3. 뛸 때마다 가까운 소수를 찾는다.
 * 4.
 */
public class Solution {
    public int solution(int n) {
        int energy = 0;

        while (n != 0) {
            if (n % 2 == 1) {
                energy++;
            }
            n /= 2;
        }

        return energy;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(5));
    }
}