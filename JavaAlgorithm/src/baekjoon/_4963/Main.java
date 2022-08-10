package baekjoon._4963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static boolean[][] visit;
    static int w, h, ans;
    static Queue<int[]> queue;
    static int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};


    public static void input() {
        FastReader fr = new FastReader();
        while (true) {
            w = fr.nextInt();
            h = fr.nextInt();
            if(w == 0 && h == 0) return;

            ans = 0;
            map = new int[h][w];
            visit = new boolean[h][w];
            queue = new LinkedList<>();
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    map[i][j] = fr.nextInt();
                }
            }
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(!visit[i][j] && map[i][j] == 1){
                        bfs(i, j);
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }
    }

    public static void bfs(int i, int j) {
        queue.add(new int[]{i, j});
        visit[i][j] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curH = poll[0];
            int curW = poll[1];
            for (int k = 0; k < 8; k++) {
                int nh = curH + dir[k][0];
                int nw = curW + dir[k][1];
                if(nw < 0 || nh < 0 || nw >= w || nh >= h) continue;
                if(visit[nh][nw]) continue;
                if(map[nh][nw] == 0) continue;
                queue.add(new int[]{nh, nw});
                visit[nh][nw] = true;
            }
        }
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
