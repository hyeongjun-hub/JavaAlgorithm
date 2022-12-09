package baekjoon._2573;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        input();
        pro();
    }

    static int N, M, ans, max;
    static int[][] map;
    static boolean[][] visit;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static Queue<int[]> queue;

    public static void input() {
        max = 0;
        FastReader fr = new FastReader();
        N = fr.nextInt();
        M = fr.nextInt();
        map = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = fr.nextInt();
                max = Math.max(max, map[i][j]);
            }
        }
    }

    public static void pro() {
        ans = 0;
        for (int year = 0; year <= 1500; year++) {
            // 빙산 나눠졌는지 확인
            if (check()) {
                ans = year;
                break;
            }

            // 바다 인접부분 녹게하기
            melting();

        }
        System.out.println(ans);

    }

    private static boolean check() {
        int ice = 0;
        queue = new LinkedList<>();
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0) continue;
                if(visit[i][j]) continue;
                ice++;
                if(ice >= 2) return true;
                queue.add(new int[]{i, j});
                visit[i][j] = true;
                while (!queue.isEmpty()) {
                    int[] poll = queue.poll();
                    int r = poll[0];
                    int c = poll[1];
                    for (int k = 0; k < 4; k++) {
                        int nr = r + dir[k][0];
                        int nc = c + dir[k][1];
                        if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                        if(visit[nr][nc]) continue;
                        if(map[nr][nc] == 0) continue;
                        visit[nr][nc] = true;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }
        return false;
    }

    private static void melting() {
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] != 0) continue;
                if(visit[i][j]) continue;
                for (int k = 0; k < 4; k++) {
                    int nr = i + dir[k][0];
                    int nc = j + dir[k][1];
                    if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                    if(map[nr][nc] > 0) {
                        map[nr][nc]--;
                        visit[nr][nc] = true;
                    }

                }
            }
        }
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){ br = new BufferedReader(new InputStreamReader(System.in));}

        String next(){
            while(st == null || !st.hasMoreTokens()){
                try{
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        Double nextDouble() { return Double.parseDouble(next()); }

        String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            } catch(IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
}
