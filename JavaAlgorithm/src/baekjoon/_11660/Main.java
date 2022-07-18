package baekjoon._11660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] arr, dp;
    static FastReader fr = new FastReader();

    public static void input() {
        N = fr.nextInt();
        M = fr.nextInt();
        arr = new int[N + 1][N + 1];
        dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = fr.nextInt();
            }
        }
    }

    public static void pro() {

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                dp[r][c] = dp[r - 1][c] + dp[r][c - 1] - dp[r-1][c-1] + arr[r][c];
            }
        }

        for (int i = 0; i < M; i++) {
            int x1 = fr.nextInt();
            int y1 = fr.nextInt();
            int x2 = fr.nextInt();
            int y2 = fr.nextInt();
            System.out.println(dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1]);
        }
    }

    public static void main(String[] args) {
        input();

        pro();

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
