package baekjoon._2914;

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

    static String st;
    static String strings[] = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    public static void input() {
        FastReader fr = new FastReader();
        st = fr.nextLine();
    }

    public static void main(String[] args) {
        input();
        for (String s : strings) {
            if (st.contains(s)) {
                st = st.replace(s, "1");
            }
        }
        System.out.println(st.length());
    }
}
