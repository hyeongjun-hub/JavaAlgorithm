package programmers.high_score_kit.dynamic_programming;

import java.util.Arrays;

public class IntegerTriangle {
    // triangle 위에서부터 아래로 더해줘서 마지막에 마지막줄만 남긴후
    // 그 중 가장 큰 값을 구한다

    // 구현 가능성
    // O(N^2) = O(250000)

    public int solution(int[][] triangle) {
        int answer = 0;

        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if(j == 0){ // 왼쪽 끝
                    triangle[i][j] += triangle[i - 1][j];
                } else if(j == triangle[i].length - 1){ // 오른쪽 끝
                    triangle[i][j] += triangle[i - 1][j - 1];
                } else {
                    triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
                }
            }
            if (i == triangle.length - 1) { // 마지막줄일 때 최대값구하기
                answer = Arrays.stream(triangle[i]).max().getAsInt();
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        IntegerTriangle integerTriangle = new IntegerTriangle();
        int solution = integerTriangle.solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}});
        System.out.println("solution = " + solution);
    }
}
