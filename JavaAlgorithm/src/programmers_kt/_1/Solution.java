package programmers_kt._1;

import java.util.Arrays;

public class Solution {

    public int[] solution(int[] p) {
        int [] ans = new int[p.length];

        for (int i = 0; i < p.length; i++) {
            int min_index = i;

            // 최솟값을 갖고있는 인덱스 찾기
            for(int j = i + 1; j < p.length; j++) {
                if(p[j] < p[min_index]) {
                    min_index = j;
                }
            }

            if(min_index != i){
                swap(p, min_index, i);
                ans[i]++;
                ans[min_index]++;
            }

        }
        return ans;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
