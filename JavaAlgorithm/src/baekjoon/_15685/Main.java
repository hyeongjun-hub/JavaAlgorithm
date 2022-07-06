package baekjoon._15685;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] dir = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    static ArrayList<int[]> ans = new ArrayList<>();
    static Init[] inits;
    static boolean map[][] = new boolean[102][102];
    static class Init {
        int x, y, d, g;

        public Init(int x, int y, int d, int g) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.g = g;
        }
    }

    static class Curve {
        ArrayList<int[]> nodes = new ArrayList<>();
        int[] point;
    }

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        inits = new Init[N];
        for (int i = 0; i < N; i++) {
            inits[i] = new Init(fr.nextInt(), fr.nextInt(), fr.nextInt(), fr.nextInt());
            makeCurve(inits[i]);
        }
    }

    private static void makeCurve(Init init) {
        // 0세대 선분(Curve) 만들기
        int y = init.y;
        int x = init.x;
        int ny = y + dir[init.d][0];
        int nx = x + dir[init.d][1];

        Curve curve = new Curve();
        curve.nodes.add(new int[]{y, x});
        curve.nodes.add(new int[]{ny, nx});
        curve.point = new int[]{ny, nx};

        // 각 세대마다 Curve 업데이트
        for (int i = 1; i <= init.g; i++) {
            int sy = curve.point[0];
            int sx = curve.point[1];
            for (int j = curve.nodes.size() - 2; j >= 0; j--) {
                ny = curve.nodes.get(j)[0];
                nx = curve.nodes.get(j)[1];
                int nny = sy - (sx - nx);
                int nnx = sx + (sy - ny);
                curve.nodes.add(new int[]{nny, nnx});
                if(j==0) curve.point = new int[]{nny, nnx};
            }
        }

        // ans에 추가
        for (int[] node : curve.nodes) {
            ans.add(node);
        }
    }

    public static void main(String[] args) {
        input();
        calculate();
    }

    private static void calculate() {
        // 반복 끝나면 ans 정사각형 계산
//        for (int[] an : ans) {
//            System.out.print(an[1]);
//            System.out.print(' ');
//            System.out.print(an[0]);
//            System.out.println();
//        }

        for (int[] an : ans) {
            map[an[0]][an[1]] = true;
        }
        int rect = 0;
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) {
                    rect++;
                }
            }
        }
        System.out.println(rect);
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
