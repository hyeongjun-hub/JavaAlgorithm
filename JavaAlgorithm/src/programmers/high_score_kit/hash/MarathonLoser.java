package programmers.high_score_kit.hash;

import java.util.HashMap;
import java.util.Iterator;

public class MarathonLoser {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> marathonList = new HashMap<>();
        // 참여자 업데이트
        for (String person : participant) {
            marathonList.put(person, marathonList.getOrDefault(person, 1));
        }
        // 참여자에서 완주자를 제거
        for (String person : completion) {
            marathonList.put(person, marathonList.get(person) - 1);
        }
        // map에 남아있는 참여자 한 명을 return
        String answer = "";
        Iterator<String> iterator = marathonList.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            if (marathonList.get(key) >= 1) {
               answer = key;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        MarathonLoser marathonLoser = new MarathonLoser();
        String solution = marathonLoser.solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"});
        System.out.println("solution = " + solution);
    }
}
