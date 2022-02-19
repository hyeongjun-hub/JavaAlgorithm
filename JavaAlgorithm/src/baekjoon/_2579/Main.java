package baekjoon._2579;

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

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int rangeNum = fr.nextInt();
        int[] stairs = new int[rangeNum];
        for (int i = 0; i < rangeNum; i++) {
            stairs[i] = fr.nextInt();
        }

        int[] stairsClone = stairs.clone();

        if (rangeNum>= 2){
            stairsClone[2] = stairs[1] + stairs[2];
        }

        for (int i = 1; i < rangeNum; i++) {
            if (i == 1) {
                stairsClone[i] += stairsClone[i-1];
            } else if (i == 2) {
                stairsClone[i] = stairs[i - 1] + stairs[i];
            } else {
                stairsClone[i] = Math.max(stairsClone[i - 2] + stairs[i], stairsClone[i - 3] + stairs[i - 1] + stairs[i]);
            }
        }
        System.out.println(stairsClone[rangeNum-1]);
    }

}
