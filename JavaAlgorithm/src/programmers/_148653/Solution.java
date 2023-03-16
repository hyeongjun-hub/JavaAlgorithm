package programmers._148653;

class Solution {
    public int solution(int storey) {
        int answer = 0;

        while (storey > 0) {
            int temp = storey % 10;
            int next = (storey / 10) % 10;

            if(temp < 5){ answer += temp;}
            else if(temp == 5) {
                answer += 5;
                storey += next >= 5 ? 10 : 0;
            }
            else{
                answer += 10 - temp;
                storey += 10;
            }
            storey /= 10;

        }

        return answer;
    }
}