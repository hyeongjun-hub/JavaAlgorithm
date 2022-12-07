package baekjoon._2468;

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

    static int N, max, water;
    static int[][] map;
    static boolean[][] visit;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        map = new int[N][N];
        max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int cur = fr.nextInt();
                map[i][j] = cur;
                max = Math.max(max, cur);
            }
        }
    }

    public static void pro() {
        int ans = 0;
        for (int i = 0; i <= max; i++) {
            water = i;
            visit = new boolean[N][N];
            int temp = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if(map[j][k]<=water)continue;
                    if(visit[j][k])continue;
                    temp++;
                    bfs(j, k);
                }
            }
            ans = Math.max(ans, temp);
        }
        System.out.println(ans);
    }

    private static void bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        visit[r][c] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curR = poll[0];
            int curC = poll[1];
            for (int i = 0; i < 4; i++) {
                int newR = curR + dir[i][0];
                int newC = curC + dir[i][1];
                if(newR < 0 || newC < 0 || newR >= N || newC >= N) continue;
                if(visit[newR][newC])continue;
                if(map[newR][newC] <= water)continue;
                visit[newR][newC] = true;
                queue.add(new int[]{newR, newC});
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
