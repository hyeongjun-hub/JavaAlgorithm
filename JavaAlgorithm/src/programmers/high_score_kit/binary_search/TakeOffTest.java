package programmers.high_score_kit.binary_search;

import java.util.Arrays;

public class TakeOffTest {

    // 이분 탐색

    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = 0;
        long start = 0;
        long end = (long) n * times[times.length - 1];

        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;
            for (int time : times) {
                sum += mid / time;
            }
            if (sum >= n) {
                end = mid - 1;
                answer = mid;
            } else {
                start = mid + 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        TakeOffTest takeOffTest = new TakeOffTest();
        long solution = takeOffTest.solution(6, new int[]{7, 10});
        System.out.println(solution);
    }
}
