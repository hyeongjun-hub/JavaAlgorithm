package programmers._68640;

public class Solution {
    public int solution(int[] a) {
        int answer = 0;

        int[] left = new int[a.length];
        int[] right = new int[a.length];
        int leftMin = a[0];
        int rightMin = a[a.length - 1];



        for (int i = 0; i < a.length; i++) {
            left[i] = Math.min(leftMin, a[i]);
            leftMin = left[i];
        }

        for (int i = a.length - 1; i >= 0; i--) {
            right[i] = Math.min(rightMin, a[i]);
            rightMin = right[i];
        }

        for (int i = 0; i < a.length; i++) {
            if(a[i] > left[i] && a[i] > right[i]) continue;
            answer++;
        }


        return answer;
    }


}
