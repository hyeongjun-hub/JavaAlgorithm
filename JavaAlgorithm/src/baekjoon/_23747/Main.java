package baekjoon._23747;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int R, C, hr, hc;
    static char[][] map, ans;
    static char[] record;
    static boolean[][] visit;
    static int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public static void input() {
        FastReader fr = new FastReader();
        R = fr.nextInt();
        C = fr.nextInt();
        map = new char[R][C];
        ans = new char[R][C];
        visit = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String s = fr.nextLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                ans[i][j] = '#';
            }
        }
        hr = fr.nextInt() - 1;
        hc = fr.nextInt() - 1;
        String input = fr.nextLine();
        record = input.toCharArray();
    }

    public static void main(String[] args) {
        input();
        for (char command : record) {
            switch (command) {
                case 'U':
                    hr -= 1;
                    break;
                case 'D':
                    hr += 1;
                    break;
                case 'L':
                    hc -= 1;
                    break;
                case 'R':
                    hc += 1;
                    break;
                case 'W':
                    bfs(hr, hc);
                    break;
                default:
                    return;
            }
        }
        // 탐색 끝 주변 시야
        ans[hr][hc] = '.';
        for (int i = 0; i < 4; i++) {
            int nr = hr + dir[i][0];
            int nc = hc + dir[i][1];
            if(nr < 0 || nc < 0|| nr >= R || nc >= C) continue;
            ans[nr][nc] = '.';
        }
        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            sb.append(ans[i]);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        visit[r][c] = true;
        ans[r][c] = '.';
        char base = map[r][c];
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cr = poll[0];
            int cc = poll[1];
            for (int i = 0; i < 4; i++) {
                int nr = cr + dir[i][0];
                int nc = cc + dir[i][1];
                if(nr < 0 || nc < 0|| nr >= R || nc >= C) continue;
                if(map[nr][nc] != base) continue;
                if(visit[nr][nc]) continue;
                visit[nr][nc] = true;
                ans[nr][nc] = '.';
                queue.add(new int[]{nr, nc});
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
