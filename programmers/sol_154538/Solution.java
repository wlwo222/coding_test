package programmers.sol_154538;

import java.util.HashSet;

class Solution {
    public int solution(int x, int y, int n) {
        int count = 0;
        HashSet<Integer> xValue = new HashSet<>();
        HashSet<Integer> next;
        xValue.add(x);

        while (!xValue.isEmpty()) {
            if (xValue.contains(y)) {
                return count;
            }

            next = new HashSet<>();

            for (Integer num : xValue) {
                if (num + n <= y) {
                    next.add(num + n);
                }

                if (num * 2 <= y) {
                    next.add(num * 2);
                }

                if (num * 3 <= y) {
                    next.add(num * 3);
                }
            }

            xValue = next;
            count++;
        }

        return -1;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(10, 40, 5));
    }
}