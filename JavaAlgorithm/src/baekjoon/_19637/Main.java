package baekjoon._19637;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static String[] title;
    static int[] character, power;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        M = fr.nextInt();
        title = new String[N];
        power = new int[N];
        for (int i = 0; i < N; i++) {
            title[i] = fr.next();
            power[i] = fr.nextInt();
        }
        character = new int[M];
        for (int i = 0; i < M; i++) {
            character[i] = fr.nextInt();
        }

    }

    public static void pro() {
        for (int point : character) {
            int L = 0;
            int R = N - 1;
            binarySearch(L, R, point);
        }
    }

    private static void binarySearch(int L, int R, int point) {
        int result = L - 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (point > power[mid]) {
                result = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        sb.append(title[result + 1]).append("\n");
    }

    public static void main(String[] args) {
        input();
        pro();
        System.out.println(sb);
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
