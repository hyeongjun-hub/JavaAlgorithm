package baekjoon._2231;

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

    static int N;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
    }

    public static void main(String[] args) {
        input();
        int temp = N;
        int position = 0;
        while (temp > 0) {
            position++;
            temp/=10;
        }
        int rangeStart = N -  9 * position;
        while(rangeStart < N){
            int sum = rangeStart;
            int rangeTemp = rangeStart;
            while (rangeTemp > 0) {
                sum += rangeTemp % 10;
                rangeTemp /= 10;
            }
            if(sum == N){
                System.out.println(rangeStart);
                return;
            }
            rangeStart++;
        }
        System.out.println(0);
    }
}
