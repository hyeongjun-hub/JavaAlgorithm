package baekjoon._2667;

/*
단지 번호 붙이기
(Graph Traverse)

N <= 25

정답의 최대치
1. 전부 1
2. 1, 0 체스판처럼 존재
집의 수 : N^2
단지의 개수 : N^2/2

<격자형 그래프>
정점 : O(N^2)
간선 : O(N^2 * 4)

BFS든 DFS든 시간복잡도는 O(V+E) = O(N^2)

 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N, group_cnt;
    static ArrayList<Integer> group;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static String[] a;

    static StringBuilder sb = new StringBuilder();

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        a = new String[N];
        for (int i = 0; i < N; i++) {
            a[i] = fr.nextLine();
        }
        visit = new boolean[N][N];
    }

    // x, y를 갈 수 있다는 것을 알고 방문한 상태
    static void dfs(int x, int y) {
        // 단지에 속한 집의 개수 증가, visit 체크
        group_cnt++;
        visit[x][y] = true;

        // 인접한 집으로 새로운 방문하기
        for (int k = 0; k < 4; k++) {
            //(x,y) -> dir[k] 더해주기
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (a[nx].charAt(ny) == '0') continue;
            if (visit[nx][ny]) continue;
            dfs(nx, ny);
        }
    }

    static void pro() {
        group = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && a[i].charAt(j) == '1') {
                    // 갈 수 있는 칸인데 집이 있는, 즉 새롭게 만난 단지인 경우
                    group_cnt = 0;
                    dfs(i, j);
                    group.add(group_cnt);
                }
            }
        }

        Collections.sort(group);
        sb.append(group.size()).append('\n');
        for (Integer integer : group) {
            sb.append(integer).append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
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
