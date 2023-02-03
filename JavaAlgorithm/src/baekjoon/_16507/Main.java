package baekjoon._16507;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R, C, Q, r1, c1, r2, c2;
    static int[][] map, row, col, hap;

    public static void input() {
        FastReader fr = new FastReader();
        R = fr.nextInt();
        C = fr.nextInt();
        Q = fr.nextInt();
        map = new int[R + 1][C + 1];
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                map[i][j] = fr.nextInt();
            }
        }
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {

            }
        }
        for (int i = 0; i < Q; i++) {
            r1 = fr.nextInt();
            c1 = fr.nextInt();
            r2 = fr.nextInt();
            c2 = fr.nextInt();
            System.out.println(pro(r1, c1, r2, c2));
        }
    }

    public static int pro(int r1, int c1, int r2, int c2) {


        return 0;
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
