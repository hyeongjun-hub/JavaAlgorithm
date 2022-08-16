package groom.algorithm_monday.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1 {

    static int N, M;
    static FastReader fr = new FastReader();
    static char[][] map;
    static int[][] result;
    static int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};


    public static void input() {
        M = fr.nextInt();
        N = fr.nextInt();
        map = new char[N][M];
        result = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = fr.nextLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

    }

    public static void pro() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '*') {
                    result[i][j] = -1;
                    for (int k = 0; k < 8; k++) {
                        int ni = i + dir[k][0];
                        int nj = j + dir[k][1];
                        if(ni >= 0 && nj >= 0 && ni < N && nj < M && map[ni][nj] != '*')
                            result[ni][nj]++;
                    }
                }
            }
        }
    }

    public static void print(){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(result[i][j] == -1) sb.append('*');
                else sb.append(result[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static void main(String[] args) {
//        input();
//        pro();
//        print();
        double x = 10.0;
        if(Math.sqrt(x) % 1 == 0) System.out.println("cor");
        else System.out.println("not");
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
