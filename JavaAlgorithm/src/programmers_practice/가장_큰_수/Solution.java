package programmers_practice.가장_큰_수;

import java.util.Arrays;

public class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] num = new String[numbers.length];
        boolean except = true;

        for (int i = 0; i < numbers.length; i++) {
            num[i] = Integer.toString(numbers[i]);
            if(numbers[i] != 0) except = false;
        }

        Arrays.sort(num, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        for (int i = 0; i < num.length; i++) {
            answer += num[i];
        }

        if(except) answer = "0";

        return answer;
    }
}



