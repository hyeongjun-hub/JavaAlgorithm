package baekjoon._1912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] num;

    public static void input() {
        FastReader fr = new FastReader();
        n = fr.nextInt();
        num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = fr.nextInt();
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    public static void pro() {
        int[] dp = new int[n];
        dp[0] = num[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + num[i], num[i]);
        }
        int ans = Arrays.stream(dp).max().getAsInt();
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
