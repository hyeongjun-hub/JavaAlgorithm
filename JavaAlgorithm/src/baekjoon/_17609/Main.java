package baekjoon._17609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static String inputString;

    public static void input() {
        FastReader fr = new FastReader();
        T = fr.nextInt();
        while (T-- > 0) {
            inputString = fr.nextLine();
            if (check(0, inputString.length() - 1)) {
                System.out.println(0);
            } else {
                if (reCheck(0, inputString.length() - 1)) {
                    System.out.println(1);
                } else {
                    System.out.println(2);
                }
            }
        }
    }

    private static boolean reCheck(int left, int right) {
        while (left <= right) {
            if (inputString.charAt(left) != inputString.charAt(right)) {
                boolean isLeft = check(left + 1, right);
                boolean isRight = check(left, right - 1);
                if (!isLeft && !isRight) {
                    return false;
                }
                else {
                    return true;
                }
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean check(int left, int right) {
        while (left <= right) {
            if (inputString.charAt(left) != inputString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        input();
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
