package programmers.high_score_kit.brute_force;

import java.util.Arrays;

import static java.lang.Math.sqrt;

public class Carpet {
    public int[] solution(int brown, int yellow) {
        int all = brown + yellow;
        int[] answer = new int[2];
        for (int i = 1; i <= sqrt(yellow); i++) {
            if (yellow % i == 0 && (yellow / i + 2) * (i + 2) == all) {
                answer[0] = yellow / i + 2;
                answer[1] = i + 2;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Carpet carpet = new Carpet();
        System.out.println(Arrays.toString(carpet.solution(8, 1)));
    }

}
