package baekjoon._2606;

/*
바이러스
(Graph Traverse)

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, E, answer = 0;
    static ArrayList<Integer>[] graph;
    static boolean[] visit;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        E = fr.nextInt();
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            int x = fr.nextInt();
            int y = fr.nextInt();
            graph[x].add(y);
            graph[y].add(x);
        }
        visit = new boolean[N + 1];
    }

    public static void dfs(int x) {
        visit[x] = true;
        answer++;

        for(int y: graph[x]){
            if(visit[y]) continue;
            dfs(y);
        }
    }

    public static void pro() {
        dfs(1);
        System.out.println(answer - 1);
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
