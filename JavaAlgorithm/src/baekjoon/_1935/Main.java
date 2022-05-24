package baekjoon._1935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
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
        int repeat = fr.nextInt();
        Stack<Double> stack = new Stack<>();
        HashMap<Character, Double> map = new HashMap<>();
        String postfix = fr.nextLine();
        for (int i = 0; i < repeat; i++) {
            map.put((char) ('A' + i), (double) fr.nextInt());
        }
        char[] postfixChar = postfix.toCharArray();
        for (char oneChar : postfixChar) {
            if (oneChar == '+') {
                stack.push(stack.pop() + stack.pop());
            } else if (oneChar == '-') {
                Double mom = stack.pop();
                Double son = stack.pop();
                stack.push(son - mom);
            } else if (oneChar == '*') {
                stack.push(stack.pop() * stack.pop());
            } else if (oneChar == '/') {
                Double mom = stack.pop();
                Double son = stack.pop();
                stack.push( son / mom);
            } else {
                stack.push(map.get(oneChar));
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}
