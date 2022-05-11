package baekjoon._1526;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;

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

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
    }

    public static void main(String[] args) {
        input();
        while (N > 0) {
            String str = Integer.toString(N);
            char[] chars = str.toCharArray();
            boolean gold = true;
            for (char aChar : chars) {
                if (aChar != '4' && aChar != '7') {
                    gold = false;
                    break;
                }
            }
            if (gold) {
                System.out.println(N);
                return;
            }
            N--;
        }
    }
}
