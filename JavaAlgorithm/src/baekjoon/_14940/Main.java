package baekjoon._14940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] map;
    static boolean[][] visit;
    static int tr, tc;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void input() {
        FastReader fr = new FastReader();
        n = fr.nextInt();
        m = fr.nextInt();
        map = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = fr.nextInt();
                if(map[i][j] == 2){
                    tr = i;
                    tc = j;
                }
            }
        }
        map[tr][tc]=1;
        bfs(tr, tc);
    }

    public static void bfs(int trr, int tcc) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{trr, tcc, -1});
        visit[trr][tcc] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int r = poll[0];
            int c = poll[1];
            int cnt = poll[2];
            map[r][c] += cnt;
            for (int i = 0; i < 4; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                if(map[nr][nc] == 0) continue;
                if(visit[nr][nc]) continue;
                visit[nr][nc] = true;
                queue.add(new int[]{nr, nc, cnt+1});
            }
        }
    }

    public static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visit[i][j] && map[i][j]==1) sb.append(-1);
                else sb.append(map[i][j]);
                sb.append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        print();
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
