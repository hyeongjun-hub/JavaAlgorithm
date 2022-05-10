package baekjoon._2851;

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

    static int[] mushroom = new int[10];

    public static void input() {
        FastReader fr = new FastReader();
        for (int i = 0; i < 10; i++) {
            mushroom[i] = fr.nextInt();
        }
    }

    public static void main(String[] args) {
        input();
        int num = 0;
        for (int i = 0; i < 10; i++) {
            int will = num + mushroom[i];
            if (will > 100 && (will - 100 > 100 - num)) {
                break;
            } else {
                num = will;
            }
        }
        System.out.println(num);
    }
}
