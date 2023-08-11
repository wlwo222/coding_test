package programmers.sol_154540;

import java.util.*;

/**
 * 1. 섬을 찾는다.
 * 1-1) 못 찾는다면 [-1] 반환
 * 2. 연결된 섬을 찾고 몇 일을 머물 수 있는지 계산한다.
 * 3. 연결된 섬을 다 찾았다면 break;
 */
class Solution {
    List<Integer> dayCounts = new ArrayList<>();
    public int[] solution(String[] maps) {
        char[][] splitMaps = new char[maps.length][maps[0].toCharArray().length];

        for (int i = 0; i < maps.length; i++) {
            splitMaps[i] = maps[i].toCharArray();
        }

        for (int i = 0; i < splitMaps.length; i++) {
            for (int j = 0; j < splitMaps[0].length; j++) {
                char island = splitMaps[i][j];

                if (island != 'X' && island != 'O') {
                    // 정답 리스트에 0 추가
                    dayCounts.add(0);
                    // dfs
                    findSideIsland(i, j, splitMaps);
                }
            }
        }

        if (dayCounts.size() == 0) {
            return new int[]{-1};
        }

        dayCounts.sort(Comparator.comparingInt(a -> a));
        int[] answer = new int[dayCounts.size()];

        for (int i = 0; i < dayCounts.size(); i++) {
            answer[i] = dayCounts.get(i);
        }

        return answer;
    }

    private void findSideIsland(int i, int j, char[][] maps) {
        if (j < 0 || i < 0 || i > maps.length - 1 || j > maps[0].length - 1) {
            return;
        }

        char island = maps[i][j];

        if (island == 'X' || island == 'O') {
            return;
        }

        // 방문했던 섬은 O로 변경
        maps[i][j] = 'O';

        // 리스트의 마지막 요소에 현 요소를 누적
        int val = dayCounts.get(dayCounts.size()-1);
        val += Integer.parseInt(String.valueOf(island));
        dayCounts.set(dayCounts.size()-1, val);

        //동
        findSideIsland(i, j - 1, maps);
        //서
        findSideIsland(i, j + 1, maps);
        //남
        findSideIsland(i + 1, j, maps);
        //북
        findSideIsland(i - 1, j, maps);
    }

    public static void main(String[] args) {
        String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};
        Solution s = new Solution();
        int[] answer = s.solution(maps);

        for (int i : answer) {
            System.out.print(i);
        }
    }
}