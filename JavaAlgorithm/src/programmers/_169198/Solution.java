package programmers._169198;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    int M, N;

    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        M = m;
        N = n;
        List<Integer> answer = new ArrayList<>();
        Arrays.stream(balls).forEach(ball -> {
            int ballX = ball[0];
            int ballY = ball[1];
            answer.add(getShortestDistance(startX, startY, ballX, ballY));
        });
        return answer.stream().mapToInt(x -> x).toArray();
    }

    private Integer getShortestDistance(int startX, int startY, int ballX, int ballY) {
        int minValue = Integer.MAX_VALUE;

        // UP
        if (!(ballX == startX && ballY > startY)) {
            minValue = Math.min(minValue, getDistance(ballX, ballY, startX, 2*N-startY));
        }
        // DOWN
        if (!(ballX == startX && ballY < startY)) {
            minValue = Math.min(minValue, getDistance(ballX, ballY, startX, -startY));
        }
        // LEFT
        if (!(ballY == startY && ballX < startX)) {
            minValue = Math.min(minValue, getDistance(ballX, ballY, -startX, startY));
        }
        // RIGHT
        if (!(ballY == startY && ballX > startX)) {
            minValue = Math.min(minValue, getDistance(ballX, ballY, 2*M-startX, startY));
        }
        return minValue;
    }

    private int getDistance(int a, int b, int x, int y) {
        return (int) (Math.pow(a - x, 2) + Math.pow(b - y, 2));
    }
}