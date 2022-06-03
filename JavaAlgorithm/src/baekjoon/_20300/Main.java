package baekjoon._20300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
    static long[] nums;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        nums = new long[N];
        for (int i = 0; i < N; i++) {
            nums[i] = fr.nextLong();
        }
    }

    public static void main(String[] args) {
        input();
        Arrays.sort(nums);
        long sum = nums[N - 1];
        if(N % 2 == 0){
            for(int i = 0; i < N / 2; i++){
                long value = nums[i] + nums[N - 1 - i];
                if(sum < value) sum = value;
            }
        }
        else{
            for(int i = 0; i < N / 2; i++){
                long value = nums[i] + nums[N - 2 - i];
                if(sum < value) sum = value;
            }
        }
        System.out.println(sum);
    }
}
