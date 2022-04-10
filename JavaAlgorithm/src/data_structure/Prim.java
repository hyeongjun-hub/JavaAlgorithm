package data_structure;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Prim {

    public ArrayList<Edge> primFunc(String startNode, ArrayList<Edge> edges) {
        ArrayList<String> connectedNodes = new ArrayList<>();
        ArrayList<Edge> mst = new ArrayList<>();
        ArrayList<Edge> currentEdgeList;
        ArrayList<Edge> candidateEdgeList;
        HashMap<String, ArrayList<Edge>> adjacentEdges = new HashMap<>();
        Edge currentEdge;

        for (int i = 0; i < edges.size(); i++) {
            currentEdge = edges.get(i);
            if (!adjacentEdges.containsKey(currentEdge.nodeV)) {
                adjacentEdges.put(currentEdge.nodeV, new ArrayList<Edge>());
            } if (!adjacentEdges.containsKey(currentEdge.nodeU)) {
                adjacentEdges.put(currentEdge.nodeU, new ArrayList<Edge>());
            }
        }

        for (int i = 0; i < edges.size(); i++) {
            currentEdge = edges.get(i);
            currentEdgeList = adjacentEdges.get(currentEdge.nodeV);
            currentEdgeList.add(new Edge(currentEdge.weight, currentEdge.nodeV, currentEdge.nodeU));
            currentEdgeList = adjacentEdges.get(currentEdge.nodeU);
            currentEdgeList.add(new Edge(currentEdge.weight, currentEdge.nodeV, currentEdge.nodeU));
        }

        connectedNodes.add(startNode);
        candidateEdgeList = adjacentEdges.getOrDefault(startNode, new ArrayList<Edge>());
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>();
        for (int index = 0; index < candidateEdgeList.size(); index++) {
            priorityQueue.add(candidateEdgeList.get(index));
        }

        while (priorityQueue.size() > 0) {
            Edge poppedEdge = priorityQueue.poll();
            if (!connectedNodes.contains(poppedEdge.nodeU)) {
                // 해당 edge 를 mst 에 추가
                connectedNodes.add(poppedEdge.nodeV);
                mst.add(new Edge(poppedEdge.weight, poppedEdge.nodeU, poppedEdge.nodeV));

                ArrayList<Edge> adjacentEdgeNodes = adjacentEdges.getOrDefault(poppedEdge.nodeV, new ArrayList<Edge>());
                for (int index = 0; index < adjacentEdgeNodes.size(); index++) {
                    Edge adjacentEdgeNode = adjacentEdgeNodes.get(index);
                    if(!connectedNodes.contains(adjacentEdgeNode.nodeV)) {
                        priorityQueue.add(adjacentEdgeNode);
                    }
                }
            }
        }
        return mst;

    }

    public static void main(String[] args) {
        ArrayList<Edge> myEdges = new ArrayList<>();
        myEdges.add(new Edge(7, "A", "B"));
        myEdges.add(new Edge(5, "A", "D"));
        myEdges.add(new Edge(8, "B", "C"));
        myEdges.add(new Edge(9, "B", "D"));
        myEdges.add(new Edge(7, "D", "E"));
        myEdges.add(new Edge(5, "C", "E"));
        myEdges.add(new Edge(7, "B", "E"));
        myEdges.add(new Edge(6, "D", "F"));
        myEdges.add(new Edge(8, "E", "F"));
        myEdges.add(new Edge(9, "E", "G"));
        myEdges.add(new Edge(11, "F", "G"));
    }
}
