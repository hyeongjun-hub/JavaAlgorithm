package baekjoon._2675;

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

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int inputNum = fr.nextInt();
        for (int i = 0; i < inputNum; i++) {
            StringBuilder sb = new StringBuilder();
            int repeatNum = fr.nextInt();
            String S = fr.next();
            char[] charArray = S.toCharArray();
            for(char oneChar: charArray) {
                sb.append(String.valueOf(oneChar).repeat(Math.max(0, repeatNum)));
            }
            System.out.println(sb);
        }
    }
}
