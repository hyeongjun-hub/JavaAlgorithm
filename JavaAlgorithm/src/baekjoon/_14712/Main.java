package baekjoon._14712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, answer;
    static boolean[][] map;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        M = fr.nextInt();
        map = new boolean[N][M];
        nemo(0, 0);
    }

    private static void nemo(int r, int c) {
        if (r == N) {
            // 배치된 넴모들이 2 x 2 를 이루는지 확인 => 4 칸(2 x 2) 씩 확인
            for (int i = 0; i <= N - 2; i++) {
                for (int j = 0; j <= M - 2; j++) {
                    // 2 x 2 를 이루는 경우
                    if (map[i][j] && map[i][j+1] &&
                            map[i+1][j] && map[i+1][j+1])
                        return;
                }
            }

            answer++;
            return;
        }

        int nextCol = (c + 1 == M) ? 0 : c + 1;
        int nextRow = (nextCol == 0) ? r + 1 : r;

        map[r][c] = true;
        nemo(nextRow, nextCol);
        map[r][c] = false;
        nemo(nextRow, nextCol);

    }


    public static void main(String[] args) {
        input();
        System.out.println(answer);
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
