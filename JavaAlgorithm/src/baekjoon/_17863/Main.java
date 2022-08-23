package baekjoon._17863;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, T;
    static int[][] map;
    static boolean[][] visit;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static int min = 10000;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        M = fr.nextInt();
        T = fr.nextInt();
        map = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = fr.nextInt();
            }
        }
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});
        visit[0][0] = true;
        int size = 0;
        while (!queue.isEmpty()) {
            size = queue.size();
            for (int step = 0; step < size; step++) {
                int[] poll = queue.poll();
                int r = poll[0];
                int c = poll[1];
                int count = poll[2];
                if (r == N - 1 && c == M - 1) {
                    min = Math.min(min, count);
                } else if (map[r][c] == 2) {
                    int dist = (N - 1 - r) + (M - 1 - c);
                    min = Math.min(min, count + dist);
                }
                for (int i = 0; i < 4; i++) {
                    int nr = r + dir[i][0];
                    int nc = c + dir[i][1];
                    if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                    if (visit[nr][nc]) continue;
                    if (map[nr][nc] == 1) continue;
                    queue.add(new int[]{nr, nc, count + 1});
                    visit[nr][nc] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        bfs();
        if (min > T) System.out.println("Fail");
        else System.out.println(min);
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
