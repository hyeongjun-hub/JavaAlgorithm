package baekjoon._16234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, L, R, day = 0;
    static int[][] A;
    static boolean[][] visit;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static ArrayList<int[]> list;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        L = fr.nextInt();
        R = fr.nextInt();
        A = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = fr.nextInt();
            }
        }

    }

    // 국경선을 여는 bfs
    public static int bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        list = new ArrayList<>();

        visit[r][c] = true;
        list.add(new int[]{r, c});
        queue.add(new int[]{r, c});

        int sum = A[r][c];

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            r = cur[0];
            c = cur[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if(visit[nr][nc]) continue;
                if(Math.abs(A[r][c] - A[nr][nc]) < L || Math.abs(A[r][c] - A[nr][nc]) > R) continue;
                visit[nr][nc] = true;
                sum += A[nr][nc];
                list.add(new int[]{nr, nc});
                queue.add(new int[]{nr, nc});
            }
        }

        return sum;
    }

    public static void update(int update) {
        int avg = update / list.size();
        for (int[] ints : list) {
            int r = ints[0];
            int c = ints[1];
            A[r][c] = avg;
        }
    }

    public static void pro() {
        while(true){
            boolean isEnd = false;
            visit = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visit[i][j]) continue;
                    int sum = bfs(i, j);
                    if (list.size() > 1) {
                        update(sum);
                        isEnd = true;
                    }
                }
            }
            if(!isEnd) return;
            day++;
        }
    }

    static void print(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(A[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
        System.out.println();
    }

//    public static void isEnd(){
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                if(visit[i][j]) continue;
//                bfs(i, j);
//            }
//        }
//    }

    public static void main(String[] args) {
        input();
        pro();
        System.out.println(day);
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
