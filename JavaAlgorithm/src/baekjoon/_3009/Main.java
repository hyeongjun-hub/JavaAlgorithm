package baekjoon._3009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
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

    static HashMap<Integer, Integer> x = new HashMap<>();
    static HashMap<Integer, Integer> y = new HashMap<>();

    public static void input() {
        FastReader fr = new FastReader();
        for (int i = 0; i < 3; i++) {
            int inputNum = fr.nextInt();
            x.put(inputNum, x.getOrDefault(inputNum, 0) + 1);
            inputNum = fr.nextInt();
            y.put(inputNum, y.getOrDefault(inputNum, 0) + 1);
        }
    }

    public static void main(String[] args) {
        input();
        int xValue = 0, yValue = 0;
        for (Entry<Integer, Integer> entry : x.entrySet()) {
            if(entry.getValue() % 2 == 1){
                xValue = entry.getKey();
                break;
            }
        }
        for (Entry<Integer, Integer> entry : y.entrySet()) {
            if(entry.getValue() % 2 == 1){
                yValue = entry.getKey();
                break;
            }
        }
        System.out.println(xValue + " " + yValue);
    }
}
