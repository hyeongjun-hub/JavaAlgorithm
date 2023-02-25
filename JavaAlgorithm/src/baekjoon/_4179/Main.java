package baekjoon._4179;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static String answer = "IMPOSSIBLE";
    static int R, C;
    static char[][] map;
    static int[][] fireMap;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void input() {
        FastReader fr = new FastReader();
        R = fr.nextInt();
        C = fr.nextInt();
        map = new char[R][C];
        fireMap = new int[R][C];
        int jr = 0;
        int jc = 0;

        for (int i = 0; i < R; i++) {
            String s = fr.nextLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
                fireMap[i][j] = R * C + 1;
                if (map[i][j] == 'J') {
                    jr = i;
                    jc = j;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'F') bfs(i, j, true);
            }
        }
        bfs(jr, jc, false);
        System.out.println(answer);
    }


public static void bfs(int r, int c, boolean isFire) {
    boolean[][] visit = new boolean[R][C];
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{r, c, 1});
    visit[r][c] = true;
    while (!queue.isEmpty()) {
        int[] poll = queue.poll();
        r = poll[0];
        c = poll[1];
        int dis = poll[2];
        if (isFire) fireMap[r][c] = Math.min(dis, fireMap[r][c]);
        for (int i = 0; i < 4; i++) {
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];
            if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
                if (!isFire) {
                    if (dis < fireMap[r][c]) {
                        answer = String.valueOf(dis);
                        return;
                    }
                }
                continue;
            }
            if (map[nr][nc] != '.') continue;
            if (visit[nr][nc]) continue;
            visit[nr][nc] = true;
            queue.add(new int[]{nr, nc, dis + 1});
        }
    }
}

    public static void main(String[] args) {
        input();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
