package baekjoon._1863;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] height;

    public static void input() {
        FastReader fr = new FastReader();
        n = fr.nextInt();
        height = new int[n];
        for (int i = 0; i < n; i++) {
            int x = fr.nextInt();
            height[i] = fr.nextInt();
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    public static void pro() {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int h : height) {
            // 0을 저장하면 안되므로 스택을 비움
            if (h == 0) {
                ans += stack.size();
                stack.clear();
            }
            else if (!stack.isEmpty()) {
                int peek = stack.peek();
                // 높이가 높아지면 스택에 push
                if (peek < h) {
                    stack.push(h);
                } else {
                    // 높이가 낮아지면 그 높이보다 높은 건물들은 스택에서 꺼냄
                    while (!stack.isEmpty() && stack.peek() > h) {
                        stack.pop();
                        ans++;
                    }
                    // 스택에 없는 새로운 높이라면 push
                    if(!stack.isEmpty() && stack.peek() < h) stack.push(h);
                    if(stack.isEmpty()) stack.push(h);
                }
            } else {
                // 스택이 비어있으면 무조건 push
                stack.push(h);
            }
        }
        ans += stack.size();
        stack.clear();
        System.out.println(ans);
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
