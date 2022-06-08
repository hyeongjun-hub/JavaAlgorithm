package baekjoon._1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Meet implements Comparable<Meet>{
        int start, end;

        @Override
        public int compareTo(Meet o) {
            if(end == o.end) return start - o.start;
            return end - o.end;
        }

        public Meet(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static int N;
    static Meet[] meets;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        meets = new Meet[N];
        for (int i = 0; i < N; i++) {
            meets[i] = new Meet(fr.nextInt(), fr.nextInt());
        }
    }

    public static void main(String[] args) {
        input();
        Arrays.sort(meets);
        int nowEnd = 0;
        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (nowEnd <= meets[i].start) {
                answer++;
                nowEnd = meets[i].end;
            }
        }
        System.out.println(answer);
    }

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
}
