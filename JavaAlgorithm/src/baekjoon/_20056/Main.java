package baekjoon._20056;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
마법사 상어와 파이어볼
(simulation)


 */

public class Main {

    static int N, M, K;
    static ArrayList<Node>[][] map = new ArrayList[N + 1][N + 1];
    static int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    static Queue<int[]> queue;

    static class Node {
        int r, c, m, s, d;

        public Node(int m, int s, int d) {
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        M = fr.nextInt();
        K = fr.nextInt();
        map = new ArrayList[N + 1][N + 1];
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                map[i][j] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int r = fr.nextInt();
            int c = fr.nextInt();
            map[r][c].add(new Node(fr.nextInt(), fr.nextInt(), fr.nextInt()));
        }
    }

    public static void pro() {
        while (K > 0) {
            move();
            K--;
        }
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(map[i][j] == null) continue;
                for (Node node : map[i][j]) {
                    ans += node.m;
                }
            }
        }
        System.out.println(ans);
    }

    private static void move() {
        queue = new LinkedList<>();
        Queue<int[]> calQue = new LinkedList<>();
        findFire(queue);
        ArrayList<Node>[][] newMap = new ArrayList[N + 1][N + 1];
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                newMap[i][j] = new ArrayList<>();
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int r = poll[0];
            int c = poll[1];
            for (Node cur : map[r][c]) {
                int nr = r + cur.s * dir[cur.d][0];
                int nc = c + cur.s * dir[cur.d][1];
                while (nr > N || nr < 1) nr = correct(nr);
                while (nc > N || nc < 1) nc = correct(nc);
                newMap[nr][nc].add(cur);
            }

        }
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                if (newMap[i][j].size() >= 2) calQue.add(new int[]{i, j});

        map = newMap;

        while (!calQue.isEmpty()) {
            int[] poll = calQue.poll();
            int r = poll[0];
            int c = poll[1];
            int m = 0;
            int s = 0;
            int odd = 0;
            int even = 0;
            for (Node node : newMap[r][c]) {
                m += node.m;
                s += node.s;
                if (node.d % 2 == 0) even++;
                else odd++;
            }
            m /= 5;
            s /= newMap[r][c].size();
            int i;
            if (odd == newMap[r][c].size() || even == newMap[r][c].size()) i = 0;
            else i = 1;
            newMap[r][c].clear();
            if (m == 0) continue;
            for (; i < 8; i += 2) {
//                int nr = r + s * dir[i][0];
//                int nc = c + s * dir[i][1];
//                while (nr > N || nr < 1) nr = correct(nr);
//                while (nc > N || nc < 1) nc = correct(nc);
                newMap[r][c].add(new Node(m, s, i));
            }
        }
        map = newMap;
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                if (map[i][j].size() == 0) System.out.print(0);
//                else System.out.print(map[i][j].get(0).m);
//                System.out.print(' ');
//            }
//            System.out.println();
//        }
//        System.out.println();
    }

    private static int correct(int nr) {
        if (nr < 1) return nr + N;
        else return nr - N;
    }

    private static void findFire(Queue<int[]> queue) {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] == null) continue;
                queue.add(new int[]{i, j});
            }
        }
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
