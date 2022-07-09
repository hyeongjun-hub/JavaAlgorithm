package baekjoon._9095;

/*
1, 2, 3 더하기
(Dynamic Programming)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T, n;
    static StringBuilder sb = new StringBuilder();
    static FastReader fr = new FastReader();

    static int[] Dy;

    public static void preprocess() {
        Dy = new int[15];
        // 초기값 구하기
        Dy[1] = 1;
        Dy[2] = 2;
        Dy[3] = 3;

        // 점화식을 토대로 Dy 배열 채우기
        for (int i = 4; i <= 11; i++) {
            Dy[i] = Dy[i - 3] + Dy[i - 2] + Dy[i - 1];
        }
    }

    public static void main(String[] args) {
        T = fr.nextInt();

        preprocess();

        for (int i = 0; i < T; i++) {
            n = fr.nextInt();
            sb.append(Dy[n]).append("\n");
        }

        System.out.println(sb);
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
    }
}
