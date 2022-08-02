package baekjoon._16953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static long A, B;
    static int cnt;

    public static void input() {
        FastReader fr = new FastReader();
        A = fr.nextInt();
        B = fr.nextInt();
    }

    public static int bfs() {
        Queue<Long> queue = new LinkedList<>();
        queue.add(A);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Long poll = queue.poll();
                if(poll == B) return cnt+1;

                if(poll*2 <= B) queue.add(poll * 2);
                if(poll*10 + 1 <=B) queue.add(poll * 10 + 1);
            }
            cnt++;
        }
        return -1;
    }

    public static void main(String[] args) {
        input();
        System.out.println(bfs());
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
