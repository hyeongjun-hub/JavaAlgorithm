package programmers.programmers_kakao.성격유형검사하기;

import java.util.HashMap;

class Solution {
    static HashMap<String, Integer> map = new HashMap<>();

    public String solution(String[] survey, int[] choices) {
        String answer = "";

        for (int i = 0; i < survey.length; i++) {
            givePoint(survey[i], choices[i]);
        }

        answer = getAnswer();
        return answer;
    }

    private String getAnswer() {
        StringBuilder sb = new StringBuilder();

        if (map.getOrDefault("R", 0) >= map.getOrDefault("T", 0)) {
            sb.append("R");
        } else sb.append("T");
        if (map.getOrDefault("C", 0) >= map.getOrDefault("F", 0)) {
            sb.append("C");
        } else sb.append("F");
        if (map.getOrDefault("J", 0) >= map.getOrDefault("M", 0)) {
            sb.append("J");
        } else sb.append("M");
        if (map.getOrDefault("A", 0) >= map.getOrDefault("N", 0)) {
            sb.append("A");
        } else sb.append("N");

        return sb.toString();
    }

    private void givePoint(String s, int choice) {
        if(choice == 4) return;
        if (choice < 4) {
            map.put(s.substring(0, 1), map.getOrDefault(s.substring(0,1), 0) + 4 - choice);
        } else {
            map.put(s.substring(1, 2), map.getOrDefault(s.substring(1,2), 0) + choice - 4);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5}));
    }
}