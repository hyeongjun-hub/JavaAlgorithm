package baekjoon._14681;

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

    static int x, y;

    public static void input() {
        FastReader fr = new FastReader();
        x = fr.nextInt();
        y = fr.nextInt();
    }

    public static void main(String[] args) {
        input();
        if(x>0 && y>0) System.out.println(1);
        else if(x<0 && y>0) System.out.println(2);
        else if(x<0 && y<0) System.out.println(3);
        else System.out.println(4);
    }
}
