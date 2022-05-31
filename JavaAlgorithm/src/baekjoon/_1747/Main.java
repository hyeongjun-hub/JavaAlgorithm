package baekjoon._1747;

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

    static int N;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
    }

    public static boolean isPrime(int num){
        if(num == 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }

    public static boolean isPel(int num) {
        char[] numChar = Integer.toString(num).toCharArray();
        for (int i = 0; i < numChar.length/2; i++) {
            if (numChar[i] != numChar[numChar.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        input();
        while(true){
            if (isPrime(N)) {
                if (isPel(N)) {
                    System.out.println(N);
                    return;
                }
            }
            N++;
        }
    }
}
