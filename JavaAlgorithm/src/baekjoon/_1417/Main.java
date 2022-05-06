package baekjoon._1417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

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

        int nextInt(){
            return Integer.parseInt(next());
        }

        Double nextDouble(){
            return Double.parseDouble(next());
        }

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

    public static void main(String[] args) {
        PriorityQueue<Integer> votes = new PriorityQueue<>(Collections.reverseOrder());
        int count = 0;
        FastReader fr = new FastReader();
        int repeat = fr.nextInt();
        int myNum = fr.nextInt();
        for (int i = 1; i < repeat; i++) {
            votes.offer(fr.nextInt());
        }
        while (votes.size() > 0 && votes.peek() >= myNum) {
            votes.offer(votes.poll() - 1);
            myNum += 1;
            count++;
        }
        System.out.println(count);
    }
}
