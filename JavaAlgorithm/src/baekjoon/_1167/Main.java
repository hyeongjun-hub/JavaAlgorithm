package baekjoon._1167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Edge {
        int end;
        int distance;

        public Edge(int end, int distance) {
            this.end = end;
            this.distance = distance;
        }
    }

    static class Node {
        int idx;
        int dis;

        public Node(int idx, int dis) {
            this.idx = idx;
            this.dis = dis;
        }
    }
    static int V, maxNode, ans;
    static ArrayList<Edge>[] nodes;
    static boolean[] visited;

    public static void main(String[] args) {
        input();
        bfs(1);
        bfs(maxNode);
        System.out.println(ans);
    }

    public static void input() {
        FastReader fr = new FastReader();
        V = fr.nextInt();
        nodes = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int i = 1; i <= V; i++) {
            int idx = fr.nextInt();
            while (true) {
                int vertex = fr.nextInt();
                if(vertex == -1) break;
                int distance = fr.nextInt();
                nodes[idx].add(new Edge(vertex, distance));
            }
        }
    }

    public static void bfs(int start) {
        visited = new boolean[V + 1];

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0));
        visited[start] = true;

        int max = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.dis > max) {
                max = cur.dis;
                maxNode = cur.idx;
            }

            for (Edge edge : nodes[cur.idx]) {
                if (!visited[edge.end]) {
                    visited[edge.end] = true;
                    queue.add(new Node(edge.end, cur.dis + edge.distance));
                }
            }
        }

        ans = Math.max(ans, max);
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
