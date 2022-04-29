package baekjoon._1019;

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

        long nextLong(){
            return Long.parseLong(next());
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

    static long N;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextLong();
    }

    public static void main(String[] args) {
        input();
        int[] pages = new int[10];
        for (int i = 1; i <= N; i++) {
            char[] temps = Integer.toString(i).toCharArray();
            for(char temp: temps){
                pages[temp - '0']++;
            }
        }
        for (int page: pages){
            System.out.println(page + " ");
        }
    }
}
