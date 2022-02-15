package baekjoon._2440;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int inputNum;

    public static void input() {
        FastReader fr = new FastReader();
        inputNum = fr.nextInt();
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
    }

    static void makeStar(int inputNum) {
        for(int i=0; i<inputNum; i++){
            for(int j=inputNum-1; j>=i; j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        input();
        makeStar(inputNum);
    }
}
