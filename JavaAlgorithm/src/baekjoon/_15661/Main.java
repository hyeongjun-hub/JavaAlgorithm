package baekjoon._15661;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, answer, t = 0 ;
    static int[][] S;
    static boolean[] visit;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        S = new int[N][N];
        visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                S[i][j] = fr.nextInt();
            }
        }
        for (t = 1; t < N; t++) {
            nCr(0, 0);
        }
        System.out.println(answer);
    }

    public static void nCr(int depth, int start) {
        if (depth == t) {
            answer = Math.min(answer, diff());
            if (answer == 0) {
                System.out.println(answer);
                System.exit(0);
            }
            return;
        }
        for (int i = start; i < N; i++) {
            visit[i] = true;
            nCr(depth + 1, i + 1);
            visit[i] = false;
        }

    }

    public static int diff() {
        int start = 0; // v[] 값이 true면 start팀
        int link = 0; //  v[] 값이 false면 link팀
        for(int i=0; i<N-1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visit[i] && visit[j]) {
                    start += (S[i][j] + S[j][i]);
                } else if (!visit[i] && !visit[j]) {
                    link += (S[i][j] + S[j][i]);
                }
            }
        }
        return Math.abs(start - link);
    }


    public static void main(String[] args) {
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
