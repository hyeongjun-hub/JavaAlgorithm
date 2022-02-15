package baekjoon._2445;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int input() {
        FastReader fr = new FastReader();
        int inputNum = fr.nextInt();
        return inputNum;
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
    }

    public static void main(String[] args) {
        int inputNum = input();

        String[] map = new String[inputNum*2 - 1];
        map[0] = "*";

        for(int i=1; i<inputNum; i++){
            map[i] = map[i-1] + "*";
        }

        //공백 채우기 + 좌우 대칭
        String blank = "";
        while(blank.length() < inputNum * 2 - 2){
            blank += "  ";
        }
        for(int i=0; i<inputNum; i++){
            map[i] += blank.substring(i*2) + map[i];
        }

        //상하 대칭
        for(int i=1; i<inputNum; i++){
            map[inputNum*2 - 1 - i] = map[i - 1];
        }

        // 출력
        for (int i = 0; i < map.length; i++) {
            System.out.println(map[i]);
        }

    }
}
