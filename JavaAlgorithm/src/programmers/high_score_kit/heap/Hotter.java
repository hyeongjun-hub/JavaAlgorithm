package programmers.high_score_kit.heap;

import java.util.PriorityQueue;

public class Hotter {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> food = new PriorityQueue<>();
        for (int scov : scoville) {
            food.add(scov);
        }
        int answer = 0;

        while (food.peek() < K) {
            try {
                food.add(food.poll() + food.poll()*2);
                answer++;
            } catch (Exception e) {
                return -1;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Hotter hotter = new Hotter();
        int solution = hotter.solution(new int[]{1, 2, 3, 9, 10, 12}, 7);
        System.out.println("Solution = " + solution);
    }
}
