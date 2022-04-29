package baekjoon._1085;

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

    static int x, y, w, h;

    public static void input() {
        FastReader fr = new FastReader();
        x = fr.nextInt();
        y = fr.nextInt();
        w = fr.nextInt();
        h = fr.nextInt();
    }

    public static void main(String[] args) {
        input();
        int toZero = Math.min(x, y);
        int toSide = Math.min(w-x, h-y);
        System.out.println(Math.min(toZero, toSide));
    }
}
