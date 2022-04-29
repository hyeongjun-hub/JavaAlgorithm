package baekjoon._2884;

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

    static int H;
    static int M;

    public static void input() {
        FastReader fr = new FastReader();
        H = fr.nextInt();
        M = fr.nextInt();
    }

    public static void main(String[] args) {
        input();
        M -= 45;
        if (M < 0) {
            H -= 1;
            M += 60;
        }
        if (H < 0) {
            H += 24;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(H).append(" ").append(M);
        System.out.println(sb);
    }
}
