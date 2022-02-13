package baekjoon._11721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String inputString;

    public static void input() {
        FastReader fr = new FastReader();
        inputString = fr.nextLine();
    }

    public static void main(String[] args) {
        input();
        while (inputString.length() > 10) {
            String subString = inputString.substring(0, 10);
            System.out.println(subString);
            inputString = inputString.replaceFirst(subString, "");
        }
        System.out.println(inputString);

    }

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
}
