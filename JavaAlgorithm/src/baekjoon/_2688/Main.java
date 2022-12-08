package baekjoon._2688;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        input();
        pro();
    }

    static int N;
    static int[] arr;
    static boolean[] visit; // 무한 loop 빠지지 않도록
    static ArrayList<Integer> list = new ArrayList<>();
    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        arr = new int[N+1];
        visit = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = fr.nextInt();
        }
    }

    public static void pro() {
        for (int i = 1; i <= N; i++) {
            visit[i] = true;
            dfs(i, i);
            visit[i] = false;
        }
        Collections.sort(list);
        System.out.println(list.size());
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    private static void dfs(int start, int i) {
        if (!visit[arr[i]]) {
            visit[arr[i]] = true;
            dfs(start, arr[i]);
            visit[arr[i]] = false;
        }
        if (arr[i] == start) {
            list.add(start);
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
