package baekjoon._1240;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Node>[] graph;
    static boolean[] visit;
    static int[] dist;
    static int INF = Integer.MAX_VALUE;
    static StringBuilder sb = new StringBuilder();

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        M = fr.nextInt();
        graph = new ArrayList[N+1];
        // 초기화
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        // 초기화 끝
        for (int i = 0; i < N-1; i++) {
            int n = fr.nextInt(); // start
            int m = fr.nextInt(); // end
            int k = fr.nextInt(); // weight
            graph[n].add(new Node(m, k));
            graph[m].add(new Node(n, k));
        }
        for (int i = 0; i < M; i++) {
            int start = fr.nextInt();
            int end = fr.nextInt();
            sb.append(dijkstra(start, end));
            sb.append("\n");
        }
    }

    public static void main(String[] args) {
        input();
        System.out.println(sb);
    }

public static int dijkstra(int start, int end) {
    dist = new int[N+1];
    for (int i = 1; i <= N; i++) {
        dist[i] = INF;
    }
    visit = new boolean[N+1];

    PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
    pq.add(new Node(start, 0));
    dist[start] = 0;
    visit[start] = true;

    while (!pq.isEmpty()) {
        Node curNode = pq.poll();

        // node 순회
        for (Node next : graph[curNode.edge]) {
            if(visit[next.edge]) continue;
            if(dist[next.edge] < next.weight + curNode.weight) continue;
            dist[next.edge] = next.weight + curNode.weight;
            pq.add(new Node(next.edge, dist[next.edge]));
            visit[next.edge] = true;
        }
    }

    return dist[end];
}

static class Node{
    int edge;
    int weight;

    public Node(int edge, int weight) {
        this.edge = edge;
        this.weight = weight;
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
