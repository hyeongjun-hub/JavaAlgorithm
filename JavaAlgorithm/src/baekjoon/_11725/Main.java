package baekjoon._11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[] parent;
    static ArrayList<Integer>[] adj;

    public static void input() {
        FastReader fr = new FastReader();
        n = fr.nextInt();
        adj = new ArrayList[n + 1];
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            int x = fr.nextInt();
            int y = fr.nextInt();
            adj[x].add(y);
            adj[y].add(x);
        }
    }

    public static void dfs(int x, int par) {
        for (int y : adj[x]) {
            if(y == par) continue;
            parent[y] = x;
            dfs(y, x);
        }
    }

    public static void pro() {
        dfs(1, -1);

        for (int i = 2; i <= n; i++) {
            sb.append(parent[i]).append("\n");
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
