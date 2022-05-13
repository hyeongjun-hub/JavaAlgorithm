package baekjoon._11170;

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

    static int N, M, answer, multi;

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        StringBuilder sb = new StringBuilder();
        int repeat = fr.nextInt();
        for (int i = 0; i < repeat; i++) {
            N = fr.nextInt();
            M = fr.nextInt();
            int start = N;
            int end = M;
            answer = 0;
            multi = 1;
            if(N == 0) {
                answer += 1;
                start++;
            }

            while (start <= end) {
                while (start % 10 != 0 && start <= end) {
                    findRest(start);
                    start++;
                }

                if(start > end) break;

                while (end % 10 != 9 && start <= end) {
                    findRest(end);
                    end--;
                }

                start/=10;
                end/=10;

                answer += (end - start + 1) * multi;

                multi *= 10;
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static void findRest(int start) {
        while (start > 0) {
            if(start % 10 == 0) answer += multi;
            start /= 10;
        }
    }
}
