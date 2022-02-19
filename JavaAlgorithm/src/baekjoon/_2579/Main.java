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
        int[] stairs = new int[rangeNum + 1];
        int[] stairsClone = new int[rangeNum + 1];

        for (int i = 0; i < rangeNum; i++) {
            stairs[i] = fr.nextInt();
        }

        stairsClone[0] = stairs[0];
        stairsClone[1] = stairs[1] + stairs[0];
        stairsClone[2] = Math.max(stairs[0], stairs[1]) + stairs[2];

        for (int i = 3; i < rangeNum; i++) {
            stairsClone[i] = Math.max(stairsClone[i - 2], stairsClone[i - 3] + stairs[i - 1]) + stairs[i];
        }

        System.out.println(stairsClone[rangeNum-1]);
    }
}
