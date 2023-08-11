package programmers.sol_62048;

/**
 * 1. 두 수의 최대 공약수 구하기
 * 2. 두 수 중 (작은 수 - 1 한 값 + 큰 수) * 최대 공약수 = 못 쓰는 칸
 * 3. (w * h - 못 쓰는 칸) 반환
 */
class Solution {
    public long solution(int w, int h) {
        int maxDivisor = getGCD(w, h);
        int small = Math.min(w / maxDivisor, h / maxDivisor);
        int big = Math.max(w / maxDivisor, h / maxDivisor);
        int unused = (small - 1 + big) * maxDivisor;

        return ((long)w * (long)h) - unused;
    }

    int getGCD(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return getGCD(num2, num1%num2);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(100000000, 99999999));
    }
}