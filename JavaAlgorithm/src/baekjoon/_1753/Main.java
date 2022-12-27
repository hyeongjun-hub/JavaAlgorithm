package baekjoon._1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int V, E, K;
    static int[] dist;
    static ArrayList<Node>[] graph;
    static boolean[] visit;
    static int INF = Integer.MAX_VALUE;

    public static void input() {
        FastReader fr = new FastReader();
        V = fr.nextInt();
        E = fr.nextInt();
        K = fr.nextInt();
        graph = new ArrayList[V+1];
        dist = new int[V+1];
        visit = new boolean[V+1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = INF;
        }
        for (int i = 0; i < E; i++) {
            int u = fr.nextInt();
            int v = fr.nextInt();
            int w = fr.nextInt();
            graph[u].add(new Node(v, w));
        }
    }

    static class Node {
        int edge;
        int weight;

        public Node(int edge, int weight) {
            this.edge = edge;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        input();
        dijkstra(K);

        for (int i = 1; i <= V; i++) {
            System.out.println(dist[i] == INF ? "INF" : dist[i]);
        }
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        queue.add(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (!visit[now.edge]) {
                visit[now.edge] = true;
            }

            for (Node next : graph[now.edge]) {
                if (!visit[next.edge] && dist[next.edge] > now.weight + next.weight) {
                    dist[next.edge] = now.weight + next.weight;
                    queue.add(new Node(next.edge, dist[next.edge]));
                }
            }
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
