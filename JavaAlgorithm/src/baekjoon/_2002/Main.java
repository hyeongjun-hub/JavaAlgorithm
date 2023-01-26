package baekjoon._2002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N, ans;
    static String[] input, output;
    static Stack<String> visit = new Stack<>();


    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        input = new String[N];
        output = new String[N];

        for (int i = 0; i < N; i++) {
            input[i] = fr.nextLine();
        }
        for (int i = 0; i < N; i++) {
            output[i] = fr.nextLine();
        }
    }

    public static void main(String[] args) {
        input();
        process();
        System.out.println(ans);
    }

    public static void process() {
        for (int i = 0; i < N; i++) {
            String car = input[i];
            if(visit.contains(car)) continue;
            for (int j = 0; j < N; j++) {
                if(visit.contains(output[j])) continue;
                visit.add(output[j]);
                if (!car.equals(output[j])) {
                    ans++;
                }
                // 만약 자기 자신이라면
                else {
                    break;
                }
            }
            visit.add(car);
        }
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
