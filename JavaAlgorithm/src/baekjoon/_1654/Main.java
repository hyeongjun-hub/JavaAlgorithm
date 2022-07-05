package baekjoon._1654;

/*
랜선자르기
(binary search)

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int K, N;
    static long ans;
    static long[] lan;

    public static void input() {
        FastReader fr = new FastReader();
        K = fr.nextInt();
        N = fr.nextInt();
        lan = new long[K + 1];
        for (int i = 1; i <= K; i++) {
            lan[i] = fr.nextLong();
        }
    }

    public static boolean determination(long x) {
        int num = 0;
        for (long l : lan) {
            if (l == 0) continue;
            num += l / x;
        }
        return num >= N;
    }

    public static void pro() {
        Arrays.sort(lan, 1, K + 1);

        long L = 1;
        long R = lan[K];
        while (L <= R) {
            long mid = (L + R) / 2;
            if(determination(mid)){
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
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
