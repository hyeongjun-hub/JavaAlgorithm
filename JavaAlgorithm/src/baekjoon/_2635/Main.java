package baekjoon._2635;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
수 이어가기
(BruteForce)

입력 30000
O(N^2) 가능
int 가능
 */

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int inputNum;
    static ArrayList<Integer>[] table;

    public static void input() {
        FastReader fr = new FastReader();
        inputNum = fr.nextInt();
        table = new ArrayList[inputNum + 1];
        for (int i = 1; i <= inputNum; i++) {
            table[i] = new ArrayList<Integer>();
        }
    }

    public static void pro() {
        int max = 0;
        int index = 0;
        for (int i = 1; i <= inputNum; i++) {
            table[i].add(inputNum);
            table[i].add(i);
            int prev1 = inputNum;
            int prev2 = i;
            while (true) {
                int temp = prev1- prev2;
                if (temp >= 0) {
                    table[i].add(temp);
                } else {
                    break;
                }
                prev1 = prev2;
                prev2 = temp;
            }
            int maxTemp = Math.max(max, table[i].size());
            if(maxTemp != max){
                max = maxTemp;
                index = i;
            }
        }
        sb.append(max).append('\n');
        for (Integer integer : table[index]) {
            sb.append(integer).append(' ');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        pro();
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
