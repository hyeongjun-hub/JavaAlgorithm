package programmers.high_score_kit.brute_force;

import java.util.ArrayList;
import java.util.Arrays;

public class MockExam {
    public int[] solution(int[] answers) {
        // 패턴을 담은 배열
        int[] first = new int[]{1, 2, 3, 4, 5};
        int[] second = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        // 각 학생의 점수를 담은 배열
        int[] score = new int[3];
        // 정답을 담을 배열
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i=0; i< answers.length; i++) {
            if(answers[i] == first[i%first.length]) score[0]++;
            if(answers[i] == second[i%second.length]) score[1]++;
            if(answers[i] == third[i%third.length]) score[2]++;
        }
        int maxScore = Arrays.stream(score).max().getAsInt();
        for (int i = 0; i<3; i++) {
            if(score[i] == maxScore){
                answer.add(i+1);
            }
        }
        return answer.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        MockExam mockExam = new MockExam();
        int[] answer = mockExam.solution(new int[]{1, 3, 2, 4, 2});
        for (int a : answer) {
            System.out.println(a);
        }
    }
}
