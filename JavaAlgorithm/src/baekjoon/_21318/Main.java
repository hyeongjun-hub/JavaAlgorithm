package baekjoon._21318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, Q;
    static int[] arr, mis;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        arr = new int[N + 1];
        mis = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = fr.nextInt();
        }
        pro();
        Q = fr.nextInt();
        for (int i = 0; i < Q; i++) {
            int x = fr.nextInt();
            int y = fr.nextInt();
            System.out.println(mis[y] - mis[x]);
        }
    }

    public static void pro() {
        for (int i = 2; i <= N; i++) {
            mis[i] += mis[i - 1];
            if(arr[i-1] > arr[i]) mis[i]++;
        }
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
