package baekjoon._13353;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, W, L;
    static int[] trucks;
    static Queue<Integer> bridge;

    public static void input() {
        FastReader fr = new FastReader();
        n = fr.nextInt();
        W = fr.nextInt();
        L = fr.nextInt();
        trucks = new int[n];
        for (int i = 0; i < n; i++) {
            trucks[i] = fr.nextInt();
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    public static void pro() {
        bridge = new LinkedList<>();
        int weight = 0;
        int time = 0;

        System.out.println(time);
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
