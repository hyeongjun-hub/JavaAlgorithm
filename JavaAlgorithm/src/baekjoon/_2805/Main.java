package baekjoon._2805;

/*
(Parametic Search)
나무 자르기

적어도 M 미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최대값을 구하는 프로그램을 작성하시오

나무개수 N = 100만
필요한 나무의 길이 M = 20억

1. 정답의 범위 : 0 ~ 20억
2. 잘린 나무의 길이 합 <= 나무 높이의 총합 = 100만 * 10억 = 10^15
-> 계산 과정 중의 변수 타입은 long으로 해야 함

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // N : 나무의 수
    // M : 잘라야하는 나무의 길이
    static int N, M;
    static int[] A;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        M = fr.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = fr.nextInt();
        }
    }

    // 결정 함수 O(N)
    static boolean determination(int H) {
        // H 높이로 나무들을 잘랐을 때, H 만큼을 얻을 수 있으면 true, 아니면 false
        long sum = 0;
        for (int i = 1; i <= N; i++) {
            if (A[i] > H) {
                sum += A[i] - H;
            }
        }
        return sum >= M;
    }

    static void pro() {
        long L = 0, R = 2000000000, ans = 0;
        while(L <= R){
            long mid = (L + R) / 2;
            if (determination((int) mid)) { // yessssss noooooo, 가능 하면 왼쪽으로 자름
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
