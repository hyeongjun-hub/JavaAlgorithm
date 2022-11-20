package programmers_kakao.파괴되지않은건물;

public class Solution {
    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;
        int[][] zero = new int[n+1][m+1]; // 1씩 크기 크게

        // 누적합 전처리
        for (int[] row : skill) {
            int r1 = row[1];
            int c1 = row[2];
            int r2 = row[3];
            int c2 = row[4];
            int degree = row[0] == 2 ? row[5] : -row[5];

            zero[r1][c1] += degree;
            zero[r1][c2+1] -= degree;
            zero[r2+1][c1] -= degree;
            zero[r2+1][c2+1] += degree;
        }

        // 가로 누적합
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                zero[i+1][j] += zero[i][j];
            }
        }

        // 세로 누적합
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                zero[i][j+1] += zero[i][j];
            }
        }

        // 정답 구하기
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(zero[i][j] + board[i][j] > 0) answer++;
            }
        }

        return answer;
    }
}
