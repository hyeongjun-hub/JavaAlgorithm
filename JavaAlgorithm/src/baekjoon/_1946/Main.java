package baekjoon._1946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static int T, N;
    static StringBuilder sb = new StringBuilder();

    public static void input() {
        FastReader fr = new FastReader();
        T = fr.nextInt();
        for (int i = 0; i < T; i++) {
            int ans = 0;
            N = fr.nextInt();
            ArrayList<Student> students = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                Student stu = new Student(fr.nextInt(), fr.nextInt());
                students.add(stu);
            }
            students.sort(Comparator.comparingInt(o -> o.first));
            // 서류
            int min = N+1;
            for (Student student : students) {
                if (min > student.second) {
                    // 최소값 갱신
                    min = student.second;
                    ans++;
                }
            }
            sb.append(ans);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
    }

    static class Student {
        int first, second;

        public Student(int first, int second) {
            this.first = first;
            this.second = second;
        }
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
