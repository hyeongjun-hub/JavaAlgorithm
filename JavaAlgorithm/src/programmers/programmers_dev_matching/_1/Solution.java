package programmers.programmers_dev_matching._1;

class Solution {
    public int solution(int[] grade) {
        int answer = 0;
        int min = grade[grade.length-1];

        for (int i = grade.length - 2; i >= 0; i--) {
            if(grade[i] <= min) min = grade[i];
            else {
                answer += grade[i] - min;
            }
        }

        return answer;
    }
}
