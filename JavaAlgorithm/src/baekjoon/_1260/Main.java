package baekjoon._1260;

/*
DFS 와 BFS
(그래프)

인접행렬로 풀어보기
0 0 0 0
1 0 1 0
0 1 0 0
0 0 0 0
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] adj;
    static boolean[] visit;
    static int N, M, V;
    static StringBuilder sb = new StringBuilder();

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        M = fr.nextInt();
        V = fr.nextInt();
        adj = new int[N + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            int x = fr.nextInt(), y = fr.nextInt();
            adj[x][y] = 1;
            adj[y][x] = 1;
        }
        visit = new boolean[N + 1];
    }

    static void dfs(int x) {
        visit[x] = true;
        sb.append(x).append(' ');
        for (int y = 1; y <= N; y++) {
            if(adj[x][y] == 0) continue;
            if(visit[y]) continue;
            dfs(y);
        }
    }

    static void bfs(int x) {
        Queue<Integer> que = new LinkedList<>();

        que.add(x);
        visit[x] = true;

        while (!que.isEmpty()) {
            x = que.poll();
            sb.append(x).append(' ');

            for (int y = 1; y <= N; y++) {
                if(adj[x][y] == 0) continue;
                if(visit[y]) continue;

                que.add(y);
                visit[y] = true;
            }
        }
    }

    static void pro() {
        dfs(V);
        sb.append('\n');
        // 초기화
        for (int i = 1; i <= N; i++) visit[i] = false;
        bfs(V);

        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        pro();
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
