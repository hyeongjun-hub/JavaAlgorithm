package baekjoon._15656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] inputNum, ans;
    static boolean[] visit;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        M = fr.nextInt();
        ans = new int[M];
        inputNum = new int[N];
        for (int i = 0; i < N; i++) {
            inputNum[i] = fr.nextInt();
        }
        Arrays.sort(inputNum);
        visit = new boolean[N];
    }

    public static void pro(int pos) {
        if (pos == M) {
            /* todo */
            for (int i = 0; i < M; i++) {
                sb.append(ans[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i = 0; i < N; i++) {
            ans[pos] = inputNum[i];
            visit[i] = true;
            pro(pos + 1);
            ans[pos] = 0;
            visit[i] = false;
        }
    }

    public static void main(String[] args) {
        input();
        pro(0);
        System.out.println(sb);
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
