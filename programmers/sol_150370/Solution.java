package programmers.sol_150370;

import java.util.*;

/**
 * 1. terms 정보 map으로 저장
 * 2. today int 배열 저장
 * 3. privacies for loop 돌면서 삭제 여부 판단
 * 4. result 반환
 */
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
//        1. terms 정보 map으로 저장
        Map<String, Integer> termMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (String term : terms) {
            String[] split = term.split(" ");
            termMap.put(split[0], Integer.parseInt(split[1]));
        }

        String[] split1 = today.split("[.]");
//        2. today, privacies int 배열, map으로 저장
        List<Integer> todayArr = Arrays.asList(Integer.parseInt(split1[0]),
                Integer.parseInt(split1[1]), Integer.parseInt(split1[2]));

//        3. privacies for loop 돌면서 삭제 여부 판단
        for (int i = 0; i < privacies.length; i++) {
            String privacy = privacies[i];
            String term = privacy.split(" ")[1];
            String[] split = privacy.split(" ")[0].split("[.]");
            List<Integer> dayArr = Arrays.asList(Integer.parseInt(split[0]), Integer.parseInt(split[1]),
                    Integer.parseInt(split[2]));

            calculateDate(termMap.get(term), dayArr);

            if (dayArr.get(0) < todayArr.get(0)) {
                result.add(i);
                continue;
            }

            if (dayArr.get(0) - todayArr.get(0) == 0 && dayArr.get(1) < todayArr.get(1)) {
                result.add(i);
                continue;
            }

            if (dayArr.get(1) - todayArr.get(1) == 0 && dayArr.get(2) < todayArr.get(2)) {
                if (todayArr.get(0) - dayArr.get(0) == 0) {
                    result.add(i);
                }
            }

        }
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i) + 1;
        }

        return answer;
    }

    private void calculateDate(Integer term, List<Integer> dayArr) {
        dayArr.set(1, dayArr.get(1) + term);
        dayArr.set(2, dayArr.get(2) - 1);

        if (dayArr.get(2) == 0) {
            dayArr.set(1, dayArr.get(1) - 1);
            dayArr.set(2, 28);
        }

        if (dayArr.get(1) > 12) {
            dayArr.set(0, dayArr.get(0) + (dayArr.get(1) / 12));
            dayArr.set(1, dayArr.get(1) % 12);
        }

        if (dayArr.get(1) == 0) {
            dayArr.set(0, dayArr.get(0) - 1);
            dayArr.set(1, 12);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = s.solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{
                "2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"
        });
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}