package baekjoon._2579;

/*
계단오르기
(Dynamic Programming)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] A;
    static int[][] Dy;

    public static void input() {
        FastReader fr = new FastReader();

        N = fr.nextInt();
        A = new int[N + 1];
        Dy = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            A[i] = fr.nextInt();
        }
    }

    public static void pro() {
        // 초기값 구하기
        Dy[1][0] = 0;
        Dy[1][1] = A[1];

        if (N >= 2) {
            Dy[2][0] = A[2];
            Dy[2][1] = A[1] + A[2];
        }

        // 점화식을 토대로 Dy배열 채우기

        for (int i = 3; i <= N; i++) {
            Dy[i][0] = Math.max(Dy[i - 2][0] + A[i], Dy[i - 2][1] + A[i]);
            Dy[i][1] = Dy[i - 1][0] + A[i];
        }

        // Dy배열로 정답 계산
        int ans = Math.max(Dy[N][0], Dy[N][1]);

        System.out.println(ans);
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

//    public static void main(String[] args) {
//        FastReader fr = new FastReader();
//        int rangeNum = fr.nextInt();
//        int[] stairs = new int[rangeNum + 1];
//        int[] stairsClone = new int[rangeNum + 1];
//
//        for (int i = 0; i < rangeNum; i++) {
//            stairs[i] = fr.nextInt();
//        }
//
//        stairsClone[0] = stairs[0];
//        stairsClone[1] = stairs[1] + stairs[0];
//        stairsClone[2] = Math.max(stairs[0], stairs[1]) + stairs[2];
//
//        for (int i = 3; i < rangeNum; i++) {
//            stairsClone[i] = Math.max(stairsClone[i - 2], stairsClone[i - 3] + stairs[i - 1]) + stairs[i];
//        }
//
//        System.out.println(stairsClone[rangeNum-1]);
//    }
}
