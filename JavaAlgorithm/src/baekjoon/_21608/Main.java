package baekjoon._21608;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N, ans;
    static HashMap<Integer, int[]> score = new HashMap(); // 좋은하는 학생의 배열을 담는 Map
    static int[][] map; // 교실
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        map = new int[N][N];
        for (int i = 0; i < N * N; i++) {
            int[] cur = new int[4];
            int index = fr.nextInt();
            for (int j = 0; j < 4; j++) {
                cur[j] = fr.nextInt();
            }
            score.put(index, cur);
            place(index, cur); // 자리배치 시작
        }
    }

    private static void place(int index, int[] cur) {
        // 1. 비어있는 칸 중 좋아하는 학생 번호가 몇 개 인접한지 (+10)
        // 2. 비어있는 칸 중 인접한 빈 칸이 몇개인지 (+1)
        int[][] temp = new int[N][N]; // 임시 교실
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                temp[i][j] = -1; // -1로 초기화
                if (map[i][j] > 0) continue;
                // 비어있는 칸중 인접한 좋아하는 학생번호와 빈 칸 개수 확인
                int score = 0; // 비어있는 칸의 점수
                for (int k = 0; k < 4; k++) {
                    // 인접한 좌표
                    int newR = i + dir[k][0];
                    int newC = j + dir[k][1];
                    if (newR < 0 || newC < 0 || newR >= N || newC >= N) continue;
                    for (int l = 0; l < 4; l++) {
                        if (map[newR][newC] == cur[l]) {
                            score += 10; // 좋아하는 학생이면 10점 추가
                        }
                    }
                    if (map[newR][newC] == 0) {
                        score++; // 빈 자리면 1점 추가
                    }
                }
                if (score > temp[i][j]) temp[i][j] = score; // 최대값으로 갱신
            }
        }
        // 3. 순회하면서 제일 적당한 곳 찾기
        int max = -1;
        int bestR = 0;
        int bestC = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (temp[i][j] > max) {
                    max = temp[i][j];
                    bestR = i;
                    bestC = j;
                }
            }
        }
        // 적당한 곳이 아무곳도 없을 때
        if (max == -1) {
            point:
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 0) {
                        bestR = i;
                        bestC = j;
                        break point;
                    }
                }
            }
        }
        map[bestR][bestC] = index;
    }

    public static void main(String[] args) {
        input();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int people = 0;
                for (int k = 0; k < 4; k++) {
                    // 인접한 좌표
                    int newR = i + dir[k][0];
                    int newC = j + dir[k][1];
                    if (newR < 0 || newC < 0 || newR >= N || newC >= N) continue;
                    for (int l = 0; l < 4; l++) {
                        if (map[newR][newC] == score.get(map[i][j])[l]) {
                            people++;
                        }
                    }
                }
                if (people == 1) ans += 1;
                else if (people == 2) ans += 10;
                else if (people == 3) ans += 100;
                else if (people == 4) ans += 1000;
            }
        }
        System.out.println(ans);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        Double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
