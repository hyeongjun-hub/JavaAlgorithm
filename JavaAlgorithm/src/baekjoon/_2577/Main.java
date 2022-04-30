package baekjoon._2577;

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

    static int multipleNum = 1;
    static int[] numArr = new int[10];

    public static void input() {
        FastReader fr = new FastReader();
        multipleNum *= fr.nextInt();
        multipleNum *= fr.nextInt();
        multipleNum *= fr.nextInt();
    }

    public static void main(String[] args) {
        input();
        while(multipleNum>0){
            numArr[multipleNum%10]++;
            multipleNum/=10;
        }
        for (int num : numArr) {
            System.out.println(num);
        }
    }
}
