package baekjoon._5618;

/*
입력받은 수의 최대공약수를 구하고
최대공약수의 약수들을 오름차순으로 출력하면 됨

10^8 이하이므로 int가능
 */

import java.io.*;
import java.util.*;

import static java.lang.Math.sqrt;

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

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    static int repeat;
    static Stack<Integer> numArr = new Stack<>();

    public static void input() {
        FastReader fr = new FastReader();
        repeat = fr.nextInt();
        for (int i = 0; i < repeat; i++) {
            numArr.push(fr.nextInt());
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        while(numArr.size() > 1){
            numArr.push(gcd(numArr.pop(), numArr.pop()));
        }
        printAnswer(numArr.pop());
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // 약수들을 print 하는 함수(소인수분해)
    public static void printAnswer(int a) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=1; i<=sqrt(a); i++){
            if (a % i == 0) {
                numArr.add(i);
                // 제곱수일경우 중복이므로
                if (a / i != i)
                    numArr.add(a / i);
            }
        }
        numArr.sort(Comparator.naturalOrder());
        for(int resultOne: numArr){
            bw.write(resultOne + "\n");
        }
        bw.flush();
    }
}
