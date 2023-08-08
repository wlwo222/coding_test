package programmers.sol_176962;

//PseudoCode
/*
* 1. 일찍 시작하는 순서로 과목 정렬
* 2. 걸리는 시간과 다음 과목이 시작하는 시간 비교
* 3. 끝나는 경우 answer에 저장
* 4. 안끝나는 경우 과목명만 배열에 담아뒀다가 answer에 저장
* */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Solution {
    public String[] solution(String[][] plans) throws ParseException {
        String[] answer = new String[plans.length];
        String[] todos = new String[plans.length];

        Arrays.sort(plans, (Comparator.comparing(x -> (x[1]))));

        for (int i = 0; i < plans.length - 1; i++) {
            String[] nextPlan;
            String[] plan = plans[i];
            nextPlan = plans[i + 1];
            addAnswer(plan, nextPlan, answer, todos, i);
        }

        for (int i = 0; i < todos.length; i++) {
            String todo = todos[todos.length - 1 - i];
            answer[answer.length - todos.length + i] = todo;
        }

        return answer;
    }

    private void addAnswer(
            String[] plan,
            String[] nextPlan,
            String[] answer,
            String[] todos,
            int index) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Calendar cal = Calendar.getInstance();
        Date startTime = dateFormat.parse(plan[1]);
        Date nextStartTime = dateFormat.parse(nextPlan[1]);

        cal.setTime(startTime);
        cal.add(Calendar.MINUTE, Integer.parseInt(plan[2]));
        if (nextStartTime.getTime() >= cal.getTime().getTime()) {
            answer[index] = plan[0];
        } else {
            todos[index] = nextPlan[0];
        }
    }

    class Plan {
        String name;
        String time;
        String workTime;
    }
    public static void main(String[] args) throws ParseException {
        String[][] test = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
        Solution solution = new Solution();
        String[] a = solution.solution(test);

        for (String b : a) {
            System.out.println(b);
        }
    }
}