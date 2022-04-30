package baekjoon._10809;

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

    static String S;
    static int[] alphabet = new int[26];

    public static void input() {
        FastReader fr = new FastReader();
        S = fr.nextLine();
        for (int i = 0; i < 26; i++) {
            alphabet[i] = -1;
        }
    }

    public static void main(String[] args) {
        input();
        char[] stringCharArray = S.toCharArray();
        for (int i = 0; i < stringCharArray.length; i++) {
            int byteNum = stringCharArray[i] - 'a';
            if(alphabet[byteNum] == -1) alphabet[byteNum] = i;
        }
        for (int alpha : alphabet) {
            System.out.print(alpha + " ");
        }
    }
}

