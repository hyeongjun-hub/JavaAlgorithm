package baekjoon._2589;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int R, C, ans;
    static char[][] map;
    static boolean[][] visit;
    static int[][] dir = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    static int maxR, maxC;

    public static void input() {
        FastReader fr = new FastReader();
        R = fr.nextInt();
        C = fr.nextInt();
        map = new char[R][C];
        visit = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String curR = fr.nextLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = curR.charAt(j);
            }
        }
    }

    public static void main(String[] args) {
        input();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(visit[i][j]) continue;
                if(map[i][j] == 'W') continue;
                bfs(i, j);
                bfs(maxR, maxC);
                visit[i][j] = true;
            }
        }
        System.out.println(ans);
    }

    private static void bfs(int i, int j) {
        boolean[][] visited = new boolean[R][C];
        Queue<int[]> queue = new LinkedList<>();
        visited[i][j] = true;
        queue.add(new int[]{i, j, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int r = poll[0]; int c = poll[1];
            int dis = poll[2];
            for (int k = 0; k < 4; k++) {
                int nr = r + dir[k][0];
                int nc = c + dir[k][1];
                if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                if(map[nr][nc] == 'W') continue;
                if(visited[nr][nc]) continue;
                visited[nr][nc] = true;
                visit[nr][nc] = true;
                queue.add(new int[]{nr, nc, dis + 1});
            }
            if(dis > ans) {maxR = r; maxC = c;System.out.println(dis);
                System.out.println("" + r + " " + c);
            }
            ans = Math.max(ans, dis);
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
