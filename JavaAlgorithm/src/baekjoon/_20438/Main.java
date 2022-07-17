package baekjoon._20438;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader fr = new FastReader();
    static int N, K, Q, M, ans;
    static int[] num;
    static boolean[] sleep, present;

    public static void input() {
        N = fr.nextInt();
        K = fr.nextInt();
        Q = fr.nextInt();
        M = fr.nextInt();
        num = new int[N + 3];
        sleep = new boolean[N + 3];
        present = new boolean[N + 3];
        Arrays.fill(num, 1);
    }

    public static void pro() {
        for (int i = 0; i < K; i++) {
            int num = fr.nextInt();
            sleep[num] = true;
        }

        for (int i = 0; i < Q; i++) {
            int cur = fr.nextInt();
            int next = 0;
            if(sleep[cur]) continue;
            while ((next += cur) <= N + 2) {
                if(sleep[next]) continue;
                num[next] = 0;
            }
        }

        for (int i = 3; i <= N + 2; i++) {
            num[i] += num[i - 1];
        }

        for (int i = 0; i < M; i++) {
            int S = fr.nextInt();
            int E = fr.nextInt();
            System.out.println(num[E] - num[S - 1]);
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
