package baekjoon._11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] nums;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        K = fr.nextInt();
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = fr.nextInt();
        }
    }

    public static void main(String[] args) {
        input();
        int answer = 0;
        while (K != 0) {
            for (int i = N-1; i >= 0; i--) {
                if(nums[i] <= K){
                    K -= nums[i];
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);

    }


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
}
