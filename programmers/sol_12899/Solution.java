package programmers.sol_12899;

class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();

        while(n != 0){
            int a = n % 3;
            n = n / 3;

            if (a == 0) {
                n = n - 1;
                a = 4;
            }

            answer.insert(0, a);

        }

        return answer.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(10));
//        System.out.println(s.solution(2));
//        System.out.println(s.solution(3));
//        System.out.println(s.solution(4));
    }
}