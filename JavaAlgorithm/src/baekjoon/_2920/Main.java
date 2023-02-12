package baekjoon._2920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] nums = new int[8];

    public static void input() {
        FastReader fr = new FastReader();
        for (int i = 0; i < 8; i++) {
            nums[i] = fr.nextInt();
        }
    }

    public static void main(String[] args) {
        input();
        boolean asc = true, des = true;
        for (int i = 0; i < 7; i++) {
            if(nums[i+1] != nums[i] + 1) asc = false;
            if(nums[i+1] != nums[i] - 1) des = false;
        }
        if (asc) {
            System.out.println("ascending");
        } else if (des) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
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
