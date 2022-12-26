package baekjoon._17089;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static boolean[][] friend;
    static int[] nums;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        M = fr.nextInt();
        friend = new boolean[N+1][N+1];
        nums = new int[N + 1];
        for (int i = 0; i < M; i++) {
            int A = fr.nextInt();
            int B = fr.nextInt();
            friend[A][B] = true;
            friend[B][A] = true;
            nums[A]++;
            nums[B]++;
        }
    }

    public static void pro() {
        int ans = Integer.MAX_VALUE;

        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= N; j++) {
                if(!friend[i][j]|| !friend[j][i]) continue;
                if(i==j)continue;
                for (int k = 1; k <= N; k++) {
                    if(!friend[i][k] || !friend[j][k] || !friend[k][j] || !friend[k][i]) continue;
                    if(i == k || j == k) continue;
                    int cnt = 0;
                    cnt += nums[i] - 2;
                    cnt += nums[j] - 2;
                    cnt += nums[k] - 2;
                    ans = Math.min(cnt, ans);
                }
            }
        }

        if(ans == Integer.MAX_VALUE) ans = -1;
        System.out.println(ans);
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
