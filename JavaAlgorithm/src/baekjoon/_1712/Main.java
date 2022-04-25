package baekjoon._1712;

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

    static int A;
    static int B;
    static int C;

    public static void input() {
        FastReader fr = new FastReader();
        A = fr.nextInt();
        B = fr.nextInt();
        C = fr.nextInt();
    }

    public static void main(String[] args) {
        input();
        if(B >= C) {
            System.out.println("-1");return;
        }
        else {
            System.out.println((A / (C - B) + 1));
        }
    }
}
