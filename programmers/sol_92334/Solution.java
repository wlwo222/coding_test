package programmers.sol_92334;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Set<String> reportSet = Arrays.stream(report).collect(Collectors.toSet());
        Set<String> blackList = new HashSet<>();
        HashMap<String, Long> banIds = new HashMap<>();
        HashMap<String, Set<String>> reportMap = new HashMap<>();

        for (String reports : reportSet) {
            String id = reports.split(" ")[0];
            String target = reports.split(" ")[1];
            Set<String> value = new HashSet<>();

            if (reportMap.containsKey(id)) {
                value = reportMap.get(id);
            }
            value.add(target);
            reportMap.put(id, value);
            banIds.put(target, banIds.getOrDefault(target, 0L) + 1);

            if (banIds.get(target) >= k || k == 1) {
                blackList.add(target);
            }
        }

        int[] answer = new int[id_list.length];

        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            Set<String> targets = reportMap.getOrDefault(id, new HashSet<>());
            long count = targets.stream().filter(target -> blackList.contains(target)).count();
            answer[i] = (int) count;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
        int[] solution = s.solution(id_list, report, k);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }
}