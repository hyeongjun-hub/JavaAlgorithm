package baekjoon._2908;

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

    static int A, B;

    public static void input() {
        FastReader fr = new FastReader();
        A = fr.nextInt();
        B = fr.nextInt();
    }

    public static void main(String[] args) {
        input();
        System.out.println(Math.max(changeNum(A), changeNum(B)));

//        A = Integer.parseInt(new StringBuilder().append(A).reverse().toString());
//        B = Integer.parseInt(new StringBuilder().append(B).reverse().toString());
    }

    public static int changeNum(int num) {
        int back = num / 100;
        int sip = num/10 % 10;
        int il = num % 10;
        return il * 100 + sip * 10 + back;
    }
}
