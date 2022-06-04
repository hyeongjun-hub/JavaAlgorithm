package baekjoon._14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 연산자 끼워넣기

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int N, max, min;
    static int[] nums, operators, order; // 숫자, 연산자 개수, 어떤 순서

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        nums = new int[N + 1];
        operators = new int[5];
        order = new int[N + 1];
        for (int i = 1; i <= N; i++) nums[i] = fr.nextInt();
        for (int i = 1; i <= 4; i++) operators[i] = fr.nextInt();

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        input();
        // 1 번째 원소부터 M 번째 원소를 조건에 맞게 고르는 모든 방법을 탐색해야함
        rec_func(1, nums[1]);
        sb.append(max).append('\n').append(min);
        System.out.println(sb);
    }

    public static int calculator() {
        int value = nums[1];
        // num[1] (order[i]) num[i+1]
        for (int i = 1; i <= N - 1; i++) {
            if (order[i] == 1) { // +
                value += nums[i + 1];
            } else if (order[i] == 2) { // -
                value -= nums[i + 1];
            } else if (order[i] == 3) { // *
                value *= nums[i + 1];
            } else { // /
                value /= nums[i + 1];
            }
        }
        return value;
    }

    // order[1...N-1] 에 연산자들이 순서대로 저장될 것이다.
//    public static void rec_func(int k) {
//        if (k == N) {
//            int value = calculator();
//            // 완성된 식에 맞게 계산해서 min, max 갱신하는 코드
//            max = Math.max(value, max);
//            min = Math.min(value, min);
//        } else {
//            // k번 째에 숫자를 넣는 코드
//            // 4가지 후보, 남아있는 횟수가 있어야 함
//            for (int cand = 1; cand <= 4; cand++) {
//                if (operators[cand] >= 1) { // 횟수 체크
//                    operators[cand]--;
//                    order[k] = cand;
//                    rec_func(k + 1); // rec 함수 호출
//                    operators[cand]++;
//                    order[k] = 0;
//                }
//            }
//        }
//    }

    // 재귀함수 스스로가 숫자를 갖고 있으면 식이 다 만들어졌을 때 마다 cal 함수로 계산하지 않고 갱신만 해주면 됨
    static void rec_func(int k, int value) {
        if (k == N) {
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            // k번 째에 숫자를 넣는 코드
            // 4가지 후보, 남아있는 횟수가 있어야 함
            for (int cand = 1; cand <= 4; cand++) {
                if (operators[cand] >= 1) { // 횟수 체크
                    operators[cand]--;
                    order[k] = cand;
                    rec_func(k + 1, calculator(value, cand, nums[k+1])); // rec 함수 호출
                    operators[cand]++;
                    order[k] = 0;
                }
            }
        }
    }

    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    private static int calculator(int operand1, int operator, int operand2) {
        if (operator == 1) return operand1 + operand2;
        if (operator == 2) return operand1 - operand2;
        if (operator == 3) return operand1 * operand2;
        else return operand1 / operand2;
    }

}

