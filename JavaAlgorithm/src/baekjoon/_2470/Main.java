package baekjoon._2470;

/*
(이분탐색)
두 용액

A[left]를 정했을 때, -A[left]와 가장 가까운 걸 빨리 찾자!

정렬했을 때 이득
1. 이분 탐색 사용 가능
2. 가장 가까운 원소를 빠르게 찾기 가능

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] A;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = fr.nextInt();
        }
    }

    static int lower_bound(int[] A, int L, int R, int X) {
        // A[L..R] 에서 X 이상의 수 중 제일 왼쪽(작은 값) 인덱스를 return 하는 함수
        // 그러면 찾은값 또는 찾은 값의 왼쪽 값이 X랑 가장 가깝다
        // 그런게 없다면 R + 1 을 return

        int res = R + 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (A[mid] >= X) { // X가 작으니깐 작은 구간 다시 봄
                res = mid;
                R = mid - 1;
            } else { // X가 크니깐 큰 구간 다시 봄
                L = mid + 1;
            }
        }
        return res;
    }

    static void pro() {
        Arrays.sort(A, 1, N + 1);

        int best_sum = Integer.MAX_VALUE;
        int v1 = 0, v2 = 0;
        for (int left = 1; left <= N - 1; left++) {
            // A[left] 용액을 쓸 것이다. 고로 -A[left]와 가장 가까운 용액을 자신의 오른쪽 구간에서 찾자
            int res = lower_bound(A, left + 1, N, -A[left]);

            // A[res - 1] 와 A[res] 중에 A[left]와 섞었을 때 정보를 정답에 갱신
            if (left + 1 <= res - 1 && res - 1 <= N && Math.abs(A[res - 1] + A[left]) < best_sum) {
                best_sum = Math.abs(A[res - 1] + A[left]);
                v1 = A[left];
                v2 = A[res - 1];
            }
            if (left + 1 <= res && res <= N && Math.abs(A[res] + A[left]) < best_sum) {
                best_sum = Math.abs(A[res] + A[left]);
                v1 = A[left];
                v2 = A[res];
            }
        }

        sb.append(v1).append(' ').append(v2);
        System.out.println(sb);
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
