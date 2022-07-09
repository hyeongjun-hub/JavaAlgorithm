package baekjoon._11057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    StringBuilder sb = new StringBuilder();

    static int N;
    static int[][] Dy;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        Dy = new int[N + 1][10];
    }

    public static void pro() {
        for (int last = 0; last < 10; last++) {
            Dy[1][last] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int last = 0; last < 10; last++) {
                if (last == 0) Dy[i][last] = 1;
                else {
                    int sum = 0;
                    for (int j = 0; j <= last; j++) sum += Dy[i - 1][j];
                    Dy[i][last] = sum % 10007;
                }
            }
        }

        int answer = 0;
        for (int i : Dy[N]) {
            answer += i;
            answer %= 10007;
        }
        System.out.println(answer);
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        Double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
