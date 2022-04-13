package programmers.high_score_kit.stack_queue;

import java.util.ArrayList;

public class FunctionDev {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> progressesList = new ArrayList<>();
        ArrayList<Integer> speedsList = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            progressesList.add(progresses[i]);
            speedsList.add(speeds[i]);
        }
        while (progressesList.size() > 0) {
            for (int i = 0; i < progressesList.size(); i++) {
                progressesList.set(i, progressesList.get(i) + speedsList.get(i));
            }
            int count = 0;
            while (progressesList.size() > 0 && progressesList.get(0) >= 100) {
                count++;
                progressesList.remove(0);
                speedsList.remove(0);
            }
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
