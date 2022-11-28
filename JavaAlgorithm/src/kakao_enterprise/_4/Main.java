package kakao_enterprise._4;

import java.io.*;
import java.util.StringTokenizer;

class Main {

    static int N, M, ans;
    static int[][] matrix;

    public static void main(String[] args) throws Exception {
        input();
        pro();
        System.out.println(ans);
    }

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        M = fr.nextInt();
        matrix = new int[N+1][N+1];
        for (int i = 0; i < M; i++) {
            int win = fr.nextInt();
            int lose = fr.nextInt();
            matrix[win][lose] = 1;
            matrix[lose][win] = -1;
        }
    }

    public static void pro() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if (matrix[i][j] == 1 && matrix[j][k] == 1) {
                        matrix[i][k] = 1;
                        matrix[k][i] = -1;
                    }
                    if (matrix[i][j] == -1 && matrix[j][k] == -1) {
                        matrix[i][k] = -1;
                        matrix[k][i] = 1;
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            int cnt = 0;
            for (int j = 1; j <= N; j++) {
                if(matrix[i][j] != 0) cnt++;
            }
            if(cnt == N - 1) ans++;
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