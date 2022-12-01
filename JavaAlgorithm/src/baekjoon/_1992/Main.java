package baekjoon._1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        input();
        pro(N, 0 , 0);
        System.out.println(sb);
    }

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = fr.nextLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
    }

    public static void pro(int n, int r, int c) {
        if (n < 1) {
            return;
        }
        // 모두 같은지
        boolean isSame = true;
        loop: for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (map[i][j] != map[r][c]) {
                    isSame = false;
                    break loop;
                }
            }
        }
        if(isSame){
            if(map[r][c] == 0) sb.append(0);
            else sb.append(1);
        } else {
            sb.append("(");
            pro(n / 2, r, c);
            pro(n / 2, r, c + n / 2);
            pro(n / 2, r + n / 2, c);
            pro(n / 2, r + n / 2, c + n / 2);
            sb.append(")");
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
