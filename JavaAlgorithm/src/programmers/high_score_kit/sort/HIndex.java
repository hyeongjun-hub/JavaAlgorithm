package programmers.high_score_kit.sort;

import java.util.Arrays;
import java.util.Collections;

public class HIndex {
    public int solution(int[] citations) {
        int answer = 0;
        Integer wrappedCitations[] = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(wrappedCitations, Collections.reverseOrder());
        for (int i = 1; i <= citations.length; i++) {
            if(wrappedCitations[i-1] <= i){
                answer = wrappedCitations[i-1];
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        HIndex hIndex = new HIndex();
        int solution = hIndex.solution(new int[]{3, 0, 6, 1, 5});
        System.out.println("solution = " + solution);

    }
}
