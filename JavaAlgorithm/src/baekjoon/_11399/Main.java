package baekjoon._11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
    static int[] list;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = fr.nextInt();
        }
    }

    public static void main(String[] args) {
        input();
        Arrays.sort(list);
        int answer = 0;
        for(int i=0; i<list.length; i++){
            answer += Arrays.stream(Arrays.copyOfRange(list, 0, i+1)).sum();
        }
        System.out.println(answer);
    }
}
