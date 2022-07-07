package baekjoon._1005;

/*
ACM craft
(위상 정렬)

정답 최대치
10^3 * 10^5
-> Integer


 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static FastReader fr = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] indeg, T_done, T;
    static ArrayList<Integer>[] adj;

    public static void input() {
        // Testcase가 존재하는 문제이므로 "배열 초기화"에 유의
        N = fr.nextInt();
        M = fr.nextInt();
        adj = new ArrayList[N + 1];
        indeg = new int[N + 1];
        T = new int[N + 1];
        T_done = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
            T[i] = fr.nextInt();
        }
        for (int i = 0; i < M; i++) {
            int x = fr.nextInt();
            int y = fr.nextInt();
            adj[x].add(y);
            indeg[y]++;
        }
    }

    public static void pro() {
        Deque<Integer> queue = new LinkedList<>();
        // 제일 앞에 "정렬될 수 있는" 정점 찾기
        for (int i = 1; i <= N; i++) {
            if (indeg[i] == 0) {
                queue.add(i);
                T_done[i] = T[i];
            }
        }

        // 위상 정렬 순서대로 T_done 계산을 함께 해주기
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int y : adj[x]) {
                indeg[y]--;
                if(indeg[y] == 0) queue.add(y);
                T_done[y] = Math.max(T_done[y], T_done[x] + T[y]);
            }
        }
        int W = fr.nextInt();
        System.out.println(T_done[W]);
    }

    public static void main(String[] args) {
        int Q = fr.nextInt();
        while (Q > 0) {
            Q--;
            input();
            pro();
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
