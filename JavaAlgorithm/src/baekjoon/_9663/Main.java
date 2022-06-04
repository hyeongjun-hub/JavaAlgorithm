package baekjoon._9663;

// N Queen
// N은 최대 14
// 1. 만약 Brute Force 로 전부 Q을 놓고 검사한다면 14^14로 시간초과가 날 것임
// 먼저 그것을 코드로 구현해보고 시간초과나는지 확인
// 문제점
// 쓸 데 없는 탐색을 너무 많이 함
// 2. Back tracking 을 이용해 시간복잡도를 줄인 코드 작성

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void input() {
        N = scan.nextInt();
        col = new int[N + 1];
    }

    static int N, ans;
    static int[] col;

    static void rec_func(int row) {
        if (row == N + 1) {
            ans++;
        } else {
            for (int c = 1; c <= N; c++) {
                boolean possible = true;
                // valid 체크 (row, c)
                for (int i=1; i<= row-1; i++){
                    // (i, col[i])
                    if (attackable(row, c, i, col[i])) {
                        possible = false;
                        break;
                    }
                }
                if(possible){
                    col[row] = c;
                    rec_func(row + 1);
                    col[row] = 0;
                }
            }
        }
    }

//    private static boolean validity_check() {
//        for(int i=1; i<N; i++){
//            // 여태 갔었던 행에서 공격할 수 있는지
//            for (int j=1; j<i; j++){
//                if (attackable(i, col[i], j, col[j])) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

    private static boolean attackable(int r1, int c1, int r2, int c2) {
        if(c1 == c2) return true; // 수직
        if(r1 - c1 == r2 - c2) return true; // 왼쪽 위 대각선
        if(r1 + c1 == r2 + c2) return true; // 오른쪽 위 대각선
        return false;
    }

    public static void main(String[] args) {
        input();
        rec_func(1);
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
