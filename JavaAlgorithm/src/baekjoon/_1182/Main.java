package baekjoon._1182;

/*
부분 수열의 합

자료형, 시간복잡도
N <= 20
|S| <= 1000000
|A| <= 1000000

부분 집합의 개수 = 2^N <= 1048576
부분 집합의 합 상한 = 20 * 1000000
=> int 형 변수사용 가능

O(M) ~= 100만
=> 시간복잡도 가능
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S, ans;
    static int[] nums;
    // k번째 원소를 포함시킬지 정하는 함수
    // value := k - 1 번째 원소까지 골라진 원소들의 합
    static void rec_func(int k, int value) {
        if (k == N + 1) { // 부분 수열 하나 완성 시킨 상태
            // value가 S와 같은지 확인
            if (value == S) ans++;
        } else {
            // k번 째 원소를 포함시킬지 결정하고 재귀호출
            // Include
            rec_func(k + 1, value + nums[k]);
            // Not Include
            rec_func(k + 1, value);
        }
    }

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        S = fr.nextInt();
        nums = new int[N + 1];
        for (int i = 1; i <= N; i++) nums[i] = fr.nextInt();
    }

    public static void main(String[] args) {
        input();
        rec_func(1, 0);
        // ans 가 "진 부분집합"만 다루는지, 공집합을 포함하지 않는 지 확인
        if(S == 0){
            ans--;
        }
        System.out.println(ans);
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
