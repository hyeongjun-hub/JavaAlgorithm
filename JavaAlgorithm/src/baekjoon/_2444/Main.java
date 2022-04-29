package baekjoon._2444;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

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

        int nextInt(){
            return Integer.parseInt(next());
        }

        Double nextDouble(){
            return Double.parseDouble(next());
        }

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

    static int N;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
    }

    public static void makeStars(int N) {
        for(int i=1; i<=N; i++){
            for(int j=N-1; j>=i; j--){
                System.out.print(" ");
            }
            System.out.print("*");
            for(int k=1; k<i; k++){
                System.out.print("**");
            }
            System.out.println();
        }
        for(int i=1; i<N; i++){
            for(int j=1; j<=i; j++){
                System.out.print(" ");
            }
            System.out.print("*");
            for(int j=N-1; j>i; j--){
                System.out.print("**");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        input();
        makeStars(N);
    }
}
