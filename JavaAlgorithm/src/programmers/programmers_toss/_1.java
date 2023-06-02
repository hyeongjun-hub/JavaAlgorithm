package programmers.programmers_toss;

public class _1 {
    public int solution(String s) {
        int answer = -1;

        for (int i = 0; i < s.length() - 2; i++) {
            int cur = Integer.parseInt(String.valueOf(s.charAt(i)));
            if(s.charAt(i) == s.charAt(i+1) && s.charAt(i+1) == s.charAt(i+2) && cur > answer){
                answer = cur;
            }
        }
        if(answer == -1) return 0;
        else return answer * 111;
    }
}
