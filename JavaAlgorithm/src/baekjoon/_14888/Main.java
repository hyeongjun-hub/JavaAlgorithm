package baekjoon._14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int N, max, min;
    static int[] nums, operators, order;

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
        rec_func(1);
        sb.append(max).append('\n').append(min);
        System.out.println(sb);
    }

    public static int calculator(){
        int value = nums[1];
        for (int i = 1; i <= N - 1; i++) {
            if (order[i] == 1) {
                value += nums[i + 1];
            }else if (order[i] == 2) {
                value -= nums[i + 1];
            }else if (order[i] == 3) {
                value *= nums[i + 1];
            }else {
                value /= nums[i + 1];
            }
        }
        return value;
    }

    public static void rec_func(int k) {
        if (k == N) {
            // 계산해서 min, max 갱신하는 코드
            int value = calculator();
            max = Math.max(value, max);
            min = Math.min(value, min);
        } else {
            // k번 째에 숫자를 넣는 코드
            for (int cand = 1; cand <= 4; cand++) {
                if (operators[cand] >= 1) {
                    operators[cand]--;
                    order[k] = cand;
                    rec_func(k + 1);
                    operators[cand]++;
                    order[k] = 0;
                }
            }
        }

    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while(st == null || !st.hasMoreTokens()){
                try{
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }

        Double nextDouble(){
            return Double.parseDouble(next());
        }

        String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            } catch(IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
}
