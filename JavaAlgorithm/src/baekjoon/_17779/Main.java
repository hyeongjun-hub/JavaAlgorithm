package baekjoon._17779;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, total, min;
    static int[][] A;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        A = new int[N+1][N+1];
        min = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                A[i][j] = fr.nextInt();
                total += A[i][j];
            }
        }

        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {
                for (int d1 = 1; d1 <= N; d1++) {
                    for (int d2 = 1; d2 <= N; d2++) {
                        if (d1 + d2 + x > N) continue;
                        if (y - d1 < 1 || y + d2 > N) continue;
                        makeBoundary(x, y, d1, d2);
                    }
                }
            }
        }
        System.out.println(min);
    }

    private static void makeBoundary(int x, int y, int d1, int d2) {
        int[][] B = new int[N + 1][N + 1];

        for (int i = 0; i <= d1; i++) {
            B[x+i][y-i] = 5;
            B[x+d2+i][y+d2-i] = 5;
        }
        for (int i = 0; i <= d2; i++) {
            B[x+i][y+i] = 5;
            B[x+d1+i][y-d1+i] = 5;
        }

        int[] rating = new int[5];

        boolean start = false;
        for (int i = x + 1; i < x + d1 + d2; i++) {
            for (int j = 1; j <= N; j++) {
                if(start) {
                    if (B[i][j] == 5) {
                        start = false;
                        break;
                    }
                    B[i][j] = 5;
                }

                if (B[i][j] == 5) {
                    start = true;
                }
            }
        }

        // 1
        for (int i = 1; i <= x + d1; i++) {
            for (int j = 1; j <= y; j++) {
                if(B[i][j] == 5) continue;
                B[i][j] = 1;
                rating[0] = A[i][j];
            }
        }
        //2
        for (int i = 1; i <= x + d2; i++) {
            for (int j = y+1; j <= N; j++) {
                if(B[i][j] == 5) continue;
                B[i][j] = 2;
                rating[1] += A[i][j];
            }
        }
        //3
        for (int i = x+d1; i <= N; i++) {
            for (int j = 1; j < y - d1 + d2; j++) {
                if(B[i][j] == 5) continue;
                B[i][j] = 3;
                rating[2] += A[i][j];
            }
        }
        //4
        for (int i = x+d2+1; i <= N; i++) {
            for (int j = y-d1+d2; j <= N; j++) {
                if(B[i][j] == 5) continue;
                B[i][j] = 4;
                rating[3] += A[i][j];
            }
        }
        //5
        rating[4] = total;
        for (int i = 0; i < 4; i++) {
            rating[4] -= rating[i];
        }

        int diff = getDiff(B);
        min = Math.min(min, diff);
//        Arrays.sort(rating);
//        min = Math.min(min, rating[4] - rating[0]);
    }

    public static int getDiff(int[][] check) {
        int[] sum = new int[5];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sum[check[i][j]-1] += A[i][j];
            }
        }
        Arrays.sort(sum);
        return sum[4] - sum[0];
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
