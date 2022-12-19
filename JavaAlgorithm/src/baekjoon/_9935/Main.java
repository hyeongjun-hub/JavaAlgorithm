package baekjoon._9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static String inputString, bomb;

    public static void input() {
        FastReader fr = new FastReader();
        inputString = fr.nextLine();
        bomb = fr.nextLine();
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    public static void pro() {
        char[] charArray = inputString.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            char cur = charArray[i];
            if (cur == bomb.charAt(bomb.length() - 1)) {

            }
        }
        if(inputString.length() == 0) inputString = "FRULA";
        System.out.println(inputString);

    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){ br = new BufferedReader(new InputStreamReader(System.in));}

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

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        Double nextDouble() { return Double.parseDouble(next()); }

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
}
