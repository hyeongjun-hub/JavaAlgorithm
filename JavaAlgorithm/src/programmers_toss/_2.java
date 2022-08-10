package programmers_toss;

import java.util.Arrays;
import java.util.Comparator;

public class _2 {
    public int solution(int[] levels){
        int answer = 0;
        Arrays.sort(levels);
        try {
            int index = (int) Math.ceil(levels.length * 0.75);
            answer = levels[index];
        } catch (Exception e) {
            return -1;
        }

        return answer;
    }
}

//    int answer = 0;
//    Integer[] tmp = Arrays.stream(levels).boxed().toArray(Integer[]::new);
//        Arrays.sort(tmp, Comparator.reverseOrder());
//                int index = (int) (levels.length * 0.25);
//                answer = tmp[index];
//
//                return answer;