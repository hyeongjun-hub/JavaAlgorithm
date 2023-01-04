package baekjoon._19942;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N, min = Integer.MAX_VALUE;
    static int[][] nut;
    static int[] minNut, have, isSelected;
    static ArrayList<String> ansIndex = new ArrayList<>();
    static StringBuilder sb;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        nut = new int[N + 1][5];
        minNut = new int[4];
        isSelected = new int[N + 1];
        for (int i = 0; i < 4; i++) {
            minNut[i] = fr.nextInt();
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 5; j++) {
                nut[i][j] = fr.nextInt();
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    public static void pro() {
        //한 개부터 N 개 선택하는 조합구하기
        for (int i = 1; i <= N; i++) {
            backTracking(0, i, 1);
        }
        if(min == Integer.MAX_VALUE) System.out.println(-1);
        else{
            Collections.sort(ansIndex);
            System.out.println(min);
            System.out.println(ansIndex.get(0));
        }
    }

    private static void backTracking(int cnt, int end, int cur) {
        // 모두 채워지면
        if(cnt == end){
            // 조건 맞는지 확인
            check(end);
            return;
        }
        // 아니라면 backtracking
        for (int i = cur; i <= N; i++) {
            isSelected[cnt] = i;
            backTracking(cnt + 1, end, cur + 1);
        }
    }

    private static void check(int end) {
        int[] have = new int[4];
        int price = 0;

        // 더해주기
        for (int i = 0; i < end; i++) {
            for (int j = 0; j < 4; j++) {
                have[j] = nut[isSelected[i]][j];
            }
            price += nut[isSelected[i]][4];
        }

        // 조건맞는지 확인
        for (int i = 0; i < 4; i++) {
            if(minNut[i] > have[i]) return;

            // 갱신할지
            if (price < min) {
                ansIndex.clear();
                sb = new StringBuilder();
                for (int j = 0; j < end; j++) {
                    sb.append(isSelected[j] + " ");
                }
                ansIndex.add(sb.toString());
                min = price;
            }
        }
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
