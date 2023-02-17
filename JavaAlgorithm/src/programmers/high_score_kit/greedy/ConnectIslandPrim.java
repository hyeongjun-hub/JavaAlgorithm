package programmers.high_score_kit.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ConnectIslandPrim {
    static ArrayList<Edge>[] graph;

    public int solution(int n, int[][] costs) {
        // 초기화
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        // 초기화 끝

        // 그래프(인접리스트) 만들기
        for (int i = 0; i < costs.length; i++) {
            graph[costs[i][0]].add(new Edge(costs[i][1], costs[i][2]));
            graph[costs[i][1]].add(new Edge(costs[i][0], costs[i][2]));
        }

        return prim(n);
    }

    static class Edge{
        int node;
        int weight;

        public Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    private int prim(int n) {
        int total = 0;
        boolean[] visit = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));

        pq.add(new Edge(0, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if(visit[now.node]) continue;
            visit[now.node] = true;
            total += now.weight;

            for (Edge next : graph[now.node]) {
                if(visit[next.node]) continue;
                pq.add(new Edge(next.node, next.weight));
            }
        }

        return total;
    }
}
