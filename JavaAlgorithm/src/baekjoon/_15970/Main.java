package baekjoon._15970;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer>[] a;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        a = new ArrayList[N+1];
        for (int color = 1; color <= N; color++) {
            a[color] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            int coord, color;
            coord = fr.nextInt();
            color = fr.nextInt();
            // TODO: color 인 색깔의 점이 coord에 놓여있음
            a[color].add(coord);
        }
    }

    static int toLeft(int color, int idx) {
        if(idx == 0) return Integer.MAX_VALUE;
        return a[color].get(idx) - a[color].get(idx - 1);
    }

    static int toRight(int color, int idx) {
        if(idx == a[color].size() - 1) return Integer.MAX_VALUE;
        return a[color].get(idx + 1) - a[color].get(idx);
    }

    public static void pro(){
        // TODO: 색깔별로 정렬하기
        for (int color = 1; color <= N; color++) {
            Collections.sort(a[color]);
        }

        int ans = 0;
        for (int color = 1; color <= N; color++) {
            // TODO: 색깔 별로, 각 점마다 가장 가까운 점 찾아주기
            for (int i = 0; i < a[color].size(); i++) {
                int left = toLeft(color, i);
                int right = toRight(color, i);
                ans += Math.min(left, right);
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
