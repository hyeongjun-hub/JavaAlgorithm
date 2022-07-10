package baekjoon._15663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] inputNums;
    static int[] selected;
    static boolean[] used;
    static LinkedHashSet<String> ans;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        M = fr.nextInt();
        inputNums = new int[N];
        used = new boolean[N];
        selected = new int[N];
        ans = new LinkedHashSet<>();

        for (int i = 0; i < N; i++) {
            inputNums[i] = fr.nextInt();
        }
        Arrays.sort(inputNums);
    }

    public static void pro(int k) {
        if(k == M){
            // selected 출력
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(selected[i]).append(' ');
            }
            ans.add(sb.toString());
            return;
        }
        for (int i=0; i < N; i++) {
            if(used[i]) continue;
            selected[k] = inputNums[i]; used[i] = true;
            pro(k + 1);
            selected[k] = 0; used[i] = false;
        }
    }

    public static void main(String[] args) {
        input();
        pro(0);
        for (String an : ans) {
            System.out.println(an);
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
