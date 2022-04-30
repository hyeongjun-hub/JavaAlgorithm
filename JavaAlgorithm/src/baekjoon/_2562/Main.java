package baekjoon._2562;

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

    static int[] numArr = new int[9];
    static int max = 0;
    static int index = 1;

    public static void input() {
        FastReader fr = new FastReader();
        for (int i = 0; i < 9; i++) {
            int inputNum = fr.nextInt();
            if (inputNum > max) {
                max = inputNum;
                index = i + 1;
            }
        }
    }

    public static void main(String[] args) {
        input();
        System.out.println(max);
        System.out.println(index);
    }
}
