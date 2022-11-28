package kakao_enterprise._2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long p1, p2, p3;
    static long min, max;

    public static void main(String[] args) {
        input();
        pro();
    }

    public static void input() {
        FastReader fr = new FastReader();
        p1 = fr.nextLong();
        p2 = fr.nextLong();
        p3 = fr.nextLong();
    }

    public static void pro() {
        if (p1 + 1 == p2 && p2 + 1 == p3) {
            System.out.println(min);
            System.out.println(max);
            return;
        }
        long left = p2 - p1 - 1;
        long right = p3 - p2 - 1;
        max = Math.max(left, right);
        if(left == 1 || right == 1) min = 1;
        else min = 2;
        System.out.println(min);
        System.out.println(max);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){ br = new BufferedReader(new InputStreamReader(System.in));}

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

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        Double nextDouble() { return Double.parseDouble(next()); }

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
}
