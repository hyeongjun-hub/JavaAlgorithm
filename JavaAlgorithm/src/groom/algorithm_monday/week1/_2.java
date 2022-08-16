package groom.algorithm_monday.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2 {

    static int start, end, ans;

    public static void input() {
        FastReader fr = new FastReader();
        start = fr.nextInt();
        end = fr.nextInt();
        for (int i = start; i <= end; i++) {
            int smallAns = 1;
            int temp = i;
            while(temp > 0){
                int one = temp % 10;
                temp /= 10;
                smallAns *= one;
            }
            ans += smallAns;
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
