
package programmers.sol_17681;

import java.util.ArrayList;
import java.util.List;

/**
 *  1. n 만큼 for loop
 *  2. 각 배열의 행을 bit or 연산을 한다.
 *  3. 그 값을 #, " " 으로 바꿔서 answer 배열에 저장한다.
 */
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            int a1 = arr1[i];
            int a2 = arr2[i];

            List<Character> a1BitArr = toCharArray(a1, n);
            List<Character> a2BitArr = toCharArray(a2, n);
            StringBuilder map = new StringBuilder();

            for (int j = 0; j < n; j++) {
                char a1Char = a1BitArr.get(j);
                char a2Char = a2BitArr.get(j);

                if (a1Char == '1' || a2Char == '1') {
                    map.append("#");
                } else {
                    map.append(" ");
                }
            }

            answer[i] = map.toString();
        }
        return answer;
    }

    List<Character> toCharArray(int num, int n) {
        List<Character> arr = new ArrayList<>();
        char[] bitArray = Integer.toBinaryString(num).toCharArray();
        int length = n - bitArray.length;

        for (char c : bitArray) {
            arr.add(c);
        }

        if (length > 0) {
            for (int i = 0; i < length; i++) {
                arr.add(0, '0');
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 6;
        int[] arr1 = {46, 33, 33, 22, 31, 50};
        int[] arr2 = {27, 56, 19, 14, 14, 10};
        String[] a = s.solution(n, arr1, arr2);

        for (String s1 : a) {
            System.out.println(s1);
        }
    }
}