package programmers.sol_12914;

class Solution {
    public long solution(int n) {
        int[] blocks = new int[2001];
        blocks[1] = 1;
        blocks[2] = 2;

        for (int i = 3; i <= n; i++) {
            blocks[i] = (blocks[i - 1] + blocks[i - 2]) % 1234567;
        }

        return blocks[n];
    }
}