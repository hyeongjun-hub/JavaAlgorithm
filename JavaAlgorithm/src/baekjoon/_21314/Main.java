package baekjoon._21314;

/*
민겸수
(Greedy)

    가장 큰 수의 조건
M이 K를 만날 때까지 상태를 유지하는 것이다. ( ex = MMK -> 500, MMMK->5000 )
M이 연속 될 시 1로 상태 변환한다. ( ex = MMM-> 111, MM-> 11 )
    가장 작은 수의 조건
K는 바로 5로 상태 변환한다. ( ex = MMK -> 105, KK -> 55 )
M은 연속 될 시 제곱의 형태로 변환한다. ( ex = MMMK -> 1005, MMMM-> 1000 )
위의 조건들을 만족시키는 코드를 완성하면 된다. ( 단 글자의 수가 3000개이므로 long, int로 받기는 불가능하다 String을 이용 해야한다.)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static String inputString;
    static StringBuilder sb;

    public static void input() {
        FastReader fr = new FastReader();
        inputString = fr.nextLine();
    }

    public static void findMin() {
        sb = new StringBuilder();
        int k = 0;
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == 'M') {
                k = i;
                while (k < inputString.length() && inputString.charAt(k) == 'M') {
                    k++;
                }
                sb.append(1);
                for (; i < k-1; i++) sb.append(0);
                i = k - 1;
            } else {
                sb.append(5);
            }
        }
        System.out.println(sb);
    }

    public static void findMax() {
        sb = new StringBuilder();
        int k = 0;
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == 'M') {
                k = i;
                while (k < inputString.length() && inputString.charAt(k) == 'M') {
                    k++;
                }
                if (k == inputString.length()) {
                    for (; i < k; i++) sb.append(1);
                } else {
                    sb.append(5);
                    for (; i < k; i++) sb.append(0);
                }
                i = k;
            } else {
                sb.append(5);
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        findMax();
        findMin();
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
