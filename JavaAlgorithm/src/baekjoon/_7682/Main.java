package baekjoon._7682;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;

    public static void input() {
        FastReader fr = new FastReader();
        while (true) {
            String s = fr.nextLine();
            if (s.equals("end")) return;
            pro(s);
        }
    }

    public static void pro(String s) {
map = new char[3][3];
int x = 0;
int o = 0;
int dot = 0;

for (int i = 0; i < 9; i++) {
    map[i / 3][i % 3] = s.charAt(i);
    if (s.charAt(i) == 'X') x++;
    if (s.charAt(i) == 'O') o++;
    if (s.charAt(i) == '.') dot++;
}

if (x > 5 || x < 3 || o > 4 || o < 2){ System.out.println("invalid"); return;}


// 경기 끝났는지 확인
// 모두 채워졌을 경우
if (dot == 0 && x == 5 && o == 4) {
    // o 이 이기지 않아야 함
    if (judge('O')) {
        System.out.println("invalid");
        return;
    }

    System.out.println("valid");
    return;
}

// 누군가 이겼을 경우
// X가 이겼을 때
if (judge('X') && !judge('O')) {
    if(x == o + 1) {
        System.out.println("valid");
        return;
    }
} else if (!judge('X') && judge('O')) {
    if (x == o) {
        System.out.println("valid");
        return;
    }
}

System.out.println("invalid");
    }

    public static boolean judge(char c) {
        for(int i=0; i<3; i++) {
            if(map[i][0] == c && map[i][1] == c && map[i][2] == c) {
                return true;
            }
        }
        // 세로 
        for(int i=0; i<3; i++) {
            if(map[0][i] == c && map[1][i] == c && map[2][i] == c) {
                return true;
            }
        }
        // 대각선 
        if(map[0][0] == c && map[1][1] == c && map[2][2] == c) {
            return true;
        }

        if(map[2][0] == c && map[1][1] == c && map[0][2] == c) {
            return true;
        }

        return false;
    }


    public static void main(String[] args) {
        input();
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
