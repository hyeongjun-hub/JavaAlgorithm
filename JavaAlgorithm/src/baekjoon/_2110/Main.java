package baekjoon._2110;

/*
(Parametic Search)
공유기 설치

집의 개수 N = 20만
공유기의 개수 C = 20만
좌표 xi <= 10억

제일 멀리 설치해보면 10억 이하 -> Integer

원래 문제: C개의 공유기를 설치했을 때, 최대 인접거리는 얼마인가?
뒤집은 문제: 어떤 거리만큼 거리를 둘 때, 공유기 C개를 설치할 수 있는가?

1. 주어진 집들을 정렬 -> O(NlogN)
2. D를 정해서 겨렁 문제 한 번 풀기 -> O(N)
3. 정답의 범위를 이분 탐색하면서 풀기 -> O(logX)번 반복할 것
4. 총 시간 복잡도: O(NlogN + NlogX)

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, C;
    static int[] A;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        C = fr.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = fr.nextInt();
        }
    }

    static boolean determination(int D) {
        // D 만큼의 거리차이를 둔다면 C개 만큼의 공유기를 설치할 수 있는가?
        // 제일 왼쪽 집부터 가능한 많이 설치해보자
        // D만큼 거리를 두면서 최대로 설치한 개수와 C를 비교
        int cnt = 1, last = A[1];
        for (int i = 2; i <= N; i++) {
            // 이번에 A[i]에 설치가 가능한가?
            if(A[i] - last >= D){
                cnt++;
                last = A[i];
            }
        }
        return cnt >= C;
    }

    static void pro(){
        // determination 하기 위해 정렬
        Arrays.sort(A, 1, N + 1);

        int L = 1, R = 1000000000, ans = 0;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (determination(mid)) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
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
