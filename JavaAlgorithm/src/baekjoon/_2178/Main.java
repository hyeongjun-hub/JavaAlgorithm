package baekjoon._2178;

/*
미로탐색
(Graph Traversal)

정답의 최대치 - 10000

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, ans = 1;
    static int[][] maze;
    static boolean[][] visit;
    static int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        M = fr.nextInt();
        maze = new int[N + 1][M + 1];
        visit = new boolean[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String str = fr.nextLine();
            str = " ".concat(str);
            for (int j = 1; j <= M; j++) {
                maze[i][j] = (str.charAt(j) - '0');
            }
        }
    }

    public static void bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        visit[r][c] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            r = poll[0];
            c = poll[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                if (nr < 1 || nc < 1 || nr > N || nc > M) continue;
                if (visit[nr][nc]) continue;
                if (maze[nr][nc] == 0) continue;
                maze[nr][nc] = maze[r][c] + 1;
                queue.add(new int[]{nr, nc});
                visit[nr][nc] = true;
                if(nr == N && nc == M) {
                    ans = maze[nr][nc];
                    return;
                }
            }
        }
    }

    public static void pro() {
        bfs(1, 1);
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
    }

//    public static void print() {
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= M; j++) {
//                System.out.print(maze[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }

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
