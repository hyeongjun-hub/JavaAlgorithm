package baekjoon._1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Z
(분할정복)

 */

public class Main {

    static long N, R, C, ans;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextLong();
        R = fr.nextLong();
        C = fr.nextLong();
        long bigLength = (long) Math.pow(2, N);
        pro(0, 0, bigLength);
    }

    public static void pro(long r, long c, long length) {

        if(length == 1){
            System.out.println(ans);
            return;
        }

        long newLength = length / 2;

        if (R < r + newLength && C < c + newLength) {
            pro(r, c, newLength);
        } else if (R < r + newLength && C >= c + newLength) {
            ans += newLength * newLength;
            pro(r, c + newLength, newLength);
        } else if (R >= r + newLength && C < c + newLength) {
            ans += newLength * newLength * 2;
            pro(r + newLength, c, newLength);
        } else {
            ans += newLength * newLength * 3;
            pro(r + newLength, c + newLength, newLength);
        }

//            for (int[] ints : map) {
//                for (int anInt : ints) {
//                    System.out.print(anInt);
//                    System.out.print(" ");
//                }
//                System.out.println();
//            }

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
