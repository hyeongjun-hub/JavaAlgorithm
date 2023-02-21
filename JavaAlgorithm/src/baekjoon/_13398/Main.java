package baekjoon._13398;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] arr;

    public static void input() {
        FastReader fr = new FastReader();
        n = fr.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = fr.nextInt();
        }

        int[] dp1 = new int[n]; // ->

        dp1[0] = arr[0];
        int ans = dp1[0];

        for (int i = 1; i < n; i++) {
            dp1[i] = Math.max(dp1[i - 1] + arr[i], arr[i]);
            ans = Math.max(ans, dp1[i]);
        }

        int[] dp2 = new int[n]; // <-
        dp2[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            dp2[i] = Math.min(dp2[i + 1] + arr[i], arr[i]);
        }

        for (int i = 1; i < n - 1; i++) {
            int temp = dp1[i - 1] + dp2[i + 1];

            ans = Math.max(ans, temp);
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
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