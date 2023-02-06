package baekjoon._1092;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, num;
    static List<Integer> cranes, boxes;
    static boolean[] visit;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        cranes = new ArrayList<>();
        boxes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            cranes.add(fr.nextInt());
        }
        M = fr.nextInt();
        for (int i = 0; i < M; i++) {
            boxes.add(fr.nextInt());
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    public static void pro() {
        cranes.sort(Comparator.reverseOrder());
        boxes.sort(Comparator.reverseOrder());

        int ans = 0;
        if (cranes.get(0) < boxes.get(0)) {
            System.out.println(-1);
            return;
        }
        while (!boxes.isEmpty()) {
            ans++;
            for (Integer crane : cranes) {
                for (int i = 0; i < boxes.size(); i++) {
                    if (crane >= boxes.get(i)) {
                        boxes.remove(i);
                        break;
                    }
                }
            }
        }
        System.out.println(ans);
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
