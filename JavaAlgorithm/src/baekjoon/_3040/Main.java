package baekjoon._3040;

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

    static int[] inputArray = new int[10];
    static int sumAll = 0;

    public static void input() {
        FastReader fr = new FastReader();
        for (int i = 0; i < 9; i++) {
            int inputNum = fr.nextInt();
            inputArray[i] = inputNum;
            sumAll += inputNum;
        }
    }

    public static void main(String[] args) {
        input();
        int i = 0;
        int j = 1;
        outerLoop:
        for (; i < 9; i++) {
            for (j = i + 1; j < 9; j++) {
                if (sumAll - inputArray[i] - inputArray[j] == 100) {
                    break outerLoop;
                }
            }
        }
        for(int k = 0; k < 9; k++){
            if(k == i || k == j){
                continue;
            }
            System.out.println(inputArray[k]);
        }


    }
}
