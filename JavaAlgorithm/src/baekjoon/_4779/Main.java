package baekjoon._4779;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static StringBuilder sb;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String next;
        while((next = br.readLine()) != null){
            N = Integer.parseInt(next);
            pro(N);
        }
    }

    private static void pro(int n) {
        char[] line = new char[(int)Math.pow(3, n)];
        Arrays.fill(line, '-');
        makeBlank(0, line.length, line);
        sb = new StringBuilder();
        for (char c : line) {
            sb.append(c);
        }
        System.out.println(sb);
    }

    private static void makeBlank(int start, int length, char[] line) {
        if(length < 3) return;

        for (int i = start + length/3; i < start+length/3*2; i++) {
            line[i] = ' ';
        }

        makeBlank(start, length/3, line);
        makeBlank(start + length/3*2, length/3, line);

    }

    public static void main(String[] args) throws IOException {
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
