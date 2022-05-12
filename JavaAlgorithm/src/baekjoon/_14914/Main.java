package baekjoon._14914;

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

    static int a, b;

    public static void input() {
        FastReader fr = new FastReader();
        a = fr.nextInt();
        b = fr.nextInt();
    }

    public static void main(String[] args) {
        input();
        StringBuilder sb = new StringBuilder();
        int friends = 1;
        while (friends <= Math.min(a, b)) {
            if (a % friends == 0 && b % friends == 0) {
                sb.append(friends).append(" ").append(a / friends).
                        append(" ").append(b / friends).append("\n");
            }
            friends++;
        }
        System.out.println(sb.toString());
    }
}
