package baekjoon._1068;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int n, root, erased;
    static ArrayList<Integer>[] child; // index가 가진 자식 노드들
    static int[] leaf; // index를 root로 하는 leaf노드의 개수

    public static void input() {
        FastReader fr = new FastReader();
        n = fr.nextInt();
        child = new ArrayList[n];
        leaf = new int[n];
        for (int i = 0; i < n; i++) {
            child[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int par = fr.nextInt();
            if(par == -1) root = i;
            else child[par].add(i);
        }
        erased = fr.nextInt();
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    public static void dfs(int x) {
        if (child[x].isEmpty()) {
            leaf[x] = 1;
        } else {
            for (int y : child[x]) {
                dfs(y);
                leaf[x] += leaf[y];
            }
        }
    }

    public static void pro() {
        // erase된 노드 지우기
        for (int i = 0; i < n; i++) {
            if (child[i].contains(erased)) {
                child[i].remove(child[i].indexOf(erased));
            }
        }
        if (root != erased) {
            dfs(root);
        }
        System.out.println(leaf[root]);

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
