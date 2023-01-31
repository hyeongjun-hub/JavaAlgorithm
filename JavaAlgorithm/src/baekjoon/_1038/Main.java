package baekjoon._1038;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Long> list = new ArrayList<>();
    static int N;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
    }

    public static void main(String[] args) throws Exception {
        input();

        if(N <= 10) {
            System.out.print(N);
            return;
        } else if (N >= 1023) {
            System.out.print(-1);
            return;
        }

        for(int i = 0; i < 10; i++) {
            DFS(i);
        }

        Collections.sort(list);
        System.out.print(list.get(N));
    } // End of main

    private static void DFS(long num) {
        list.add(num);
        long modValue = num % 10;
        if(modValue == 0) {
            return;
        }
        // 1 10 , 2 21 210 20, ..
        for(long i=modValue-1; i>=0; i--) {
            long newValue = num * 10 + i;
            DFS(newValue);
        }
    } // End of DFS

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

} // End of Main class
