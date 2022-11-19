package baekjoon._17144;

import java.util.*;
import java.io.*;

class Main {
    static int R, C, T;
    static int[][] arr = new int[50][50];
    static List<Integer> airCleanerRows = new ArrayList<>();
    static int sumOfDust = 2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // input
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                sumOfDust += arr[i][j];

                if (arr[i][j] == -1) {
                    airCleanerRows.add(i);
                }
            }
        }

        // Solution
        solution();
    }

    static void solution() {
        while (T-- > 0) {
            // 1. 먼지 확산
            arr = spreadDust();

            // 2. 공기청정기 가동
            executeAirCleaner();
        }

        System.out.println(calculateSum());
    }

    static int[][] spreadDust() {
        int[][] temp = new int[50][50];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 확산된 미세먼지를 temp 배열에 계산
        for (int x = 0; x < R; x++) {
            for (int y = 0 ; y < C; y++) {
                if (arr[x][y] == -1) {
                    temp[x][y] = -1;
                    continue;
                }

                temp[x][y] += arr[x][y];

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                    if (arr[nx][ny] == -1) continue;

                    temp[nx][ny] += (arr[x][y] / 5);
                    temp[x][y] -= (arr[x][y] / 5);
                }
            }
        }

        return temp;
    }

    static void executeAirCleaner() {
        // 위쪽 공기청정기는 반시계방향
        int top = airCleanerRows.get(0);

        for (int x = top - 1; x > 0; x--) {
            arr[x][0] = arr[x-1][0];
        }

        for (int y = 0; y < C - 1; y++) {
            arr[0][y] = arr[0][y+1];
        }

        for (int x = 0; x < top; x++) {
            arr[x][C-1] = arr[x+1][C-1];
        }

        for (int y = C - 1; y > 1; y--) {
            arr[top][y] = arr[top][y-1];
        }

        arr[top][1] = 0;


        // 아래쪽 공기청정기는 시계 방향
        int bottom = airCleanerRows.get(1);

        for (int x = bottom + 1; x < R - 1; x++) {
            arr[x][0] = arr[x+1][0];
        }

        for (int y = 0; y < C - 1; y++) {
            arr[R-1][y] = arr[R-1][y+1];
        }

        for (int x = R - 1; x > bottom; x--) {
            arr[x][C-1] = arr[x-1][C-1];
        }

        for (int y = C - 1; y > 1; y--) {
            arr[bottom][y] = arr[bottom][y-1];
        }

        arr[bottom][1] = 0;
    }

    static int calculateSum() {
        int sum = 2;

        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                sum += arr[x][y];
            }
        }

        return sum;
    }
}

//
///*
//미세먼지 안녕!
//(Simulation)
// */
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class Main {
//
//    static int R, C, T, time =  0, ans;
//    static int[][] A;
//    static int robot;
//    static Queue<int[]> queue = new LinkedList<>();
//    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
//
//
//    public static void input() {
//        FastReader fr = new FastReader();
//        R = fr.nextInt();
//        C = fr.nextInt();
//        T = fr.nextInt();
//        A = new int[R + 1][C + 1];
//
//        for (int i = 1; i <= R; i++) {
//            for (int j = 1; j <= C; j++) {
//                A[i][j] = fr.nextInt();
//                if(A[i][j] == -1) robot = i;
//                if(A[i][j] > 0) queue.add(new int[]{i, j, 0});
//            }
//        }
//    }
//
//    public static void plus(int[][] plus){
//        for (int i = 1; i <= R; i++) {
//            for (int j = 1; j <= C; j++) {
//                A[i][j] += plus[i][j];
//            }
//        }
//    }
//
//    public static void diffusion() {
//        while (!queue.isEmpty()) {
//            int[] poll = queue.poll();
//            int r = poll[0];
//            int c = poll[1];
//            if(A[r][c] < 5) continue;
//            int amountOfSpread = A[r][c] / 5;
//            int cnt = 0;
//            for (int i = 0; i < 4; i++) {
//                int nr = r + dir[i][0];
//                int nc = c + dir[i][1];
//
//                if(nr < 1 || nc < 1 || nr > R || nc > C) continue;
//                if(A[nr][nc] == -1) continue;
//                A[nr][nc] += amountOfSpread;
//                ++cnt;
//            }
//            A[r][c] -= amountOfSpread * cnt;
//        }
//    }
//
//    public static void upperAir() {
//        int robotR = robot + 1;
//        Queue<Integer> mj = new LinkedList<>();
//        mj.add(0);
//        // 가로 빼기
//        for (int i = 2; i <= C; i++) {
//            mj.add(A[robotR][i]);
//        }
//        // 가로 넣기
//        for (int i = 2; i <= C; i++) {
//            A[robotR][i] = mj.poll();
//        }
//        // 세로 빼기
//        for (int i = robotR; i >= 1; i--) {
//            mj.add(A[i][C]);
//        }
//        // 세로 넣기
//        for (int i = robotR; i >= 1; i--) {
//            A[i][C] = mj.poll();
//        }
//        // 가로 빼기
//        for (int i = C; i >= 1; i--) {
//            mj.add(A[1][i]);
//        }
//        // 가로 넣기
//        for (int i = C; i >= 1; i--) {
//            A[1][i] = mj.poll();
//        }
//        // 세로 빼기
//        for (int i = 1; i <= robotR; i++) {
//            mj.add(A[i][1]);
//        }
//        // 세로 넣기
//        for (int i = 1; i < robotR; i++) {
//            A[i][1] = mj.poll();
//        }
//    }
//
//    public static void downAir() {
//        int robotR = robot;
//        Queue<Integer> mj = new LinkedList<>();
//        mj.add(0);
//        // 가로 빼기
//        for (int i = 2; i <= C; i++) {
//            mj.add(A[robotR][i]);
//        }
//        // 가로 넣기
//        for (int i = 2; i <= C; i++) {
//            A[robotR][i] = mj.poll();
//        }
//        // 세로 빼기
//        for (int i = robotR; i <= R; i++) {
//            mj.add(A[i][C]);
//        }
//        // 세로 넣기
//        for (int i = robotR; i <= R; i++) {
//            A[i][C] = mj.poll();
//        }
//        // 가로 빼기
//        for (int i = C; i >= 1; i--) {
//            mj.add(A[R][i]);
//        }
//        // 가로 넣기
//        for (int i = C; i >= 1; i--) {
//            A[R][i] = mj.poll();
//        }
//        // 세로 빼기
//        for (int i = R; i >= robotR; i--) {
//            mj.add(A[i][1]);
//        }
//        // 세로 넣기
//        for (int i = R; i > robotR; i--) {
//            A[i][1] = mj.poll();
//        }
//    }
//
//    public static void printAll() {
//        for (int i = 1; i <= R; i++) {
//            for (int j = 1; j <= C; j++) {
//                System.out.print(A[i][j]);
//                System.out.print(' ');
//            }
//            System.out.println();
//        }
//    }
//
//    public static void print() {
//        for (int i = 1; i <= R; i++) {
//            for (int j = 1; j <= C; j++) {
//                if(A[i][j] == -1) continue;
//                ans += A[i][j];
//            }
//        }
//        System.out.println(ans);
//    }
//
//    public static void pro() {
//        while (time < T) {
//            getCheckDust();
//            diffusion();
//            operate();
////            upperAir();
////            downAir();
//            time++;
////            printAll();
//        }
//    }
//
//    private static void operate() {
//        int top = robot - 1;
//        int down = robot;
//
//        for (int i = top - 1; i > 1; i--) {    // 내려오는 방향
//            A[i][1] = A[i - 1][1];
//        }
//        for (int i = 1; i < C; i++) {   // <-
//            A[1][i] = A[1][i + 1];
//        }
//        for (int i = 1; i < top; i++) {    // 올라오는 방향
//            A[i][C] = A[i + 1][C];
//        }
//        for (int i = C; i > 2; i--) {   // ->
//            A[top][i] = A[top][i - 1];
//        }
//        A[top][2] = 0;
//
//        for (int i = down + 1; i < R; i++) {
//            A[i][1] = A[i + 1][1];
//        }
//        for (int i = 0; i < C; i++) {
//            A[R][i] = A[R][i + 1];
//        }
//        for (int i = R; i > down; i--) {
//            A[i][C] = A[i - 1][C];
//        }
//        for (int i = C; i > 2; i--) {
//            A[down][i] = A[down][i - 1];
//        }
//        A[down][2] = 0;
//    }
//
//    private static void getCheckDust() {
//        queue = new LinkedList<>();
//
//        for (int i = 1; i <= R; i++) {
//            for (int j = 1; j <= C; j++) {
//                if(A[i][j] == -1 || A[i][j] == 0) continue;
//                queue.add(new int[]{i, j, time});
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        input();
//        pro();
//        print();
//    }
//
//    static class FastReader {
//        BufferedReader br;
//        StringTokenizer st;
//
//        public FastReader(){ br = new BufferedReader(new InputStreamReader(System.in));}
//
//        String next(){
//            while(st == null || !st.hasMoreTokens()){
//                try{
//                    st = new StringTokenizer(br.readLine());
//                } catch (IOException e){
//                    e.printStackTrace();
//                }
//            }
//            return st.nextToken();
//        }
//
//        int nextInt() { return Integer.parseInt(next()); }
//
//        long nextLong() { return Long.parseLong(next()); }
//
//        Double nextDouble() { return Double.parseDouble(next()); }
//
//        String nextLine(){
//            String str = "";
//            try{
//                str = br.readLine();
//            } catch(IOException e){
//                e.printStackTrace();
//            }
//            return str;
//        }
//    }
//}
