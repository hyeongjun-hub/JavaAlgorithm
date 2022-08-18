package baekjoon._13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static boolean[] visit = new boolean[100001];
    static int min = Integer.MAX_VALUE;
    static int max = 100000;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        K = fr.nextInt();
        dfs(N);
    }

    public static void dfs(int cur) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(cur, 0));
        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            visit[poll.location] = true;
            if(poll.location == K) {
                min = Math.min(poll.time, min);
            }
            if (poll.location * 2 <= max && !visit[poll.location * 2]) {
                queue.add(new Point(poll.location * 2, poll.time));
//                visit[poll.location * 2] = true;
            }
            if (poll.location - 1 >= 0 && !visit[poll.location - 1]) {
                queue.add(new Point(poll.location - 1, poll.time + 1));
//                visit[poll.location - 1] = true;
            }
            if (poll.location + 1 <= max && !visit[poll.location + 1]) {
                queue.add(new Point(poll.location + 1, poll.time + 1));
//                visit[poll.location + 1] = true;
            }
        }
    }

    static class Point {
        int location;
        int time;

        public Point(int location, int time) {
            this.location = location;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        input();
        System.out.println(min);
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
