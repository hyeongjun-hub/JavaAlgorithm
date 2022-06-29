package baekjoon._5547;

/*
일루미네이션
(Graph Traversal)

정답 최대값
1 ~ W, H ~ 100
100*100*6/2
int 가능

BFS -> O(N^2)

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int W, H, ans;
    static int[][] graph;
    static boolean[][] blank;
    static Queue<int[]> queue = new LinkedList<>();
    static int[][] odd = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {0, -1}};
    static int[][] even = {{-1, -1}, {-1, 0}, {0, 1}, {1, 0}, {1, -1}, {0, -1}};

    public static void input() {
        FastReader fr = new FastReader();
        W = fr.nextInt();
        H = fr.nextInt();
        graph = new int[H + 2][W + 2];
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {
                graph[i][j] = fr.nextInt();
            }
        }
        blank = new boolean[H + 2][W + 2];
    }

    public static void checkOut(int row, int col, int i) {
        int newRow, newCol;
        if (row % 2 == 0) {
            newRow = row + even[i][0];
            newCol = col + even[i][1];
        } else {
            newRow = row + odd[i][0];
            newCol = col + odd[i][1];
        }
        if (newRow >= 0 && newRow <= H + 1 && newCol >= 0 && newCol <= W + 1) {
            if (!blank[newRow][newCol]) {
                if (graph[newRow][newCol] == 0) {
                    blank[newRow][newCol] = true;
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }
    }

    public static void bfs(int row, int col) {
        queue.add(new int[]{row, col});
        blank[row][col] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            row = cur[0];
            col = cur[1];
            for (int i = 0; i < 6; i++) {
                checkOut(row, col, i);
            }
        }
    }

    public static void findWall(int row, int col) {
        if (graph[row][col] == 0) return;
        for (int k = 0; k < 6; k++) {
            int newRow, newCol;
            if (row % 2 == 0) {
                newRow = row + even[k][0];
                newCol = col + even[k][1];
            } else {
                newRow = row + odd[k][0];
                newCol = col + odd[k][1];
            }
            if (blank[newRow][newCol]) ans++;
        }
    }

    public static void pro() {
        bfs(0, 0);
        for (boolean[] booleans : blank) {
            for (boolean aBoolean : booleans) {
                System.out.print(aBoolean);
                System.out.print(' ');
            }
            System.out.println();
        }
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {
                findWall(i, j);
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
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

        long nextLong() {
            return Long.parseLong(next());
        }

        Double nextDouble() {
            return Double.parseDouble(next());
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
