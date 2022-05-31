package baekjoon._14503;

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

    static int row, column;
    static int robotR, robotC;
    static int direction;
    static int[][] space;

    public static void input() {
        FastReader fr = new FastReader();
        row = fr.nextInt();
        column = fr.nextInt();
        space = new int[row + 1][column + 1];
        robotR = fr.nextInt();
        robotC = fr.nextInt();
        direction = fr.nextInt();
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                space[i][j] = fr.nextInt();
            }
        }
    }

    public static void main(String[] args) {
        input();
        int answer = 0;
        while (true) {
            if (space[robotR][robotC] == 0) {
                answer++;
                space[robotR][robotC] = 2;
            }
            boolean variation = false;
            if (direction == 0) {
                direction = 3;
                if (space[robotR][robotC - 1] == 0) {
                    robotC--;
                    variation = true;
                }
            } else if(direction == 1) {
                direction = 0;
                if (space[robotR - 1][robotC] == 0) {
                    robotR--;
                    variation = true;
                }
            } else if (direction == 2) {
                direction = 1;
                if (space[robotR][robotC + 1] == 0) {
                    robotC++;
                    variation = true;
                }
            } else if (direction == 3) {
                direction = 2;
                if (space[robotR + 1][robotC] == 0) {
                    robotR++;
                    variation = true;
                }
            }
            if(!variation) {
                if(direction == 0 && space[robotR+1][robotC] != 1){
                    robotR++;
                } else if(direction == 1 && space[robotR][robotC+1] != 1){
                    robotC++;
                } else if (direction == 2 && space[robotR - 1][robotC] != 1) {
                    robotR--;
                } else if (direction == 3 && space[robotR][robotC - 1] != 1) {
                    robotC--;
                } else {
                    break;
                }
            }
        }
        System.out.println(answer);

    }
}
