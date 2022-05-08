package baekjoon._10448;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
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

    static StringBuilder sb = new StringBuilder();
    static int[] numList;

    public static void eureka(int num) {
        for (int i = 1; i <= 45; i++) {
            numList[i] = i * (i + 1) / 2;
        }
        for (int i = 1; i <= 45; i++) {
            for (int j = 1; j <= 45; j++) {
                for (int k = 1; k <= 45; k++) {
                    if (numList[i] + numList[j] + numList[k] == num) {
                        sb.append(1).append("\n");
                        return;
                    }
                }
            }
        }
        sb.append(0).append("\n");
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int repeat = fr.nextInt();
        numList = new int[46];
        for (int i = 0; i < repeat; i++) {
            int num = fr.nextInt();
            eureka(num);
        }
        System.out.println(sb);
    }
}
