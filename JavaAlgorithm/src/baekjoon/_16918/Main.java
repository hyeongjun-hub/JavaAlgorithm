package baekjoon._16918;

/*
봄버맨
(Graph Traversal)

1 <= R, C, N <= 200

BFS * N초
O(R * C * N) = 200 * 200 * 200 = 8,000,000

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R, C, N;
    static char graph[][];
    static int[][] visit;
    static int time = 1;
    static int[][] dir = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
    static StringBuilder sb = new StringBuilder();

    public static void input() {
        FastReader fr = new FastReader();
        R = fr.nextInt();
        C = fr.nextInt();
        N = fr.nextInt();
        graph = new char[R][C];
        visit = new int[R][C];
        for (int i = 0; i < R; i++) {
            String str = fr.nextLine();
            for (int j = 0; j < C; j++) {
                graph[i][j] = str.charAt(j);
                if(graph[i][j] == 'O'){
                    visit[i][j] = 3;
                }
            }
        }
    }

    public static void setBomb() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (graph[i][j] == '.') {
                    graph[i][j] = 'O';
                    visit[i][j] = time+3;
                }
            }
        }
    }

    public static void doBomb() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (visit[i][j] == time) {
                    bfs(i, j);
                }
            }
        }
    }

    public static void bfs(int row, int col) {
        graph[row][col] = '.';

        for (int i = 0; i < 4; i++) {
            int newRow = row + dir[i][0];
            int newCol = col + dir[i][1];
            if(newRow < 0 || newCol < 0 || newRow >= R || newCol >= C) continue;
            if(graph[newRow][newCol] == '.') continue;
            if(visit[newRow][newCol] == time) continue;
            graph[newRow][newCol] = '.';
            visit[newRow][newCol] = 0;
        }
    }

    public static void pro() {
        while (time <= N) {
            if(time % 2 == 0){
                setBomb();
            } else {
                doBomb();
            }
            time++;
        }
    }

    public static void print() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(graph[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        input();
        pro();
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
