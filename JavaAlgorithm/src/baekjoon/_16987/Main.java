package baekjoon._16987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, answer;
    static int[] weight, health;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        health = new int[N];
        weight = new int[N];
        for (int i = 0; i < N; i++) {
            health[i] = fr.nextInt();
            weight[i] = fr.nextInt();
        }
        pro(0);
    }

    public static void pro(int cnt) {
        if (cnt == N) {
            int now = 0;
            for (int i : health) {
                if(i <= 0) now++;
            }
            answer = Math.max(answer, now);
            return;
        }

        // 손에 든 계란 내구도 확인
        if(health[cnt] <= 0){
            pro(cnt + 1);
            return;
        }

        // 계란 치기
        int temp = 0;
        for (int i = 0; i < N; i++) {
            // 자신 제외
            if(i == cnt) continue;

            // 칠 수 있는 계란 확인
            if (health[i] <= 0) {
                temp++;
                // 나머지를 전부 때릴 수 없을 때
                if(temp == N - 1) {
                    pro(cnt + 1);
                    return;
                }
                continue;
            }

            // 내구도 - 무게
            health[cnt] -= weight[i];
            health[i] -= weight[cnt];

            pro(cnt + 1);

            // 내구도 + 무게
            health[cnt] += weight[i];
            health[i] += weight[cnt];
        }

    }

    public static void main(String[] args) {
        input();
        System.out.println(answer);
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
