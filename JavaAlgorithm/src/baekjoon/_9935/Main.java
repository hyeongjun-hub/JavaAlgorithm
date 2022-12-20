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
        StringBuilder sb = new StringBuilder();
        char[] charArray = inputString.toCharArray();

        for (int i = 0; i < inputString.length(); i++) {
            char cur = inputString.charAt(i);
            sb.append(cur);
            if (cur == bomb.charAt(bomb.length() - 1) && sb.length() >= bomb.length()) {
                boolean same = true;
                // 같은 지 확인
                for (int j = 0; j < bomb.length()-1; j++) {
                    if (bomb.charAt(j) != sb.charAt(sb.length() - bomb.length() + j)) {
                        same = false;
                        break;
                    }
                }
                if(same) sb.delete(sb.length() - bomb.length(), sb.length());
            }
        }
        if(sb.length() == 0) System.out.println("FRULA");
        else System.out.println(sb);

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
