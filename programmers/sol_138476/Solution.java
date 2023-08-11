package programmers.sol_138476;

import java.util.*;

/**
 *  1. 종류와 갯수를 저장하는 map 만들기
 *  2. 갯수 내림차순으로 정렬
 *  3. for문 돌면서 k값이 0이 될 때까지 담음
 */
class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Set<Integer> tangerines = new HashSet<>();

//        1. 종류와 갯수를 저장하는 map 만들기
        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
//        2. 갯수 내림차순으로 배열 만들기
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> map.get(b) - map.get(a));
//        3. 배열 Set으로 바꾸고 그 크기를 반환하기
        for (Integer key : list) {
            if (k <= 0) {
                break;
            }
            tangerines.add(key);
            k -= map.get(key);
        }

        return tangerines.size();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
    }
}