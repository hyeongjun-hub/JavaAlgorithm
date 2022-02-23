package baekjoon._11726;

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

    public static int input() {
        FastReader fr = new FastReader();
        return fr.nextInt();
    }

    public static int tiling(int inputNum) {
        int[] tiles = new int [inputNum + 1];
        if(inputNum == 1) return 1;
        tiles[1] = 1;
        tiles[2] = 2;
        for (int i = 3; i <= inputNum; i++) {
            tiles[i] = tiles[i - 1] + tiles[i - 2];
        }
        return tiles[inputNum];
    }

    public static void main(String[] args) {
        int inputNum = input();
        int result = tiling(inputNum) % 10007;
        System.out.println(result);
    }
}
