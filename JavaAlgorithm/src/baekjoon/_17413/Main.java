package baekjoon._17413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static String S;
    static StringBuilder sb = new StringBuilder();
    static Stack<Character> stack = new Stack<>();

    public static void input() {
        FastReader fr = new FastReader();
        S = fr.nextLine();
    }

    public static void pro() {
        boolean isIn = false;
        for (int i = 0; i < S.length(); i++) {
            if (isIn && S.charAt(i) != '>') {
                sb.append(S.charAt(i));
                continue;
            }
            if (S.charAt(i) == '<') {
                isIn = true;
                while(!stack.isEmpty()) sb.append(stack.pop());
                sb.append(S.charAt(i));
                continue;
            }
            if (isIn && S.charAt(i) == '>') {
                isIn = false;
                sb.append(S.charAt(i));
                continue;
            }
            if (S.charAt(i) == ' ') {
                while(!stack.isEmpty()) sb.append(stack.pop());
                sb.append(' ');
                continue;
            }
            stack.push(S.charAt(i));
        }
        while(!stack.isEmpty()) sb.append(stack.pop());
    }

    public static void main(String[] args) {
        input();
        pro();
        System.out.println(sb);
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
