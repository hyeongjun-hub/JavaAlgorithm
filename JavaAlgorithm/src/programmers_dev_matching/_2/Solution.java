package programmers_dev_matching._2;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static boolean[][] visit;
    static int[][] map;

    static void bfs(int r, int c, boolean horizontal, int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        visit[r][c] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            r = poll[0];
            c = poll[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];

                if(nr < 1 || nc < 1 || nr > n || nc > n) continue;

            }
        }
    }

    public int[][] solution(int n, boolean horizontal) {
        visit = new boolean[n+1][n+1];
        map = new int[n+1][n+1];
        bfs(1, 1, horizontal, n);



        return map;
    }
}