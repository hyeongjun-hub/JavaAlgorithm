package ps_method.ga;

import java.util.Arrays;
import java.util.Comparator;

// 무게 제한이 k인 배낭에 최대 가치를 가지도록 물건을 넣는 문제
// 물건을 나눌 수 있으면 fraction
// 각 물건은 무게(w)와 가치(v)로 표현될 수 있음
public class FractionalKnapsack {
    public void knapsackFunc(Integer[][] objectList, double capacity) {
        double totalValue = 0.0;
        double fraction = 0.0;

        Arrays.sort(objectList, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o2[1] / o2[0] - o1[1] / o1[0];
            }
        });

        for (int i = 0; i < objectList.length; i++) {
            if ((capacity > (double) objectList[i][0])) {
                capacity -= (double) objectList[i][0];
                totalValue += (double) objectList[i][1];
                System.out.println("무게:" + objectList[i][0] + ", 가치:" + objectList[i][1]);
            } else {
                fraction = capacity/(double)objectList[i][0];
                totalValue += (double)objectList[i][1] * fraction;
                System.out.println("무게:" + objectList[i][0] + ", 가치:" + objectList[i][1] + ", 비율:" + fraction);
                break;
            }
        }
        System.out.println("totalValue = " + totalValue);
    }

    public static void main(String[] args) {
        FractionalKnapsack fractionalKnapsack = new FractionalKnapsack();
        Integer[][] objectList = {{10, 10}, {15, 12}, {20, 10}, {25, 8}, {30, 5}};
        fractionalKnapsack.knapsackFunc(objectList, 30.0);
    }

}
