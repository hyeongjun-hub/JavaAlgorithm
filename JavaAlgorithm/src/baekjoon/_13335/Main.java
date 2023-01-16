package baekjoon._13335;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Queue<Integer> truck = new LinkedList<Integer>();
        st = new StringTokenizer(br.readLine());
        for(int i= 0; i< n; i++) {
            truck.offer(Integer.parseInt(st.nextToken()));
        }
        int time = 0;
        int bw=0;
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i =0; i<w ; i++) {
            q.add(0);
        }
        while(!q.isEmpty()) {
            time++;
            bw-=q.poll();
            if(!truck.isEmpty()) {
                if(truck.peek()+bw<=L) {
                    bw+=truck.peek();
                    q.offer(truck.poll());
                }else {
                    q.offer(0);
                }
            }
        }
        System.out.println(time);

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
