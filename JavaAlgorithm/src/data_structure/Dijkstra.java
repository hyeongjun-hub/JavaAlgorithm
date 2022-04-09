package data_structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;


// 거리저장배열과 우선순위 큐로 다익스트라 알고리즘 구현
// 거리저장 배열                  /  우선순위 큐
// A   B   C   D   E   F       / E B B
// inf inf inf inf inf inf     / 5 6 8

public class Dijkstra {
    public HashMap<String, Integer> dijkstraFunc(HashMap<String, ArrayList<nodeEdge>> graph, String start) {
        nodeEdge edgeNode, adjacentNode;
        ArrayList<nodeEdge> nodeList;
        int currentDistance, weight, distance;
        String currentNode, adjacent;

        // 거리저장 배열
        HashMap<String, Integer> distances = new HashMap<>();
        for (String key : graph.keySet()) {
            distances.put(key, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        // 우선 순위 큐
        PriorityQueue<nodeEdge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new nodeEdge(distances.get(start), start));

        // 알고리즘 작성
        while (priorityQueue.size() > 0) {
            edgeNode = priorityQueue.poll();
            currentDistance = edgeNode.distance;
            currentNode = edgeNode.vertex;

            if (distances.get(currentNode) < currentDistance) {
                continue;
            }

            nodeList = graph.get(currentNode);
            for (int index = 0; index < nodeList.size(); index++) {
                adjacentNode = nodeList.get(index);
                adjacent = adjacentNode.vertex;
                weight = adjacentNode.distance;
                distance = currentDistance + weight;

                if (distance < distances.get(adjacent)) {
                    distances.put(adjacent, distance);
                    priorityQueue.add(new nodeEdge(distance, adjacent));
                }
            }
        }

        // return
        return distances;
    }

    public static void main(String[] args) {
        HashMap<String, ArrayList<nodeEdge>> graph = new HashMap<>();
        graph.put("A", new ArrayList<>(Arrays.asList(new nodeEdge(8, "B"), new nodeEdge(1, "C"), new nodeEdge(2, "D"))));
        graph.put("B", new ArrayList<>());
        graph.put("C", new ArrayList<>(Arrays.asList(new nodeEdge(5, "B"), new nodeEdge(2, "D"))));
        graph.put("D", new ArrayList<>(Arrays.asList(new nodeEdge(3, "E"), new nodeEdge(5, "F"))));
        graph.put("E", new ArrayList<>(Arrays.asList(new nodeEdge(1, "F"))));
        graph.put("F", new ArrayList<>(Arrays.asList(new nodeEdge(5, "A"))));
        Dijkstra dObject = new Dijkstra();
        System.out.println(dObject.dijkstraFunc(graph, "A"));
    }


}

class nodeEdge implements Comparable<nodeEdge> {

    public int distance;
    public String vertex;

    public nodeEdge(int distance, String vertex) {
        this.distance = distance;
        this.vertex = vertex;
    }

    @Override
    public String toString(){
        return "vertex: " + this.vertex + ", distance: " + this.distance;
    }

    @Override
    public int compareTo(nodeEdge o) {
        return this.distance - o.distance;
    }
};

// 시간복잡도
// O(ElogE)


