package baekjoon._11663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader fr = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] num;

    public static void input() {
        N = fr.nextInt();
        M = fr.nextInt();
        num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = fr.nextInt();
        }
        Arrays.sort(num);
        for (int i = 0; i < M; i++) {
            int L = fr.nextInt();
            int R = fr.nextInt();

            findPoint(L, R);
        }
    }

    private static void findPoint(int l, int r) {
        int left = 0;
        int right = num.length - 1;

        while (left <= right) {
            int mid = ( left + right) / 2;
            if (num[mid] > r) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        int endIndex = right + 1;
        left = 0;
        right = num.length - 1;

        while (left <= right) {
            int mid = ( left + right) / 2;
            if (num[mid] < l) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        int startIndex = left;

        sb.append(endIndex - startIndex).append("\n");
    }

    public static void main(String[] args) {
        input();
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
