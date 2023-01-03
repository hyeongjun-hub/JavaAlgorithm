package baekjoon._11057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class My {

    static int N;
    static long sum[][];
    static long A[][];

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        sum = new long[N + 1][10];
        A = new long[N + 1][10];
        // 초기화
        for (int i = 0; i < 10; i++) {
            A[1][i] = 1;
            sum[1][i] = i+1;
        }
        if(N == 1) {System.out.println(sum[1][9]);return;}
        // dp 시작
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if(j==0){
                    A[i][0] = sum[i-1][9]%10007;
                    sum[i][0] = sum[i-1][9]%10007;
                    continue;
                }
                A[i][j] = A[i][0]%10007 - sum[i-1][j-1]%10007;
                sum[i][j] = (sum[i][j-1]%10007 + A[i][j]%1007)%10007;
                sum[i][j] %= 10007;
            }
        }

        System.out.println(sum[N][9]%10007);

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
