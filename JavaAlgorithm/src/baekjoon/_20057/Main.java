package baekjoon._20057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, ans;
    static int[][] A;
    static int[][] left = {{0,0, 2,0,0}, {0, 10, 7, 1, 0}, {5, 0, 0, 0, 0}, {0, 10, 7, 1, 0}, {0, 0, 2, 0, 0}};
    static int[][] down = {{0, 0, 0, 0, 0}, {0, 1, 0, 1, 0}, {2, 7, 0, 7, 2}, {0, 10, 0, 10, 0}, {0, 0, 5, 0, 0}};
    static int[][] right = {{0, 0, 2, 0, 0,}, {0, 1, 7, 10, 0}, {0, 0, 0, 0, 5}, {0, 1, 7, 10, 0}, {0, 0, 2, 0, 0}};
    static int[][] up = {{0, 0, 5, 0, 0,}, {0, 10, 0, 10, 0}, {2, 7, 0, 7, 2}, {0, 1, 0, 1, 0}, {0, 0, 0, 0, 0}};

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = fr.nextInt();
            }
        }

        int tr = N/2;
        int tc = N/2;
        int distance = 1;

        point:
        while (distance < N+1) {
            // 왼
            int cur = 1;
            while (distance >= cur) {
                tc--;
                if(tr == 0 && tc == -1) break point;
                Tornado(tr, tc, 0);
                cur++;
            }

            // 밑
            cur = 1;
            while (distance >= cur) {
                tr++;
                Tornado(tr, tc, 1);
                cur++;

            }

            distance++;

            // 오
            cur = 1;
            while (distance >= cur) {
                tc++;
                Tornado(tr, tc, 2);
                cur++;
            }

            // 위
            cur = 1;
            while (distance >= cur) {
                tr--;
                Tornado(tr, tc, 3);
                cur++;
            }

            distance++;
        }

        System.out.println(ans);
    }

    public static void Tornado(int yr, int yc, int dir) {
        // 원래 배열과 합치고 싶은 tor 만들기
        int sand = A[yr][yc];
        A[yr][yc] = 0;
        int[][] tor = new int[5][5];
        int[][] dirTor = new int[5][5];
        int temp = 0; // 모래 합
        if(dir == 0) dirTor = left;
        if(dir == 1) dirTor = down;
        if(dir == 2) dirTor = right;
        if(dir == 3) dirTor = up;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(dirTor[i][j] == 0) continue;
                tor[i][j] = sand * dirTor[i][j] / 100;
                temp += tor[i][j];
            }
        }
        // alpha 구하기
        if(dir == 0) tor[2][1] = sand - temp;
        if(dir == 1) tor[3][2] = sand - temp;
        if(dir == 2) tor[2][3] = sand - temp;
        if(dir == 3) tor[1][2] = sand - temp;

//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                sb.append(tor[i][j]);
//                sb.append(" ");
//            }
//            sb.append("\n");
//        }
//        System.out.println(sb);

        // 원래 배열과 합치기
        // start r = yr - 2
        // start c = yc - 2
        int startR = yr - 2;
        int startC = yc - 2;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (startR + i < 0 || startC + j < 0 || startR + i >= N || startC + j >= N) {
                    ans += tor[i][j];
                } else {
                    A[startR + i][startC + j] += tor[i][j];
                }
            }
        }

//        print();

    }

    public static void main(String[] args) {
        input();
    }

    public static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(A[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
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
