package baekjoon._18512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

    static int X, Y, P1, P2;

    public static void input() {
        FastReader fr = new FastReader();
        X = fr.nextInt();
        Y = fr.nextInt();
        P1 = fr.nextInt();
        P2 = fr.nextInt();
    }

    public static void main(String[] args) {
        input();
        ArrayList<Integer> visit = new ArrayList<>();
        visit.add(P1);
        visit.add(P2);
        int max = Math.max(P1, P2);
        while (Math.min(P1,P2) < X * Y + max) {
            P1 += X;
            P2 += Y;
            if (visit.contains(P1)) {
                System.out.println(P1);
                return;
            }
            if (visit.contains(P2)) {
                System.out.println(P2);
                return;
            }
            visit.add(P1);
            visit.add(P2);
        }
        System.out.println(-1);
    }
}
