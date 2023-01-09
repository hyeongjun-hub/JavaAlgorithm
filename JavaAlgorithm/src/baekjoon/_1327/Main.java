package baekjoon._1327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, K;
    static Set<String> visit = new HashSet<>(); // visit
    static Queue<StrInt> queue;
    static String input, ans;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        K = fr.nextInt();

        input = fr.nextLine().replace(" ", "");
        char[] chars = (input.toCharArray());
        Arrays.sort(chars);
        ans = new String(chars);

        System.out.println(bfs());
    }

    private static int bfs() {
        if(input.equals(ans)) return 0;
        queue = new LinkedList<>();
        queue.add(new StrInt(input, 0));
        visit.add(input);
        while (!queue.isEmpty()) {
            StrInt poll = queue.poll();
            String str = poll.str;
            int cnt = poll.cnt;
            for (int i = 0; i <= N - K; i++) {
                String leftStr = str.substring(0, i);
                String midStr = str.substring(i, i+K);
                String rightStr = str.substring(i+K, N);
                StringBuilder sb = new StringBuilder();
                for (int j = midStr.length() - 1; j >= 0; j--) {
                    sb.append(midStr.charAt(j));
                }
                String reverseString = leftStr + sb + rightStr;

                if(visit.contains(reverseString)) continue;
                if(reverseString.equals(ans)) return cnt + 1;
                visit.add(reverseString);
                queue.offer(new StrInt(reverseString, cnt + 1));

            }
        }

        return -1;
    }

    public static void main(String[] args) {
        input();
    }

    static class StrInt {
        String str;
        int cnt;

        public StrInt(String str, int cnt) {
            this.str = str;
            this.cnt = cnt;
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
