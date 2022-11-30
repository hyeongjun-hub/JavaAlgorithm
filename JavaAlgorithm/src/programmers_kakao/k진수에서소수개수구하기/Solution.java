package programmers_kakao.k진수에서소수개수구하기;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;

        String numString = change(n, k);
        String[] nums = numString.split("0");

        for (String num : nums) {
            if(num.equals("")) continue;
            long intNum = Long.parseLong(num);
            if(isPrime(intNum)) answer++;
        }


        return answer;

    }

    public String change(int n, int k) {
        return Long.toString(n, k);
    }

    public boolean isPrime(long n) {
        if(n<=1) return false;
        if(n==2) return true;
        if(n%2==0) return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if(n%i==0) return false;
        }
        return true;
    }
}