package baekjoon._10430;

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

    static int A;
    static int B;
    static int C;


    public static void input() {
        FastReader fr = new FastReader();
        A = fr.nextInt();
        B = fr.nextInt();
        C = fr.nextInt();
    }

    public static void main(String[] args) {
        input();

        int result1 = (A + B)%C;
        int result2 = ((A%C) + (B%C))%C;
        int result3 = (A*B)%C;
        int result4 = ((A%C)*(B%C))%C;

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }
}
