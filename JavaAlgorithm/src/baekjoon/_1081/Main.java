package baekjoon._1081;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    static int L;
    static int U;

    public static void input() {
        FastReader fr = new FastReader();
        L = fr.nextInt();
        U = fr.nextInt();
    }

    public static void main(String[] args) {
        input();
        long result = 0;

        if (U - L < 10) {
            for (int i = L; i <= U; i++) {
                int k = i;
                while (k >= 1) {
                    int addOne = k % 10;
                    result += addOne;
                    k /= 10;
//                    if (k < 10) break;
                }
            }
        } else {
//            int ten = (U) / 10;
//            int one = (U) % 10;
//            int last = 0;
//            for (int i = 0; i < one; i++) {
//                last += i;
//            }
//            result += (ten - 1) * 45L;
//            result += (long) ((U - L) / 10 % 10) * last;
        }


        System.out.println(result);
    }
}
