package baekjoon._10825;

/*
국영수

도현이네 반 학생 N명의 이름과 국어, 영어, 수학 점수가 주어진다. 이때, 다음과 같은 조건으로 학생의 성적을 정렬하는 프로그램을 작성하시오.

국어 점수가 감소하는 순서로
국어 점수가 같으면 영어 점수가 증가하는 순서로
국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로 (단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.)

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader fr = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static class Elem implements Comparable<Elem> {

        public String name;
        public int korean, english, math;

        @Override
        public int compareTo(Elem other) {
            // korean 내림차순
            // 음 내 먼
            if(korean != other.korean) return other.korean - this.korean;
            // english 오름차순
            if (english != other.english) return this.english - other.english;
            // math 내림차순
            if(math != other.math) return other.math - this.math;
            // String compareTo
            return name.compareTo(other.name);
        }
    }

    public static void input() {
        N = fr.nextInt();
        a = new Elem[N];
        for (int i = 0; i < N; i++) {
            a[i] = new Elem();
            a[i].name = fr.next();
            a[i].korean = fr.nextInt();
            a[i].english = fr.nextInt();
            a[i].math = fr.nextInt();

        }
    }

    static void pro() {
        // TODO
        // 기준을 통해 정렬
        Arrays.sort(a);
        // 정답 출력
        for (Elem elem : a) {
            sb.append(elem.name).append("\n");
        }
        System.out.println(sb);
    }

    static int N;
    static Elem[] a;

    public static void main(String[] args) {
        input();
        pro();
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
