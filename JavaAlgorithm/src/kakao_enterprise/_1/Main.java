package kakao_enterprise._1;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int row = 10, col = 10, ans = 0;
    static int hr, hc;
    static char[][] map;
    static boolean[][] visit;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws Exception {
        input();
        ans = bfs(hr, hc);
        System.out.println(ans);
    }

    private static int bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c, 0});
        visit[r][c] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curR = poll[0], curC = poll[1], cnt = poll[2];
            for (int i = 0; i < 4; i++) {
                int newR = curR + dir[i][0];
                int newC = curC + dir[i][1];
                if (newR < 0 || newC < 0 || newR >= row || newC >= col) continue;
                if (map[newR][newC] == 'R') continue;
                if (visit[newR][newC]) continue;
                visit[newR][newC] = true;
                queue.add(new int[]{newR, newC, cnt+1});
                if (map[newR][newC] == 'M') {
                    return cnt;
                }
            }
        }
        return ans;
    }

    public static void input() {
        FastReader fr = new FastReader();
        map = new char[10][col];
        visit = new boolean[row][col];
        for (int i = 0; i < 10; i++) {
                String curRow = fr.nextLine();
            for (int j = 0; j < col; j++) {
                char cur = curRow.charAt(j);
                map[i][j] = cur;
                if (cur == 'H') {
                    hr = i; hc = j;
                }
            }
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