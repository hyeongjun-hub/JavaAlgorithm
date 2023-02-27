package baekjoon._1043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, ans;
    static int[] parent;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        M = fr.nextInt();
        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        int know = fr.nextInt();
        int knowMan = 0;
        for (int i = 0; i < know; i++) {
            int cur = fr.nextInt();
            union(knowMan, cur);
        }
//        for (int i = 0; i < parent.length; i++) {
//            System.out.println(parent[i]);
//        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int repeat = fr.nextInt();
            int first = fr.nextInt();
            list.add(first);
            Stack<Integer> temp = new Stack<>();
            for (int j = 1; j < repeat; j++) {
                int cur = fr.nextInt();
                union(first, cur);
                temp.add(cur);
            }
            while (temp.size() >= 2) {
                union(temp.pop(), temp.peek());
            }
        }
//        for (int i = 0; i < parent.length; i++) {
//            System.out.println(parent[i]);
//        }
        for (int i = 0; i < list.size(); i++) {
            if(find(parent[list.get(i)]) != 0) ans++;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
    }

    public static void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx != fy) {
            if (fx < fy) parent[y] = fx;
            else parent[x] = fy;
        }
    }

    public static int find(int x) {
        if(parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
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
