package baekjoon._14502;

/*
연구소
(Graph Traverse)

정답 최대
N^2
B : 빈 공간

1. BC3가지 경우 만큼 직접 벽을 세움 (완전탐색) -> 41000번
2. 매번 직접 탐색을 통해 바이러스로부터 안전한 구역 확인하기 O(T)
=> O(41K * T) 만큼 시간걸림

이전과 다르게 시작점이 여러개 (바이러스 개수)
-> Multisource BFS
Queue안에 모든 시작점을 넣고 BFS 시작
(상상의 점 V를 만들고 모든 시작점으로 향할 수 있는 가상의 간선이 존재한다고 생각, 그리고 V로 시작)

O(T) = O(N^2)
=> O(41K * T) ~= O(31K * 64 = 260만)
가능

 */

import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M, B, ans;
    static int[][] A, blank;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        A = new int[N + 1][M + 1];
        blank = new int[N * M + 1][2];
        visit = new boolean[N + 1][M + 1];
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= M; j++)
                A[i][j] = scan.nextInt();
    }

    // 바이러스 퍼뜨리기!!
    static void bfs() {
        Queue<Integer> Q = new LinkedList<>();

        // 모든 바이러스가 시작점으로 가능하니까, 전부 큐에 넣어준다.
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                visit[i][j] = false;
                if (A[i][j] == 2) {
                    Q.add(i);
                    Q.add(j);
                    visit[i][j] = true;
                }
            }
        }

        // BFS 과정
        while (!Q.isEmpty()) {
            int x = Q.poll(), y = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0], ny = y + dir[k][1];
                if (nx < 1 || ny < 1 || nx > N || ny > M) continue;
                if (A[nx][ny] != 0) continue;
                if (visit[nx][ny]) continue;
                visit[nx][ny] = true;
                Q.add(nx);
                Q.add(ny);
            }
        }

        // 탐색이 종료된 시점이니, 안전 영역의 넓이를 계산하고, 정답을 갱신한다.
        int cnt = 0;
        for (int i = 1; i <= N; i++) for (int j = 1; j <= M; j++) if (A[i][j] == 0 && !visit[i][j]) cnt++;
        ans = Math.max(ans, cnt);
    }

    // idx 번째 빈 칸에 벽을 세울 지 말 지 결정해야 하고, 이 전까지 selected_cnt 개의 벽을 세웠다.
    static void dfs(int idx, int selected_cnt) {
        if (selected_cnt == 3) {  // 3 개의 벽을 모두 세운 상태
            bfs();
            return;
        }
        if (idx > B) return;  // 더 이상 세울 수 있는 벽이 없는 상태

        A[blank[idx][0]][blank[idx][1]] = 1;
        dfs(idx + 1, selected_cnt + 1);

        A[blank[idx][0]][blank[idx][1]] = 0;
        dfs(idx + 1, selected_cnt);
    }

    static void pro() {
        // 모든 벽의 위치를 먼저 모아놓자.
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (A[i][j] == 0) {
                    B++;
                    blank[B][0] = i;
                    blank[B][1] = j;
                }
            }
        }

        // 벽을 3개 세우는 모든 방법을 확인해보자!
        dfs(1, 0);
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

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
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

        double nextDouble() {
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