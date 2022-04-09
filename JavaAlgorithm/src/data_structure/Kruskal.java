package data_structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Kruskal {

    // 각 노드는 자신의 부모(root)와 높이(rank)를 알 수 있어야 함
    HashMap<String, String> parent = new HashMap<>();
    HashMap<String, Integer> rank = new HashMap<>();

    // 루트노드를 return
    public String find(String node) {
        if (parent.get(node) != node) { // 부모노드는 parent가 자기 자신
            return parent.put(node, find(parent.get(node))); // 재귀 + path compression 기법
        }
        return parent.get(node);
    }

    // 두 노드를 이음
    public void union(String nodeV, String nodeU) {
        String root1 = find(nodeV);
        String root2 = find(nodeU);

        // union-by-rank 기법
        // 높이가 다를 때는 높이가 큰 쪽에 붙임
        // 높이가 같을 때는 한 쪽의 높이를 높이고 붙임
        if (rank.get(root1) > rank.get(root2)) {
            parent.put(root2, root1);
        } else {
            parent.put(root1, root2);
            if (rank.get(root1) == rank.get(root2)) {
                rank.put(root2, rank.get(root2) + 1);
            }
        }
    }

    // 초기화 메소드
    public void makeSet(String node) {
        parent.put(node, node);
        rank.put(node, 0);
    }

    static ArrayList<String> vetices = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));
    static ArrayList<Edge> edges = new ArrayList<Edge>();

    public ArrayList<Edge> kruskalFunc(ArrayList<String> vertices, ArrayList<Edge> edges) {
        ArrayList<Edge> mst = new ArrayList<>();
        Edge currentEdge;

        // 1.초기화
        for (int i = 0; i < vertices.size(); i++) {
            makeSet(vertices.get(i));
        }

        // 2.간선 weight 기반 sorting
        Collections.sort(edges, Edge::compareTo);

        // 3.합치기
        for (int i = 0; i < edges.size(); i++) {
            currentEdge = edges.get(i);
            if (find(currentEdge.nodeU) != find(currentEdge.nodeV)) {
                union(currentEdge.nodeV, currentEdge.nodeU);
                mst.add(currentEdge);
            }
        }

        return mst;
    }

    public static void main(String[] args) {
        edges.add(new Edge(7, "A", "B"));
        edges.add(new Edge(5, "A", "D"));
        edges.add(new Edge(7, "B", "A"));
        edges.add(new Edge(8, "B", "C"));
        edges.add(new Edge(9, "B", "D"));
        edges.add(new Edge(7, "B", "E"));
        edges.add(new Edge(8, "C", "B"));
        edges.add(new Edge(5, "C", "E"));
        edges.add(new Edge(5, "D", "A"));
        edges.add(new Edge(9, "D", "B"));
        edges.add(new Edge(7, "D", "E"));
        edges.add(new Edge(6, "D", "F"));
        edges.add(new Edge(7, "E", "B"));
        edges.add(new Edge(5, "E", "C"));
        edges.add(new Edge(7, "E", "D"));
        edges.add(new Edge(8, "E", "F"));
        edges.add(new Edge(9, "E", "G"));
        edges.add(new Edge(6, "F", "D"));
        edges.add(new Edge(8, "F", "E"));
        edges.add(new Edge(11, "F", "G"));
        edges.add(new Edge(9, "G", "E"));
        edges.add(new Edge(11, "G", "F"));
        System.out.println("vetices = " + vetices);
        System.out.println("edges = " + edges);
        Kruskal kruskal = new Kruskal();
        ArrayList<Edge> mst = kruskal.kruskalFunc(vetices, Kruskal.edges);
        for (int i = 0; i < mst.size(); i++) {
            System.out.println("mst.get(i) = " + mst.get(i));
        }
    }
}

class Edge implements Comparable<Edge> {

    public int weight;
    public String nodeV;
    public String nodeU;

    public Edge(int weight, String nodeV, String nodeU) {
        this.weight = weight;
        this.nodeV = nodeV;
        this.nodeU = nodeU;
    }

    @Override
    public String toString() {
        return "nodeEdge{" +
                "weight=" + weight +
                ", nodeV='" + nodeV + '\'' +
                ", nodeU='" + nodeU + '\'' +
                '}';
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}
