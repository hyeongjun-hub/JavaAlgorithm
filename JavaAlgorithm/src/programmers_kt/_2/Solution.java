package programmers_kt._2;

class Solution {

    static class Member {
        int index;
        int period;
        int nextPeriod;
        int paymentSum;
        int nextSum;
    }

    public int[] solution(int[] periods, int[][] payments, int[] estimates) {
        int[] answer = new int[2];
        Member[] members = new Member[periods.length];
        for (int i = 0; i < periods.length; i++) {
            members[i] = new Member();
            members[i].index = i;
            members[i].period = periods[i];
            members[i].nextPeriod = periods[i]+1;
            int sum = 0;
            for (int j = 0; j < payments[i].length; j++) {
                sum += payments[i][j];
            }
            members[i].paymentSum = sum;
            sum -= payments[i][0];
            sum += estimates[i];
            members[i].nextSum = sum;
        }
        for (Member member : members) {
            boolean vip = false, nextVip = false;
            if(member.period >= 24 && member.period < 60 && member.paymentSum >= 900000){
                vip = true;
            }
            if(member.period >= 60 && member.paymentSum >= 600000){
                vip = true;
            }
            if(member.nextPeriod >= 24 && member.nextPeriod < 60 && member.nextSum >= 900000){
                nextVip = true;
            }
            if(member.nextPeriod >= 60 && member.nextSum >= 600000){
                nextVip = true;
            }
            if(!vip && nextVip){
                answer[0]++;
            }
            if(vip && !nextVip){
                answer[1]++;
            }
        }
        return answer;
    }
}