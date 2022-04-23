package baekjoon._9498;

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

    static int score;

    public static void input() {
        FastReader fr = new FastReader();
        score = fr.nextInt();
    }

    public static char printResult(int score) {
        if(score >= 90) return 'A';
        else if(score >= 80) return 'B';
        else if(score >= 70) return 'C';
        else if(score >= 60) return 'D';
        else return 'F';
    }

    public static void main(String[] args) {
        input();
        System.out.println(printResult(score));
    }
}
