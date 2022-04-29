package baekjoon._1019;

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

        long nextLong(){
            return Long.parseLong(next());
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
    static int multi = 1;
    static int[] pages = new int[10];

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
    }

    public static void main(String[] args) {
        input();
        int start = 1;
        int end = N;
        while(start<=end){
            while(start%10!=0 && start<=end){
                solve(start);
                start++;
            }

            if(start>end) break;

            while(end%10!=9 && start<=end){
                solve(end);
                end--;
            }
            start/=10;
            end/=10;

            for(int i=0; i<10; i++){
                pages[i] += (end-start+1)*multi;
            }
            multi *= 10;
        }

        for (int page: pages){
            System.out.print(page + " ");
        }
    }

    private static void solve(int s){
        while (s > 0) {
            pages[s%10]+=multi;
            s/=10;
        }
    }
}
