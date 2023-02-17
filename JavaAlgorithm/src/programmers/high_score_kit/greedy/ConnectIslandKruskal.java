package programmers.high_score_kit.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class ConnectIslandKruskal {
    static int[] parent;

    public int solution(int n, int[][] costs) {
        // edge 들을 정렬
        Arrays.sort(costs, Comparator.comparingInt((int[] c) -> c[2]));
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int total = 0;
        for (int[] edge : costs) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];

            // union-find 알고리즘 사용
            int fromParent = findParent(from);
            int toParent = findParent(to);

            // 사이클을 형성하면 pass
            if(fromParent == toParent) continue;
            unionParent(fromParent, toParent);

            total += weight;
            parent[toParent] = fromParent;

        }
        return total;
    }

    private int findParent(int node) {
        if (parent[node] == node) {
            return node;
        }
        parent[node] = findParent(parent[node]);
        return parent[node];
    }

    private void unionParent(int x, int y) {
        int xParent = findParent(x);
        int yParent = findParent(y);

        if(xParent != yParent) parent[y] = xParent;
    }
}
