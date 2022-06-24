package baekjoon._1253;

/*
좋다
(투포인터)

정답의 최대치
N = 100000
정답이 N 이하 이므로 Integer
원수 두 개의 합도 최대 10^9이므로 Integer

가장 쉬운 방법
1. 타겟 수 결정 -> O(N)
2. 다른 수 2개를 결정해서 만들어지나 확인 -> O(N^2)
=> O(N^3)

두 용액 (두 개 합해서 0)처럼 풀 것
1. 정렬 -> O(NlogN)
2. 타겟 수 결정 -> O(N)
3. 다른 수 두 개 결정 해서 만들어지나 확인 -> O(N)
=> O(N^2)

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] A;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        A = new int[N+1];
        for (int i = 1; i <= N; i++) {
            A[i] = fr.nextInt();
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    // target_idx 변째 원소가 서로다른 두 수의 합으로 표현이 되는가?
    static boolean func(int target_idx) {
        int L = 1, R = N;
        int target = A[target_idx];
        while (L < R) {
            /* TODO */
            if(L == target_idx) {
                L++;
                continue;
            }
            else if(R == target_idx) {
                R--;
                continue;
            }
//            if(target < A[L]){
//                break;
//            }
            if(A[L] + A[R] == target){
                return true;
            }
            if(A[L] + A[R] < target) L++;
            else R--;
        }
        return false;
    }

    static void pro() {
        // 최소, 최대를 빠르게 알기 위한 정렬
        /* TODO */
        Arrays.sort(A, 1, N+1);

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            // i 번째 원소가 서로 다른 두 수의 합으로 표현이 되는가?
            /* TODO */
            if(func(i)) ans++;
        }
        System.out.println(ans);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){ br = new BufferedReader(new InputStreamReader(System.in));}

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

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        Double nextDouble() { return Double.parseDouble(next()); }

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
