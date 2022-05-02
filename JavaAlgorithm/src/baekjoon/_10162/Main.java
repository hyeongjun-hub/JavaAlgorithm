package baekjoon._10162;

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

    static int T;

    public static void input() {
        FastReader fr = new FastReader();
        T = fr.nextInt();
    }

    public static void main(String[] args) {
        input();
        int A = 0;
        int B = 0;
        int C = 0;
        while(T > 0){
            if(T >= 300) {
                T -= 300;
                A++;
            } else if(T >= 60){
                T -= 60;
                B++;
            } else if(T >= 10){
                T -= 10;
                C++;
            } else {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(A + " " + B + " " + C);
    }
}
