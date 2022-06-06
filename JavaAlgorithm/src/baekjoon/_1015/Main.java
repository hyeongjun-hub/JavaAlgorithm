package baekjoon._1015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
수열 정렬

문제
P[0], P[1], ...., P[N-1]은 0부터 N-1까지(포함)의 수를 한 번씩 포함하고 있는 수열이다. 수열 P를 길이가 N인 배열 A에 적용하면 길이가 N인 배열 B가 된다. 적용하는 방법은 B[P[i]] = A[i]이다.

배열 A가 주어졌을 때, 수열 P를 적용한 결과가 비내림차순이 되는 수열을 찾는 프로그램을 작성하시오. 비내림차순이란, 각각의 원소가 바로 앞에 있는 원소보다 크거나 같을 경우를 말한다. 만약 그러한 수열이 여러개라면 사전순으로 앞서는 것을 출력한다.

 */
public class Main {

    static StringBuilder sb = new StringBuilder();

    static class Elem implements Comparable<Elem> {

        int num, idx;

        @Override
        public int compareTo(Elem o) {
            // TODO
            // 정렬 조건에 맞게 정렬하기
            // 1. num의 비내림차순
            // 2. num이 같으면 index 오름차순
//            if(num != o.num)
            return num - o.num;
            // Tim sort는 stable 하므로 2번 조건은 빼도 됨
        }
    }

    static int N;
    static int[] P;
    static Elem[] B;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        B = new Elem[N];
        P = new int[N];
        for (int i = 0; i < N; i++) {
            B[i] = new Elem();
            B[i].num = fr.nextInt();
            B[i].idx = i;
        }
    }

    public static void main(String[] args) {
        input();

        // TODO : B 배열 정렬하기
        Arrays.sort(B);

        // TODO: B 배열의 값을 이용하여 P 배열 채우기
        for (int b_idx = 0; b_idx < N; b_idx++) {
            P[B[b_idx].idx] = b_idx;
        }

        // TODO : P 배열 출력하기
        for (int i : P) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
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
