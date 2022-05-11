package baekjoon._1145;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

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

    static int[] nums = new int[5];

    public static void input() {
        FastReader fr = new FastReader();
        for (int i = 0; i < 5; i++) nums[i] = (fr.nextInt());
    }

    public static void main(String[] args) {
        input();
        int cnt;
        int ret = 1;
        while(true) {
            cnt=0;
            for(int i=0;i<5;i++) {
                if( ret % nums[i] == 0 ) cnt++;
            }
            if(cnt>=3) {break;}
            ret++;
        }
        System.out.println(ret);
    }
}
