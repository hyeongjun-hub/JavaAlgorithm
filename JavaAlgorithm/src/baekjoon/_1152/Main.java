package baekjoon._1152;

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

    static String line;

    public static void input() {
        FastReader fr = new FastReader();
        line = fr.nextLine();
    }

    public static void main(String[] args) {
        input();
        int result = 0;
        StringTokenizer st = new StringTokenizer(line, " ");
        while (st.hasMoreTokens()) {
            st.nextToken();
            result++;
        }
        System.out.println(result);
    }
}
