package baekjoon._2583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, K, ans;
    static int[][] map;
    static Queue<int[]> queue;
    static boolean[][] visit;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void input() {
        FastReader fr = new FastReader();
        M = fr.nextInt();
        N = fr.nextInt();
        K = fr.nextInt();
        map = new int[M][N];
        visit = new boolean[M][N];
        for (int i = 0; i < K; i++) {
            int lx = fr.nextInt();
            int ly = fr.nextInt();
            int rx = fr.nextInt();
            int ry = fr.nextInt();
            for (int j = ly; j < ry; j++) {
                for (int k = lx; k < rx; k++) {
                    visit[j][k] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        ArrayList<Integer> arrayList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(visit[i][j]) continue;
                ans++;
                arrayList.add(bfs(i, j));
            }
        }
        Collections.sort(arrayList);
        for (Integer integer : arrayList) {
            sb.append(integer);
            sb.append(" ");
        }
        System.out.println(ans);
        System.out.println(sb);
    }

    public static int bfs(int r, int c) {
        queue = new LinkedList<>();

        queue.add(new int[]{r, c, 1});
        visit[r][c] = true;
        int max = 1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cr = poll[0];
            int cc = poll[1];
            for (int i = 0; i < 4; i++) {
                int nr = cr + dir[i][0];
                int nc = cc + dir[i][1];
                if(nr < 0 || nc < 0 || nr >= M || nc >= N) continue;
                if(visit[nr][nc]) continue;
                max++;
                visit[nr][nc] = true;
                queue.add(new int[]{nr, nc});
            }
        }
        return max;
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
