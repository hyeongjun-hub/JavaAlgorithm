package baekjoon._11066;

/*
파일합치기
(Dynamic Programming)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int T, K, ans;
    static PriorityQueue<Integer> pq;

    public static void input() {
        FastReader fr = new FastReader();
        T = fr.nextInt();
        for (int i = 0; i < T; i++) {
            K = fr.nextInt();
            pq = new PriorityQueue<>();
            for (int j = 0; j < K; j++) {
                pq.add(fr.nextInt());
            }
            pro();
            pq.clear();
        }
    }

    public static void pro() {
        ans = 0;
        while (pq.size() >= 2) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            int sum = num1 + num2;
            ans += sum;
            pq.add(sum);
            System.out.println("sum = " + sum);
        }
        System.out.println(ans);
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
