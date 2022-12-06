package baekjoon._1106;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) {
        input();
    }

    static int i, j, k, C, N, c, p, ans;
    static int[] dp;

    public static void input() {
        FastReader fr = new FastReader();
        C = fr.nextInt();
        N = fr.nextInt();
        dp = new int[2001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            c = fr.nextInt();
            p = fr.nextInt();
            for (j = 0; j < 2000; j++) {
                if(dp[j] == Integer.MAX_VALUE) continue;
                for (k = 1; j + p * k <= 2000; k++) {
                    dp[j + p * k] = Math.min(dp[j + p * k], dp[j] + c * k);
                }
            }
        }
        ans = Integer.MAX_VALUE;
        for (i = C; i <= 2000; i++) {
            ans = Math.min(ans, dp[i]);
        }
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
