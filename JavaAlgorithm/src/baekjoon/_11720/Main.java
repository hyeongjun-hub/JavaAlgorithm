package baekjoon._11720;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
//    static class FastReader {
//        BufferedReader br;
//        StringTokenizer st;
//
//        public FastReader(){
//            br = new BufferedReader(new InputStreamReader(System.in));
//        }
//
//        String next(){
//            while(st == null || !st.hasMoreTokens()){
//                try{
//                    st = new StringTokenizer(br.readLine());
//                } catch (IOException e){
//                    e.printStackTrace();
//                }
//            }
//            return st.nextToken();
//        }
//
//        int nextInt(){
//            return Integer.parseInt(next());
//        }
//
//        long nextLong(){
//            return Long.parseLong(next());
//        }
//
//        Double nextDouble(){
//            return Double.parseDouble(next());
//        }
//
//        String nextLine(){
//            String str = "";
//            try{
//                str = br.readLine();
//            } catch(IOException e){
//                e.printStackTrace();
//            }
//            return str;
//        }
//    }
//
//    static int sum = 0;
//    static long num;
//
//    public static void input() {
//        FastReader fr = new FastReader();
//        fr.nextInt();
//        num = fr.nextLong();
//    }
//
    public static void main(String[] args) throws IOException {
//        input();
//        while(num>0){
//            sum += num%10;
//            num/=10;
//        }
//
//        System.out.println(sum);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();	// N 은 쓸모가 없으므로 입력만 받는다.

        int sum = 0;

        for(int value : br.readLine().getBytes()) {
            sum += (value - '0');	// 또는 (a-48)
        }

        System.out.print(sum);

    }
}