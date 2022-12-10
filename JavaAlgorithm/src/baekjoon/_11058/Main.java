package baekjoon._11058;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    public static void pro() {
        long[] arr = new long[101];
        for (int i = 0; i <= 6; i++) {
            arr[i] = i;
        }
        for (int i = 7; i <= N; i++) {
            arr[i] = Math.max(arr[i - 5] * 4, Math.max(arr[i - 4] * 3, arr[i - 3] * 2));
        }
        System.out.println(arr[N]);
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
