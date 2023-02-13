package baekjoon._21922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N, M, ans;
    static int[][] map;
    static boolean[][] visit;
    static Stack<int[]> aircon = new Stack<>();

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        M = fr.nextInt();
        map = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = fr.nextInt();
                if (map[i][j] == 9) {
                    aircon.add(new int[]{i, j});
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        while (!aircon.isEmpty()) {
            int[] pop = aircon.pop();
            int ar = pop[0];
            int ac = pop[1];
            blow(ar, ac);
        }
        System.out.println(ans);
    }

    public static void blow(int ar, int ac) {
        if(!visit[ar][ac]){ ans++;}
        visit[ar][ac] = true;
        // up
        go(ar - 1, ac, 0);
        // right
        go(ar, ac + 1, 1);
        // down
        go(ar + 1, ac, 2);
        // left
        go(ar, ac - 1, 3);

    }

    // 좌표와 방향
    public static void go(int r, int c, int dir) {
        if(r < 0 || c < 0 || r >= N || c >= M) return;
        if(!visit[r][c]){ ans++;}

        visit[r][c] = true;

        switch (dir) {
            case 0:
                // up
                if(map[r][c] == 0 || map[r][c] == 1) go(r - 1, c, dir);
                if(map[r][c] == 2) return;
                if(map[r][c] == 3) go(r, c + 1, 1); // right
                if(map[r][c] == 4) go(r, c - 1, 3);
                break;
            case 1:
                // right
                if(map[r][c] == 0 || map[r][c] == 2) go(r, c + 1, dir);
                if(map[r][c] == 1) return;
                if(map[r][c] == 3) go(r-1, c, 0);
                if(map[r][c] == 4) go(r+1, c , 2);
                break;
            case 2:
                // down
                if(map[r][c] == 0 || map[r][c] == 1) go(r + 1, c, dir);
                if(map[r][c] == 2) return;
                if(map[r][c] == 3) go(r, c - 1, 3);
                if(map[r][c] == 4) go(r, c + 1, 1);
                break;
            default:
                // left
                if(map[r][c] == 0 || map[r][c] == 2) go(r, c - 1, dir);
                if(map[r][c] == 1) return;
                if(map[r][c] == 3) go(r + 1, c, 2);
                if(map[r][c] == 4) go(r - 1, c, 0);
                break;
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
