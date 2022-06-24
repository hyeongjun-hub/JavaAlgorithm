package baekjoon._16472;

/*
고냥이
(투 포인터)



 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, kind;
    static String A;
    static int[] cnt = new int[26]; //0~25 (a~z)

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        A = fr.nextLine();
    }

    public static void add(char x) {
        cnt[x - 'a']++;
        if (cnt[x - 'a'] == 1) kind++;
    }

    public static void erase(char x) {
        cnt[x - 'a']--;
        if (cnt[x - 'a'] == 0) kind--;
    }

    public static void pro() {
        int len = A.length();
        int ans = 0;
        for (int R = 0, L = 0; R < len; R++) {
            //R번 째 문자를 오른쪽에 추가
            add(A.charAt(R));

            // 불가능하다면, 가능할 때 까지 L을 이동
            while(kind > N) {
                erase(A.charAt(L++));
            }

            // 정답 갱신
            ans = Math.max(ans, R - L + 1);
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
