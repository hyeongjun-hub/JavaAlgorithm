package baekjoon._1261;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, ans;
    static int[][] map, wallMap;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void input() {
        FastReader fr = new FastReader();
        M = fr.nextInt();
        N = fr.nextInt();
        map = new int[N][M];
        wallMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = fr.nextLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - 48;
            }
        }
        bfs(0, 0);
    }

    public static void bfs(int r, int c) {
        boolean[][] visit = new boolean[N][M];
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        queue.add(new int[]{r, c, 0});
        visit[r][c] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            r = poll[0];
            c = poll[1];
            int wall = poll[2];
            wallMap[r][c] = wall;
            if(r == N-1 && c == M-1) {
                ans = wall;
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                int nw = wall;
                if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if(map[nr][nc] == 1) nw = wall + 1;
                if(visit[nr][nc]){
                    if(wallMap[nr][nc] <= nw) continue;
                }
                visit[nr][nc] = true;
                queue.add(new int[]{nr, nc, nw});
            }
        }
    }

    public static void main(String[] args) {
        input();
        System.out.println(ans);
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
