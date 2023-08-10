package programmers.sol_42748;

import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] command = commands[i];
            int start = command[0] -1;
            int end = command[1];
            int target = command[2] - 1;
            int range = end - start;
            int[] sortedArray = new int[range == 0 ? 1 : range];

            for (int j = 0; j < range; j++) {
                sortedArray[j] = array[start + j];
            }
            Arrays.sort(sortedArray);
            answer[i] = sortedArray[target];
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] s1 = s.solution(array, commands);
        for (int i : s1) {
            System.out.print(i + " ");
        }
    }
}