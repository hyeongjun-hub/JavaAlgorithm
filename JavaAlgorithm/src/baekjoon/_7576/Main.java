package baekjoon._7576;

/*
토마토
(Graph Traversal)

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] graph;
    static boolean[][] visit;
    static Queue<int[]> queue = new LinkedList<>();
    static int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public static void input() {
        FastReader fr = new FastReader();
        M = fr.nextInt();
        N = fr.nextInt();
        graph = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                graph[i][j] = fr.nextInt();
            }
        }
    }

    public static void isComplete(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(graph[i][j] == 1){
                    queue.add(new int[]{i, j});
                }
            }
        }
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(graph[nx][ny] != 0) continue;
                graph[nx][ny] = graph[x][y] + 1;
                queue.add(new int[]{nx, ny});
            }
        }
    }

    public static void main(String[] args) {
        input();
        isComplete();
        bfs();
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0) {
                    //토마토가 모두 익지 못한 상황이라면 -1 을 출력한다.
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, graph[i][j]);
            }
        }
        System.out.println(max - 1);
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
