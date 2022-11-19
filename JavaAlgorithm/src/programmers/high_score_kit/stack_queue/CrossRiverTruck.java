package programmers.high_score_kit.stack_queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
트럭 여러 대가 강을 가로지르는 일차선 다리를 정해진 순으로 건너려 합니다. 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다. 다리에는 트럭이 최대 bridge_length대 올라갈 수 있으며, 다리는 weight 이하까지의 무게를 견딜 수 있습니다. 단, 다리에 완전히 오르지 않은 트럭의 무게는 무시합니다.

예를 들어, 트럭 2대가 올라갈 수 있고 무게를 10kg까지 견디는 다리가 있습니다. 무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.

경과 시간	다리를 지난 트럭	다리를 건너는 트럭	대기 트럭
0	    []	            []	            [7,4,5,6]
1~2	    []	            [7]	            [4,5,6]
3	    [7]	            [4]         	[5,6]
4	    [7]	            [4,5]	        [6]
5	    [7,4]       	[5]	            [6]
6~7	    [7,4,5]	        [6]         	[]
8	    [7,4,5,6]   	[]	            []
따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.

Solution 함수의 매개변수로 다리에 올라갈 수 있는 트럭 수 bridge_length, 다리가 견딜 수 있는 무게 weight, 트럭 별 무게 truck_weights가 주어집니다. 이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 Solution 함수를 완성하세요.

제한 조건
bridge_length는 1 이상 10,000 이하입니다.
weight는 1 이상 10,000 이하입니다.
truck_weights의 길이는 1 이상 10,000 이하입니다.
모든 트럭의 무게는 1 이상 weight 이하입니다.
 */
public class CrossRiverTruck {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 다리 큐
        Queue<Integer> ingTrucks = new LinkedList<>();
        // 시간 초
        int answer = 0;
        // 다리 전체 하중
        int allWeight = 0;
        int index = 0;

        // 마지막 트럭이 지날 때 까지 반복
        while(index < truck_weights.length) {
            // 다리에 있는 트럭이 다리의 끝에 도달했을 때, 도착한 트럭을 빼고 무게를 뺀다.
            if (ingTrucks.size() == bridge_length) {
                allWeight -= ingTrucks.poll();
            // 다리에 트럭이 들어갈 수 없다면 다리의 길이를 유지하기 위해 큐에 0을 추가 -> 하나씩 이동
            } else if (allWeight + truck_weights[index] > weight) {
                ingTrucks.offer(0);
                answer++;
            } else {
            // 다리에 트럭이 올라가고, 무게 증가, 시간초 증가, index 변경
                ingTrucks.offer(truck_weights[index]);
                allWeight += truck_weights[index];
                answer++;
                index++;
            }
        }
        //answer은 마지막 트럭이 다리위에 올라가기까지 시간이므로 마지막트럭이 지나가는 시간 bridge_length를 더해줌
        return answer + bridge_length;

        // 처음 생각한 풀이
//         Queue<Integer> ingTrucks = new LinkedList<>();
//        for (int i = 0; i < bridge_length; i++) {
//            ingTrucks.add(0);
//        }
//        int sec = 0, sum = 0;
//        for (int truck : truck_weights) {
//            while (sum + truck - ingTrucks.peek() > weight) {
//                sum -= ingTrucks.poll();
//                ingTrucks.offer(0);
//                sec++;
//            }
//            sum = sum - ingTrucks.poll() + truck;
//            ingTrucks.offer(truck);
//            sec++;
//        }
//        return sec + bridge_length;
    }

    public static void main(String[] args) {
        CrossRiverTruck crossRiverTruck = new CrossRiverTruck();
//        int Solution = crossRiverTruck.Solution(2, 10, new int[]{7, 4, 5, 6});
        int solution = crossRiverTruck.solution(100, 100, new int[]{10});
        System.out.println("Solution = " + solution);
    }
}
