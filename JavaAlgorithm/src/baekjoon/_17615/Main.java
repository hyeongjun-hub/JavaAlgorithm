package baekjoon._17615;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static String inputString;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        int r = 0, b = 0;
        inputString = fr.nextLine();
        // 볼 개수 세기
        for (int i = 0; i < N; i++) {
            if(inputString.charAt(i) == 'R') r++;
            else b++;
        }
        // 시작과 끝의 색깔과 개수 구하기
        char start = inputString.charAt(0);
        char end = inputString.charAt(N - 1);
        int startLength = 1, endLength = 1 ;
        for (int i = 1; i < N; i++) {
            if(inputString.charAt(i) != start) break;
            startLength++;
        }
        for (int i = N - 2; i > 0; i--) {
            if(inputString.charAt(i) != end) break;
            endLength++;
        }
        // 앞 뒤의 색깔이 같다면 양옆 중 더 많이 붙어있는 쪽으로 옮기는 게 나음
        if (start == end) {
            // 더 많이 붙어있는 쪽 찾기
            if (startLength >= endLength) { // 시작 쪽이 더 많을 때
                if(start == 'R') r -= startLength;
                else b -= startLength;
            } else { // 끝 쪽이 더 많을 때
                if(end == 'R') r -= endLength;
                else b -= endLength;
            }
        // 앞 뒤의 색깔이 다르다면 시작에 뭉친 개수, 끝에 뭉친 개수 각각 빼고 비교
        } else {
            // 1. 시작이 빨강이라면
            // 2. 시작이 파랑이라면 (2 중 택 1)
            if(start == 'R') r -= startLength;
            else if(start == 'B') b -= startLength;
            // 1. 끝이 빨강이라면
            // 2. 끝이 파랑이라면 (2 중 택 1)
            if(end == 'R') r -= endLength;
            else if(end == 'B') b -= endLength;
        }
        System.out.println(Math.min(r, b));
    }

    public static void main(String[] args) {
        input();
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