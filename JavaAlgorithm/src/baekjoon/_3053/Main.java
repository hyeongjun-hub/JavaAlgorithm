package baekjoon._3053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
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

    static int R;

    public static void input() {
        FastReader fr = new FastReader();
        R = fr.nextInt();
    }

    public static void main(String[] args) {
        input();
        double euclidean = Math.PI * R * R;
        double taxicab = 2*R*R;
//        euclidean = Math.round(euclidean * 10000000) / 10000000.0;
//        DecimalFormat frmt = new DecimalFormat();
//        frmt.setMinimumFractionDigits(6);
//        System.out.println((frmt.format(euclidean)));
//        System.out.println((frmt.format(taxicab)));
        System.out.println(euclidean);
        System.out.println(taxicab);
    }
}
