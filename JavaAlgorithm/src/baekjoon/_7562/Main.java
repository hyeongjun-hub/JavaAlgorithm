package baekjoon._7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static FastReader fr = new FastReader();

    static int T, l, kr, kc, tr, tc;
    static int[][] map;
    static boolean[][] visit;
    static int[][] dir = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};

    public static void pro() {
        T = fr.nextInt();
        while (T-- > 0) {
            l = fr.nextInt();
            map = new int[l][l];
            visit = new boolean[l][l];
            kr = fr.nextInt();
            kc = fr.nextInt();
            tr = fr.nextInt();
            tc = fr.nextInt();
            bfs(kr, kc);
        }
    }

    private static void bfs(int kr, int kc) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{kr, kc, 0});
        visit[kr][kc] = true;

        if (kr == tr && kc == tc) {
            System.out.println(0);
            return;
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int r = poll[0];
            int c = poll[1];
            int cnt = poll[2];

            for (int i = 0; i < 8; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];

                if(nr < 0 || nc < 0 || nr >= l || nc >= l) continue;
                if(visit[nr][nc]) continue;
                if (nr == tr && nc == tc) {
                    System.out.println(cnt+1);
                    return;
                }
                visit[nr][nc] = true;
                queue.add(new int[]{nr, nc, cnt+1});
            }
        }
    }

    public static void main(String[] args) {
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
