package baekjoon._4153;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

    static int[] triangle = new int[3];

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        StringBuilder sb = new StringBuilder();
        while (true) {
            triangle[0] = fr.nextInt();
            if(triangle[0]==0) break;
            triangle[1] = fr.nextInt();
            triangle[2] = fr.nextInt();
            Arrays.sort(triangle);
            if (Math.pow(triangle[0], 2) + Math.pow(triangle[1], 2) == Math.pow(triangle[2], 2)) {
                sb.append("right").append("\n");
            } else {
                sb.append("wrong").append("\n");
            }
        }
        System.out.println(sb);
    }
}
