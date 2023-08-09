package programmers.sol_42885;

import java.util.*;

/**
 * 1. people 정렬
 * 2. 첫 번째 사람 (가벼운 사람)과 마지막 사람 (무거운 사람)과 체중을 더한 무게가 limit을 넘지 않는다면 태우기
 * 2-1) 만약 넘는다면 첫 번째 사람만 태워보내기
 */
class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;
        int i = 0;
        int j = people.length - 1;

        while (i <= j) {
            Integer p1 = people[i];
            Integer p2 = people[j];

            if (p1 + p2 <= limit) {
                i++;
            }
            answer++;
            j--;
        }

        return answer;
    }
}