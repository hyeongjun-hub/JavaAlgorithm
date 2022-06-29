package baekjoon._16439;

/*
치킨치킨치킨
(Brute Force)

정답 최대값 90

1. 치킨 3종류 뽑기 O(NC3) ~= 4200 (종류를 뽑기 때문에 조합)
2. 각 사람당 (N) 3개 중 높은 선호도 뽑기 -> N*3 = 90
=> 42000
3. 정답 갱신

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, ans = 0;
    static int[][] chicken;
    static int[] select = new int[3]; // 세 종류


    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        M = fr.nextInt();
        chicken = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                chicken[i][j] = fr.nextInt();
            }
        }
    }

    private static void makeComb(int cnt, int start) {
        // 세 개 다 뽑았을 때
        if(cnt == 3){
            int sum = 0;
            for (int i = 0; i < N; i++) { // 몇 명
                sum += getMax(i);
            }
            if(sum > ans) ans = sum;
            return;
        }
        for (int i = start; i < M; i++) {
            select[cnt] = i;
            makeComb(cnt + 1, i + 1);
            select[cnt] = 0;
        }
    }

    // 고른 세 개 중 최대값 구하는 함수
    private static int getMax(int idx) {
        int max = 0;
        for (int i = 0; i < 3; i++) {
            int temp = chicken[idx][select[i]];
            if(temp > max) max = temp;
        }
        return max;
    }

    public static void pro() {
        // 3개의 치킨을 고르고 선호도 합 구하기
        makeComb(0, 0);
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
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
