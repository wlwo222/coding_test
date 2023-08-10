package programmers.sol_1845;

import java.util.Arrays;

class Solution {
    public int solution(int[] nums) {
        int[] numbers = Arrays.stream(nums).distinct().toArray();
        return Integer.min(numbers.length,  nums.length / 2);
    }
}