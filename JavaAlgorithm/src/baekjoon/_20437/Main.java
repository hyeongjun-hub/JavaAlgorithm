package baekjoon._20437;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T, K;
    static int[] alpha;
    static String W;

    public static void input() {
        FastReader fr = new FastReader();
        T = fr.nextInt();
        while (T-- > 0) {
            W = fr.nextLine();
            K = fr.nextInt();
            pro();
        }
    }

    public static void pro() {
        findAns1();
    }

    public static void findAns1() {
        if (K == 1) {
            System.out.println("1 1");
            return;
        }

        alpha = new int[26];
        for (int i = 0; i < W.length(); i++) {
            alpha[W.charAt(i) - 'a']++;
        }

        int min = Integer.MAX_VALUE;
        int max = -1;
        for (int left = 0; left < W.length(); left++) {
            if(alpha[W.charAt(left) - 'a'] < K){ continue;}

            int count = 1;
            for (int right = left + 1; right < W.length(); right++) {
                if (W.charAt(left) == W.charAt(right)) count++;
                if (count == K) {
                    min = Math.min(right - left + 1, min);
                    max = Math.max(right - left + 1, max);
                    break;
                }
            }
        }
        if(min == Integer.MAX_VALUE || max == -1) System.out.println("-1");
        else System.out.println(min + " " + max);
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
