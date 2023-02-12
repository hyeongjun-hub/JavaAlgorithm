package programmers_spring._1;

import java.util.ArrayList;
import java.util.List;

public class Solution {




    public int solution(int[][] lotteries) {

        double max = 0;
        List<Integer> same = new ArrayList<>();

        for (int i = 0; i < lotteries.length; i++) {
            double percent = 0;

            if(lotteries[i][0] >= lotteries[i][1] + 1) percent = 1;
            else percent = (double) lotteries[i][0] / (lotteries[i][1] + 1);

            // 갱신해야한다면
            if (max < percent) {
                max = percent;
                same.clear();
                same.add(i);
            } else if (max == percent) {
                same.add(i);
            }
        }

        int maxMoney = 0;
        int maxI = 0;

        for (int j = 0; j < same.size(); j++) {
            if (maxMoney < lotteries[same.get(j)][2]) {
                maxI = same.get(j);
                maxMoney = lotteries[same.get(j)][2];
            }
        }

        return maxI + 1;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(new int[][]{{100, 100, 500}, {1000, 1000, 100}}));
    }

}
