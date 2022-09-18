package baekjoon._10971;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static long min;
    static int[][] map;
    static boolean[] visit;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        min = Integer.MAX_VALUE;
        map = new int[N][N];
        visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = fr.nextInt();
            }
        }
    }

    public static void pro(int start, int now, int depth, long cost) {
        if (depth == N - 1) {
            if (map[now][start] != 0) {
                cost += map[now][start];
                min = Math.min(min, cost);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            // 조건 검사
            if(map[now][i] == 0) continue;
            if(visit[i]) continue;

            // 대입

            visit[i] = true;
            pro(start, i, depth + 1, cost + map[now][i]);
            visit[i] = false;
        }

    }

    public static void main(String[] args) {
        input();
        for (int i = 0; i < N; i++) {
            visit[i] = true;
            pro(i, i, 0, 0);
        }
        System.out.println(min);
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
