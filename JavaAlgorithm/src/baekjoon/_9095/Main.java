package baekjoon._9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T, n;
    static StringBuilder sb = new StringBuilder();
    static FastReader fr = new FastReader();
    static int[] nums;

    public static void main(String[] args) {
        T = fr.nextInt();
        nums = new int[11];
        nums[1] = 1;
        nums[2] = 2;
        nums[3] = 4;

        for (int i = 4; i <= 10; i++) {
            nums[i] = nums[i - 3] + nums[i - 2] + nums[i - 1];
        }

        for (int i = 0; i < T; i++) {
            n = fr.nextInt();
            sb.append(nums[n]).append("\n");
        }

        System.out.println(sb);
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
