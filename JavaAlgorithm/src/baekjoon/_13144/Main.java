package baekjoon._13144;

/*
List of Unique Numbers
투포인터

* 가장 쉬운 방법
1. 왼쪽 시작 L 결정 -> O(N)
2. 오른쪽 끝을 R을 L부터 시작해서 이동 -> O(N)
3. R을 이동해서 추가된 원소가 [L, R-1]에 있는지 확인 -> O(N)
=> O(N^3)

* 개선된 방법
3. R을 이동해서 추가된 원소가 [L, R-1]안에 있는지 확인을 counting
count라는 큰 배열에 개수를 넣음
-> O(1)
=> O(N^2)

* 투포인터 방법
1. 왼쪽 시작 L 결정 -> O(N)
2. 오른쪽 끝 R을 이전의 R부터 시작해서 이동
3. R을 이동해서 추가된 원소가 [L, R-1]안에 있는지 확인 -> O(1)
=> O(N)

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] A, cnt;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = fr.nextInt();
        }
        cnt = new int[100000 + 1];
    }

    static void pro() {
        long ans = 0;

        for (int L = 1, R = 0; L <= N; L++) {
            // R을 옮길 수 있는 만큼 옮긴다.
            while (R + 1 <= N && cnt[A[R + 1]] == 0) {
                R++;
                cnt[A[R]]++;
            }

            // 정답을 갱신한다
            ans += R - L + 1;

            // L을 옮겨주면서 A[L]의 개수를 감소시킨다.
            cnt[A[L]]--;

        }

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
