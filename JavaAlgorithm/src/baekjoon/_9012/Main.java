package baekjoon._9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int T;

    public static void input() {
        FastReader fr = new FastReader();
        T = fr.nextInt();
        while (T-- > 0) {
            String inputString = fr.nextLine();
            pro(inputString);
        }
    }

    public static void pro(String inputString) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < inputString.length(); i++) {
            if(inputString.charAt(i) == '(') st.push('(');
            else if(inputString.charAt(i) == ')' && !st.isEmpty()){ st.pop();}
            else{ st.push(')'); break; }
        }
        if(st.isEmpty()) System.out.println("YES");
        else System.out.println("NO");
    }

    public static void main(String[] args) {
        input();
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
