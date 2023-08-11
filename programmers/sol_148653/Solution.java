package programmers.sol_148653;

class Solution {
    public int solution(int storey) {
        int answer = 0;

        String string = String.valueOf(storey);
        String[] nums = string.split("");

        for (int i = nums.length; i > 0; i--) {
            int num = Integer.parseInt(nums[i - 1]);

            if (i == 1) {
                if (num <= 5) {
                    answer += num;
                } else {
                    answer += (10 - num) + 1;
                }
                break;
            }

            int nextNum = Integer.parseInt(nums[i - 2]);

            if (num == 5) {
                answer += num;
                if (nextNum >= 5) {
                    nums[i - 2] = String.valueOf(Integer.parseInt(nums[i - 2]) + 1);
                }
            } else if (num < 5) {
                answer += num;
            } else {
                answer += (10 - num);
                nums[i - 2] = String.valueOf(Integer.parseInt(nums[i - 2]) + 1);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(555));
    }
}