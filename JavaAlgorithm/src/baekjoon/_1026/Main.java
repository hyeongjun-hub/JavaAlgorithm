package baekjoon._1026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

import static java.util.Comparator.reverseOrder;

public class Main {

    static int N;
    static Integer[] A, B;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        A = new Integer[N];
        B = new Integer[N];
        for (int i = 0; i < N; i++) {
            A[i] = fr.nextInt();
        }
        for (int i = 0; i < N; i++) {
            B[i] = fr.nextInt();
        }
    }

    public static void pro() {
        Arrays.sort(A, reverseOrder());
        Arrays.sort(B);
        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans += A[i] * B[i];
        }
        System.out.println(ans);
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
