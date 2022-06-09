package baekjoon._7795;

/*
이분탐색
먹을 것인가 먹힐 것인가

N = 20,000
M = 20,000

N * M = 4억 -> integer 가능

1. B 배열 정렬 O(MlogM)
2. 모든 A의 원소마다, B 배열에 대해 이분 탐색 필요 => O(NlogM)
3. 총 시간 복잡도: O((N+M)logM)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int T, N, M;
    static int[] A, B;

    public static void input() {
        FastReader fr = new FastReader();
        T = fr.nextInt();
        for (int i = 0; i < T; i++) {
            N = fr.nextInt();
            M = fr.nextInt();
            A = new int[N];
            B = new int[M];
            for (int j = 0; j < N; j++) {
                A[j] = fr.nextInt();
            }
            for (int k = 0; k < M; k++) {
                B[k] = fr.nextInt();
            }
            pro();
        }
    }

    // B[L..R]에서 X(A[i]) 보다 작은 수 중 제일 오른 쪽 인덱스를 return하는 함수
    static int lower_bound(int[] B, int L, int R, int X) {
        int result = L - 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (X > B[mid]) {
                result = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return result + 1;
    }

    static void pro() {
        // B 배열 정렬
        Arrays.sort(B);
        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans += lower_bound(B, 0, M - 1, A[i]);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
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
