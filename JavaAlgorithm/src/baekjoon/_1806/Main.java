package baekjoon._1806;

/*
(투 포인터)
부분합



 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, S;
    static int[] a;

    public static void input() {
        FastReader fr = new FastReader();
        n = fr.nextInt();
        S = fr.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = fr.nextInt();
        }
    }

    static void pro() {
        int R = 0, sum = 0, ans = n + 1;
        for (int L = 1; L <= n; L++) {
            // L - 1 을 구간에서 제외하기
            sum -= a[L - 1];

            // R 을 옮길 수 있을 때까지 옮기기
            while(R + 1 <= n && sum < S){
                R++;
                sum += a[R];
            }

            // [L.. R]의 합, 즉 sum이 조건을 만족하면 정답을 갱신하기
            if (sum >= S){
                ans = Math.min(ans, R - L + 1);
            }
        }

        // ans 값을 보고 불가능 판단하기
        if (ans == n + 1) { // 한번도 갱신 안됐으면
            ans = 0;
        }
        System.out.println(ans);
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
