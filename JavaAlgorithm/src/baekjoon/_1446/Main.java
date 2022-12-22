package baekjoon._1446;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, D;
    static List<int[]>[] list;
    static int[] dp = new int[10001];

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        D = fr.nextInt();
        list = new ArrayList[10001];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            int start = fr.nextInt();
            int end = fr.nextInt();
            int dis = fr.nextInt();
            list[start].add(new int[]{end, dis});
        }
    }

    public static void pro() {
        // 초기화
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i;
        }
        for (int i = 0; i < dp.length; i++) {
            // 지름길로 갔을 때 다음 index 도 변경
            if (i != 0) {
                dp[i] = Math.min(dp[i - 1] + 1, dp[i]);
            }
            // 시작점에 지름길이 있으면 갱신
            if (list[i].size() > 0) {
                for (int tmp[] : list[i]) {
                    int end = tmp[0];
                    int dis = tmp[1];
                    if(dp[end] > dp[i] + dis) dp[end] = dp[i] + dis;
                }
            }
        }
        System.out.println(dp[D]);
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
