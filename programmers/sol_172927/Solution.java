package programmers.sol_172927;

//PseudoCode
/*
* 1. 광물 배열을 5개씩 묶어서 각 곡괭이마다 점수를 매김
* 2. 높은 점수를 얻는 곡괭이로 작업 피로도 계산
* */

import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int fatigue = 0;
        int bundle = minerals.length / 5;
        int otherMinerals = minerals.length % 5;
        int size = minerals.length;
        Picks p = convert(picks);
        List<String> mineralList;

        for (int i = 0; i < bundle; i++) {
            int index = i * 5;
            mineralList = Arrays.asList(minerals[index], minerals[index + 1],
                    minerals[index + 2], minerals[index + 3], minerals[index + 4]);

            fatigue += getFatigue(p, mineralList);
        }

        if (otherMinerals != 0) {
            mineralList = new ArrayList<>();
            for (int i = 0; i < otherMinerals; i++) {
                mineralList.add(minerals[size - 1 - i]);
            }

            fatigue += getFatigue(p, mineralList);
        }

        return fatigue;
    }

    private int getFatigue(Picks p, List<String> minerals) {
        int diaScore = 0;
        int ironScore = 0;
        int stoneScore = 0;

        if (!p.hasNoPick()) {
            if (p.hasDiamondPick()) {
                diaScore = getDiamondPickScore(minerals);
            }

            if (p.hasIronPick()) {
                ironScore = getIronPickScore(minerals);
            }

            if (p.hasStonePick()) {
                stoneScore = getStonePickScore(minerals);
            }

            int pick = choosePick(diaScore, ironScore, stoneScore);
            p.decreasePick(pick);
            return getFatigue(pick, minerals);
        }

        return 0;
    }

    private int choosePick(int diaScore, int ironScore, int stoneScore) {
        if (diaScore >= ironScore && diaScore >= stoneScore) {
            return 1;
        } else if (ironScore >= stoneScore && ironScore >= diaScore) {
            return 2;
        } else if (stoneScore >= diaScore && stoneScore >= ironScore) {
            return 3;
        } else {
            return 0;
        }
    }

    class Picks {
        int diamondPick;
        int ironPick;
        int stonePick;

        boolean hasNoPick() {
            return diamondPick == 0 && ironPick == 0 && stonePick == 0;
        }

        boolean hasDiamondPick() {
            return diamondPick > 0;
        }

        boolean hasIronPick() {
            return ironPick > 0;
        }

        boolean hasStonePick() {
            return stonePick > 0;
        }

        public void decreasePick(int pick) {
            switch (pick) {
                case 1:
                    diamondPick -= 1;
                    break;
                case 2:
                    ironPick -= 1;
                    break;
                case 3:
                    stonePick -= 1;
                    break;
            }
        }
    }

    int getDiamondPickScore(List<String> minerals) {
        int score = 0;
        for (String mineral : minerals) {
            switch (mineral) {
                case "diamond":
                    score += 25;
                    break;
                case "iron":
                    score += 3;
                    break;
                case "stone":
                    score += 1;
                    break;
            }
        }

        return score;
    }

    int getIronPickScore(List<String> minerals) {
        int score = 0;
        for (String mineral : minerals) {
            switch (mineral) {
                case "diamond":
                    score += 3;
                    break;
                case "iron":
                    score += 25;
                    break;
                case "stone":
                    score += 1;
                    break;
            }
        }

        return score;
    }

    int getStonePickScore(List<String> minerals) {
        int score = 0;
        for (String mineral : minerals) {
            switch (mineral) {
                case "diamond":
                    score += 1;
                    break;
                case "iron":
                    score += 3;
                    break;
                case "stone":
                    score += 25;
                    break;
            }
        }

        return score;
    }

    Picks convert(int[] picks) {
        Picks p = new Picks();

        p.diamondPick = picks[0];
        p.ironPick = picks[1];
        p.stonePick = picks[2];

        return p;
    }

    int getFatigue(int pick, List<String> minerals) {
        int fatigue = 0;
        for (String mineral : minerals) {
            if (pick == 1) {
                // 다이아
                fatigue += 1;
            } else if (pick == 2) {
                // 철
                switch (mineral) {
                    case "diamond":
                        fatigue += 5;
                        break;
                    case "iron":
                    case "stone":
                        fatigue += 1;
                        break;
                }
            } else {
                // 돌
                switch (mineral) {
                    case "diamond":
                        fatigue += 25;
                        break;
                    case "iron":
                        fatigue += 5;
                        break;
                    case "stone":
                        fatigue += 1;
                        break;
                }
            }
        }

        return fatigue;
    }

    public static void main(String[] args) {
        int[] picks = {1, 1, 0};
        String[] minerals = {"stone", "stone", "iron", "stone", "diamond", "diamond", "diamond", "diamond", "diamond", "diamond"};
        Solution s = new Solution();
        System.out.println(s.solution(picks, minerals));
    }
}