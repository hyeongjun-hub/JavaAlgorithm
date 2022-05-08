package baekjoon._13410;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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

    static int first, last;
    static ArrayList<Integer> letters = new ArrayList<>();


    public static void input() {
        FastReader fr = new FastReader();
        first = fr.nextInt();
        last = fr.nextInt();
    }

    public static void main(String[] args) {
        input();
        int[] gugudan = new int[last + 1];
        for (int i = 1; i <= last; i++) {
            int firstResult = first * i;
            while (firstResult > 0) {
                letters.add(firstResult % 10);
                firstResult /= 10;
            }
            StringBuilder temp = new StringBuilder();
            while (letters.size() > 0) {
                int oneNum = letters.remove(0);
                temp.append(oneNum);
            }
            gugudan[i] = Integer.parseInt(temp.toString());
        }
        System.out.println(Arrays.stream(gugudan).max().getAsInt());

    }
}
