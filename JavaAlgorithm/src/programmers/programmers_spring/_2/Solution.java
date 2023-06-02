package programmers.programmers_spring._2;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static int[][] dir = {{-1, 0}, {-1, -1}, {-1, 1}, {0, -1}, {0, 1}, {1, 0}, {1, -1}, {1, 1}};
    static int[][] dir2 = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static char[][] map;
    static boolean[][] visit;
    static Queue<int[]> queue;
    static int R, C, ans;


    public int solution(String[] grid) {
        R = grid.length;
        C = grid[0].length();
        map = new char[R][C];
        visit = new boolean[R][C];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                map[i][j] = grid[i].charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '#') {
                    if(visit[i][j]) continue;
                    visit[i][j] = true;
                    bfs(i, j);
                }
            }
        }

        visit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '.') {
                    if(visit[i][j]) continue;
                    visit[i][j] = true;
                    bfs2(i, j);
                }
            }
        }



        return ans;
    }

    public static void bfs(int r, int c) {
        // # - 잇기
        queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        visit[r][c] = true;
        ans++;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cr = poll[0];
            int cc = poll[1];
            for (int i = 0; i < 8; i++) {
                int nr = cr + dir[i][0];
                int nc = cc + dir[i][1];
                if(nr < 0 || nc < 0 || nr >= R || nc >= C) break;
                if(visit[nr][nc]) continue;
                if(map[nr][nc] == '.') continue;
                visit[nr][nc] = true;
                ans++;
                queue.add(new int[]{nr, nc});
            }
        }
    }

    // 내부의 . 찾기

    public static void bfs2(int r, int c) {
        // # - 잇기
        int size = 1;
        queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        visit[r][c] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cr = poll[0];
            int cc = poll[1];
            for (int i = 0; i < 4; i++) {
                int nr = cr + dir2[i][0];
                int nc = cc + dir2[i][1];
                if(nr < 0 || nc < 0 || nr >= R || nc >= C) return;
                if(visit[nr][nc]) continue;
                if(map[nr][nc] == '#') continue;
                visit[nr][nc] = true;
                size++;
                queue.add(new int[]{nr, nc});
            }
        }
        ans += size;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(new String[]{".#.", "#.", ".#."});
        System.out.println(solution);
    }

}