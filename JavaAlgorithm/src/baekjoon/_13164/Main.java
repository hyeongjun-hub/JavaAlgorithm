package baekjoon._13164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, K;
    static int[] students;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        K = fr.nextInt();
        students = new int[N];
        for (int i = 0; i < N; i++) students[i] = fr.nextInt();
    }

    public static void pro() {
        int ans= 0;
        Arrays.sort(students);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            list.add(students[i] - students[i - 1]);
        }
        Collections.sort(list);

        for (int i = 0; i < N-K; i++) {
            ans += list.get(i);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
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
