package baekjoon._2512;

/*
예산
(binary search)

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, ans, M;
    static int[] budget;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        budget = new int[N];
        for (int i = 0; i < N; i++) {
            budget[i] = fr.nextInt();
        }
        M = fr.nextInt();
    }

    public static void pro() {
        Arrays.sort(budget);

        int L = 1;
        int R = budget[N - 1];
        while(L <= R){
            int mid = (L + R) / 2;
            if(determination(mid)) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        System.out.println(ans);
    }

    private static boolean determination(int mid) {
        int sum = 0;
        for (int i : budget) {
            if (i > mid) sum += mid;
            else  sum += i;
        }
        return sum <= M;
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
