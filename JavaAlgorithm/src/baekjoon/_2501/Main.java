package baekjoon._2501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] nums;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        K = fr.nextInt();
        nums = new int[N+1];
    }

    public static void pro() {
        int length = 0;
        int result = 0;
        for (int i = 1; i <= N; i++) {
            if(N % i == 0 ){
                nums[i] = i;
                length++;
            }
            if(length == K){
                result = i;
                break;
            }
        }
        System.out.println(result);

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
