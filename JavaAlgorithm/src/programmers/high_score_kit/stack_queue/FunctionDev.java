package programmers.high_score_kit.stack_queue;

import java.util.ArrayList;

/*
문제 설명
프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.

또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.

먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.

제한 사항
작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
작업 진도는 100 미만의 자연수입니다.
작업 속도는 100 이하의 자연수입니다.
배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.
 */
public class FunctionDev {
    public int[] solution(int[] progresses, int[] speeds) {
        // 배열을 arrayList로 변환
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> progressesList = new ArrayList<>();
        ArrayList<Integer> speedsList = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            progressesList.add(progresses[i]);
            speedsList.add(speeds[i]);
        }
        // 전체 반복(매일)
        while (progressesList.size() > 0) {
            // progressList에 speed 만큼 더함
            for (int i = 0; i < progressesList.size(); i++) {
                progressesList.set(i, progressesList.get(i) + speedsList.get(i));
            }
            int count = 0;
            // 첫 번째인 기능이 100% 완료하면 뒤에도 완료되었는지 체크하며 삭제
            while (progressesList.size() > 0 && progressesList.get(0) >= 100) {
                count++;
                progressesList.remove(0);
                speedsList.remove(0);
            }
            // 결과값에 추가
            if (count >= 1) {
                result.add(count);
            }
        }
        int[] answer = result.stream().mapToInt(i -> i).toArray();
        return answer;
    }

    public static void main(String[] args) {
        FunctionDev functionDev = new FunctionDev();
        int[] solution = functionDev.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});
//        int[] solution = functionDev.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
        for (int sol : solution) {
            System.out.println("sol = " + sol);
        }
    }
}
