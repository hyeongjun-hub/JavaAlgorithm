package data_structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DFS {
    public ArrayList<String> dfsFunc(HashMap<String, ArrayList<String>> graph, String startNode) {
        ArrayList<String> visited = new ArrayList<>();
        ArrayList<String> needVisit = new ArrayList<>();

        needVisit.add(startNode);

        while (needVisit.size() > 0) {
            String node = needVisit.remove(needVisit.size() - 1);
            if (!visited.contains(node)) {
                visited.add(node);
                needVisit.addAll(graph.get(node));
            }
        }

        return visited;
    }

    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();

        hashMap.put("A", new ArrayList<>(Arrays.asList("B", "C")));
        hashMap.put("B", new ArrayList<>(Arrays.asList("A", "D")));
        hashMap.put("C", new ArrayList<>(Arrays.asList("A", "G", "H", "I")));
        hashMap.put("D", new ArrayList<>(Arrays.asList("B", "E", "F")));
        hashMap.put("E", new ArrayList<>(Arrays.asList("D")));
        hashMap.put("F", new ArrayList<>(Arrays.asList("D")));
        hashMap.put("G", new ArrayList<>(Arrays.asList("C")));
        hashMap.put("H", new ArrayList<>(Arrays.asList("C")));
        hashMap.put("I", new ArrayList<>(Arrays.asList("C", "J")));
        hashMap.put("J", new ArrayList<>(Arrays.asList("I")));

        DFS bObject = new DFS();
        System.out.println(bObject.dfsFunc(hashMap, "A"));
    }
}
