package programmers.sol_121683;

import java.util.*;

/**
 * 1. 알파벳 별 등장 횟수 계산
 * 2. 외톨이 알파벳 검사
 * 3. 외톨이 알파벳을 알파벳순으로 정렬하여 문자열로 변환
 * 4. 외톨이 알파벳이 없을 경우 "N" 반환
 */
public class Solution {

    public static String solution(String inputString) {
        Map<Character, Integer> charCount = new HashMap<>();
        Set<Character> alphabets = new HashSet<>();

        // 알파벳 별 등장 횟수 계산
        char[] split = inputString.toCharArray();
        for (char s : split) {
            charCount.put(s, charCount.getOrDefault(s, 0) + 1);
        }

        // 알파벳 검사
        for (Map.Entry<Character, Integer> mapEntry : charCount.entrySet()) {
            char key = mapEntry.getKey();
            Integer count = mapEntry.getValue();

            if (count >= 2) {
                // 2개 이상, 2번 이상 반복되는 경우
                String bundle = String.valueOf(key).repeat(count);
                if (!inputString.contains(bundle)) {
                    alphabets.add(key);
                }
            }
        }
        // 외톨이 알파벳을 알파벳순으로 정렬
        alphabets.stream().sorted();
        // 외톨이 알파벳이 없을 경우 "N" 반환
        if (alphabets.size() == 0) {
            return "N";
        }

        StringBuilder answer = new StringBuilder();

        for (Character alphabet : alphabets) {
            answer.append(alphabet);
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("aabbccddeffggbbaacg")); // "abcg"
        System.out.println(solution("aaabbbcccdddeee")); // "N"
    }
}