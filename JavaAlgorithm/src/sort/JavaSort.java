package sort;

import java.util.Arrays;
import java.util.Comparator;

// 참고 : 정렬기준 정의하기
// 객체간의 정렬은 정렬기준이 필요함
// Comparable, Comparator 인터페이스
// Comparable : compareTo() 메소드를 override 해서 구현 (객체 implements)
// Comparator : compare() 메서드를 override 해서 구현 (가상 클래스), 우선 순위를 가짐
public class JavaSort {
//    public static void main(String[] args) {
//        Integer[] iArray = new Integer[]{1, 10, 4, 3, 2};
//        Arrays.sort(iArray);
//        System.out.println(Arrays.toString(iArray));
//    }
}

class Edge implements Comparable<Edge> {
    public Integer distance; // 가중치
    public String vertex;

    public Edge(Integer distance, String vertex) {
        this.distance = distance;
        this.vertex = vertex;
    }

    public static void main(String[] args) {
        Edge edge1 = new Edge(13, "A");
        Edge edge2 = new Edge(11, "B");
        Edge edge3 = new Edge(12, "A");
        Edge[] edges = new Edge[]{edge1, edge2, edge3};

        Arrays.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o2.distance - o1.distance; // 내림차순
            }
        });

        for (int i = 0; i < edges.length; i++) {
            System.out.println(edges[i].distance);
        }

    }

    @Override
    public int compareTo(Edge e) {
        return this.distance - e.distance; // 빼는 순서에 따라 오름/내림 결정
    }
}
