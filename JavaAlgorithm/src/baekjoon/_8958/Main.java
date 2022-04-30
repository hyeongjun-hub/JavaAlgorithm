package baekjoon._8958;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        int inputNum = fr.nextInt();
        for(int i=0; i<inputNum; i++){
            String scoreString = fr.nextLine();
            getScore(scoreString);
        }
    }

    public static void getScore(String scoreString) {
        int result = 0;
        int score = 0;
        char[] scoreList = scoreString.toCharArray();
        for (char oneChar : scoreList) {
            if(oneChar == 'X'){
                result += score;
                score = 0;
            } else {
                result += score;
                score++;
            }
        }
        if(scoreList[scoreList.length-1] == 'O'){
            result += score;
        }
        System.out.println(result);
    }
}
