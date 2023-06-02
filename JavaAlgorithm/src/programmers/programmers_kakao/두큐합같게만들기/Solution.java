package programmers.programmers_kakao.두큐합같게만들기;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int solution(int[] queue1, int[] queue2) {
        Queue<Long> longQueue1 = new LinkedList<>();
        Queue<Long> longQueue2 = new LinkedList<>();
        long sum1 = 0, sum2 = 0, sum;
        for (long num1 : queue1) {
            sum1 += num1;
            longQueue1.add(num1);
        }
        for (long num2 : queue2) {
            sum2 += num2;
            longQueue2.add(num2);
        }
        sum = sum1 + sum2;
        if(sum%2==1) return -1;
        sum/=2;
        int limit = queue1.length*2;
        int r1 = 0, r2 =0;
        while (r1 <= limit && r2 <= limit) {
            if (sum1 == sum) return r1 + r2;
            if (sum1 > sum) {
                sum1 -= longQueue1.peek();
                sum2 += longQueue1.peek();
                longQueue2.add(longQueue1.poll());
                r1++;
            } else {
                sum2 -= longQueue2.peek();
                sum1 += longQueue2.peek();
                longQueue1.add(longQueue2.poll());
                r2++;
            }
        }
        return -1;
    }
}