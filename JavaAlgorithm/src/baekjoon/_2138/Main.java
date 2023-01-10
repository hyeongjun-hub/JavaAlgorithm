package baekjoon._2138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static String input, goal;
    static Set<String> visit;
    static Queue<StrInt> queue;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        input = fr.nextLine();
        goal = fr.nextLine();
//        for (int i = 0; i < N; i++) {
//            int cur = fr.nextInt();
//            if(cur == 0) input[i] = false;
//            else input[i] = true;
//        }
//        for (int i = 0; i < N; i++) {
//            int cur = fr.nextInt();
//            if(cur == 0) goal[i] = false;
//            else goal[i] = true;
//        }
    }

    public static void main(String[] args) {
        input();
        System.out.println(bfs());
    }

    private static int bfs() {
        queue = new LinkedList<>();
        visit = new HashSet<>();
        queue.add(new StrInt(input, 0));
        visit.add(input);
        if(input.equals(goal)) return 0;

        while (!queue.isEmpty()) {
            StrInt poll = queue.poll();
            String str = poll.str;
            int cnt = poll.cnt;

            for (int i = 0; i < N; i++) {
                String cur = null;
                char[] charArray = str.toCharArray();
                if(i==0){
                    if(charArray[0] == '0') charArray[0] = '1';
                    else charArray[0] = '0';
                    if(charArray[1] == '0') charArray[1] = '1';
                    else charArray[1] = '0';
                    cur = new String(charArray);
                }
                else if (i == N - 1 && N > 2) {
                    if(charArray[N-2] == '0') charArray[N-2] = '1';
                    else charArray[N-2] = '0';
                    if(charArray[N-1] == '0') charArray[N-1] = '1';
                    else charArray[N-1] = '0';
                    cur = new String(charArray);
                } else if (i != N - 1) {
                    if(charArray[i-1] == '0') charArray[i-1] = '1';
                    else charArray[i-1] = '0';
                    if(charArray[i+1] == '0') charArray[i+1] = '1';
                    else charArray[i+1] = '0';
                    if(charArray[i] == '0') charArray[i] = '1';
                    else charArray[i] = '0';
                    cur = new String(charArray);
                }
                if(visit.contains(cur)) continue;
                if(goal.equals(cur)) return cnt + 1;
                visit.add(cur);
                queue.add(new StrInt(cur, cnt + 1));
            }
        }

//        queue.add(new BoolInt(input, 0));
//        visit.add(input);
//        if(Arrays.equals(input, goal)) return 0;
//        while (!queue.isEmpty()) {
//            BoolInt poll = queue.poll();
//            boolean[] bulbs = poll.booleans;
//            int cnt = poll.cnt;
//            // i == 0
//            boolean[] changed = bulbs.clone();
//            changed[0] = !changed[0];
//            changed[1] = !changed[1];
//            if(visit.contains(changed)) continue;
//            if(Arrays.equals(changed, goal)) return cnt+1;
//            visit.add(changed);
//
//            for (int i = 1; i < N-1; i++) {
//                changed = bulbs.clone();
//                changed[i - 1] = !changed[i - 1];
//                changed[i] = !changed[i];
//                changed[i + 1] = !changed[i + 1];
//                if(visit.contains(changed)) continue;
//                if(Arrays.equals(changed, goal)) return cnt+1;
//                visit.add(changed);
//            }
//
//            // i == N-1
//            if (N > 2) {
//                changed = bulbs.clone();
//                changed[N - 2] = !changed[N - 2];
//                changed[N - 1] = !changed[N - 1];
//                if(visit.contains(changed)) continue;
//                if(Arrays.equals(changed, goal)) return cnt+1;
//                visit.add(changed);
//            }
//        }
        
        return -1;
    }

    public static class StrInt {
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
