package baekjoon._1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = fr.nextInt();
        int plus = 1;
        for (int i = 0; i < n; i++) {
            int next = fr.nextInt();
            while(plus <= next) {
                stack.push(plus);
                sb.append("+\n");
                plus++;
            }
            if (stack.size() > 0 && stack.peek() == next) {
                stack.pop();
                sb.append("-\n");
            }
            else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }
}
