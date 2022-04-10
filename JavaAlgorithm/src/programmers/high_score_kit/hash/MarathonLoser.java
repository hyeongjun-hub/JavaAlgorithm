package programmers.high_score_kit.hash;

import java.util.HashMap;
import java.util.Iterator;

public class MarathonLoser {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> marathonList = new HashMap<>();
        for (String person : participant) {
            marathonList.put(person, marathonList.get(person)!=null? marathonList.get(person)+1: 1);
        }
        for (String person : completion) {
            marathonList.put(person, marathonList.get(person) - 1);
        }
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
