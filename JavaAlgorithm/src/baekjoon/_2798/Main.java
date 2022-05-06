package baekjoon._2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    static int N, M, max = 0;
    static int[] cards;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        M = fr.nextInt();
        cards = new int[N];
        while(N-- > 0) {
            cards[N] = fr.nextInt();
        }
    }

    public static void combination(int index, int currentIndex, int sum) {
        if (sum <= M) {
            if (currentIndex == 3) {
                max = Math.max(sum, max);
            }
            else {
                for (int k = index; k < cards.length; k++) {
                    combination(k + 1, currentIndex + 1, sum + cards[k]);
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        combination(0,0, 0);
        System.out.println(max);
    }
}
