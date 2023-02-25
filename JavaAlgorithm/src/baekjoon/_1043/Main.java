package baekjoon._1043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, ans;
    static int[] parent;
    static boolean[] knowPeople;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt(); // 사람 수
        M = fr.nextInt(); // 파티 수
        parent = new int[N+1];
        knowPeople = new boolean[N+1];
        HashSet<Integer>[] parties = new HashSet[M+1]; // 각 파티에 온 사람 저장

        // 초기화
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        int know = fr.nextInt();
        // 아는 사람 저장
        for (int i = 1; i <= know; i++) {
            int cur = fr.nextInt();
            knowPeople[cur] = true;
        }

        for (int i = 1; i <= M; i++) {
            parties[i] = new HashSet<>();
            int partyNum = fr.nextInt(); // 파티오는 사람 수
            int[] party = new int[partyNum+1];
            for (int j = 1; j <= partyNum; j++) {
                party[j] = fr.nextInt();
            }
            if (partyNum <= 1) {
                parties[i].add(party[1]);
                continue;
            }
            // first와 모두 union -> first 갱신
            for (int j = 1; j < partyNum; j++) {
                int cur = party[j]; // 사람의 번호
                int fut = party[j+1];
                union(cur, fut);
                parties[i].add(cur);
                parties[i].add(fut);
            }
            // parties[i]에 모든 파티 참석자 들어있음
        }

        // 진실을 아는 사람과 같은 parent 라면 knowPeople[] 갱신
        boolean[] visit = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            if (knowPeople[i] && !visit[i]) {
                int root = find(i);
                for (int j = 1; j <= N; j++) {
                    if (find(j) == root) {
                        knowPeople[j] = true;
                        visit[j] = true;
                    }
                }
            }
        }

        for (int i = 1; i <= M; i++) {
            boolean flag = false;
            // 만약 그 파티에서 진실을 아는 사람이 하나라도 있을 경우 break;
            for (int person : parties[i]) {
                if(knowPeople[person]){ flag = true; break;}
            }
            if(!flag) ans++;
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
