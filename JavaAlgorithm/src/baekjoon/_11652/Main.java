package baekjoon._11652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
카드

2^62 -> long써야함

* 가장 쉬운 방법 O(N^2)
이중 for문으로 다 돌기
100000 * 100000 = 100억 -> 시간초과 예상가능

* 같은 숫자를 빨리 보는 방법 O(NlogN)
같은 정보들은 인접해 있을 것이라는 특성을 이용
앞의 숫자와 같으면 계속이구나
앞의 숫자와 다르면 처음이구나

Current Count : 지금 보고 있는 숫자가 등장한 횟수
Mode Count : 지금까지의 최빈값의 등장 횟수
Mode  : 지금까지의 최빈값

 */
public class Main {
    static StringBuilder sb = new StringBuilder();

    static int N;
    static long[] a;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        a = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            a[i] = fr.nextLong();
        }
    }

    public static void pro() {
        // Sort 정렬
        Arrays.sort(a, 1, N+1);

        // mode: 최빈값, modeCnt: 최빈값의 등장 횟수, curCnt: 현재값(a[i])의 등장횟수
        long mode = a[1];
        int modeCnt = 1, curCnt = 1;

        // TODO
        // 2번 원소부터 차례대로 보면서, 같은 숫자가 이어서 나오고 있는 지, 새로운 숫자가 나왔는 지를 판단하여
        // curCnt를 갱신해주고, 최빈값을 갱신하는 작업
        for (int i = 2; i <= N; i++) {
            if (a[i - 1] == a[i]) {
                curCnt++;
            } else {
                curCnt = 1;
            }
            if (modeCnt < curCnt) {
                modeCnt = curCnt;
                mode = a[i];
            }
        }

        // 정답 출력
        System.out.println(mode);
    }

    public static void main(String[] args) {
        input();
        pro();
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

        long nextLong(){
            return Long.parseLong(next());
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
