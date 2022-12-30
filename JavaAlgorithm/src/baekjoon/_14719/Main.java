package baekjoon._14719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int h, w;
    static int[] height;

    public static void input() {
        FastReader fr = new FastReader();
        h = fr.nextInt();
        w = fr.nextInt();
        height = new int[w];
        for (int i = 0; i < w; i++) {
            height[i] = fr.nextInt();
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    public static void pro() {
        int result = 0;
        for (int i = 1; i < w - 1; i++) {
            int left = 0;
            int right = 0;

            for (int j = 0; j < i; j++) {
                left = Math.max(height[j], left);
            }

            for (int j = i + 1; j < w; j++) {
                right = Math.max(height[j], right);
            }

            if (height[i] < left && height[i] < right) result += Math.min(left, right) - height[i];
        }

        System.out.println(result);
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
